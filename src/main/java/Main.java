import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.JsonArray;
import config.ConfigProvider;
import exceptions.InvalidEmailFormatException;
import exceptions.InvalidLatitudeException;
import exceptions.InvalidLongitudeException;
import exceptions.NonExistingUserPostInsertionException;
import model.posts.Post;
import model.users.User;
import org.yaml.snakeyaml.Yaml;
import request.DataProvider;
import utils.FileSearch;


public class Main {
    public static Optional<ConfigProvider> loadUrlsConfig() throws IOException {
        Optional<String> configFileLocation = FileSearch.fileRecursiveSearch(".", "UrlsConfig.yaml");

        if(configFileLocation.isPresent()) {
            //load yaml and so on
            Yaml yaml = new Yaml();
            File file = new File(configFileLocation.get());

            BufferedReader br = new BufferedReader(new FileReader(file));

            StringBuilder configBuilder = new StringBuilder();
            String nextLine = br.readLine();
            while (nextLine != null) {
                configBuilder.append(nextLine + "\n");
                nextLine = br.readLine();
            }
            ConfigProvider configProvider = yaml.loadAs(configBuilder.toString(), ConfigProvider.class);

            return Optional.of(configProvider);
        }

        return Optional.empty();
    }

    public static SolutionProvider getSolution() throws IOException {
        String postsUrlString;
        String usersUrlString;

        Optional<ConfigProvider> configProvider = loadUrlsConfig();

        if (configProvider.isPresent()){
            postsUrlString = configProvider.get().getPostsUrl();
            usersUrlString = configProvider.get().getUsersUrl();
        }
        else{
            System.out.println("[LOG]No configuration file found (\"config.yaml\").\n " +
                    "Using default url's");
            postsUrlString = "https://jsonplaceholder.typicode.com/posts";
            usersUrlString = "https://jsonplaceholder.typicode.com/users";
        }




        JsonArray postsAsJson = DataProvider.getData(postsUrlString);
        JsonArray usersAsJson = DataProvider.getData(usersUrlString);

        return new SolutionProvider(usersAsJson, postsAsJson);
    }
    public static void main(String[] args) throws IOException, InvalidLatitudeException, InvalidLongitudeException, InvalidEmailFormatException {

        SolutionProvider solutionProvider = getSolution();

        System.out.println(solutionProvider.getUsersActivity());
        System.out.println(solutionProvider.getNonUniquePostTitles());
        solutionProvider.getNearestUsers()
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey().getUsername() +  " " + entry.getValue().getUsername() ));

        solutionProvider.getNearestUsers()
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey().getId() +  " " + entry.getValue().getId() ));
    }
}
