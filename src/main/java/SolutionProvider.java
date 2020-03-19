import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import exceptions.NonExistingUserPostInsertionException;
import exceptions.UserAlreadyInsertedException;
import lombok.Getter;
import lombok.SneakyThrows;
import model.posts.Post;
import model.users.User;
import utils.DistanceCounter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class SolutionProvider {

    private Map<Integer, User> users = new HashMap<Integer, User> ();//this map provides faster searching for user
    // by id, so Post insertion is faster
    private Map<String, LinkedList<Post>> postsWithGivenTitles = new HashMap<String, LinkedList<Post>> ();//this map is used to find unique
    // Posts faster, by just iterating through all keys and finding those titles that only occured in one post

    private User jsonObjectToUser(JsonObject userJson){
        return new User(userJson);
    }

    private Post jsonObjectToPost(JsonObject postJson){
        return new Post(postJson);
    }

    @SneakyThrows
    public void addToUsers(User user){
        if (users.containsKey(user.getId())){
            throw new UserAlreadyInsertedException();
        }
        users.put(user.getId(), user);
    }

    @SneakyThrows
    public void addToUsers(Post post){
        if (! users.containsKey(post.getUserId())){
            throw new NonExistingUserPostInsertionException(users, post);
        }
        users.get(post.getUserId())
                .addPost(post);
    }

    @SneakyThrows
    public void addToPostsWithGivenTitles(Post post){
        if (! postsWithGivenTitles.containsKey(post.getTitle())){
            postsWithGivenTitles.put(post.getTitle(), new LinkedList<Post>());
        }
        postsWithGivenTitles
                .get(post.getTitle())
                .add(post);
    }




    public SolutionProvider(JsonArray usersAsJsonArray, JsonArray postsAsJsonArray){
        //operating on users:
        usersAsJsonArray.forEach(json -> {
            User user = jsonObjectToUser(json.getAsJsonObject());

            addToUsers(user);
        });

        //operating on posts:
        postsAsJsonArray.forEach(json -> {
            Post post = jsonObjectToPost(json.getAsJsonObject());

            addToUsers(post);

            addToPostsWithGivenTitles(post);
        });
    }




    public List<String> getUsersActivity(){
        List<String> results = new LinkedList<String>();

        users.keySet()
                .forEach(key -> results
                        .add(String.format("%s napisał(a) %d postów",
                        users.get(key).getUsername(),
                        users.get(key).getPosts().size())));

        return results;
    }

    public List<String> getNonUniquePostTitles(){
        List<String> results = new LinkedList<String>();

        postsWithGivenTitles.keySet()
                .stream()
                .filter(key -> postsWithGivenTitles.get(key).size() > 1)
                .forEach(results::add);

        return results;
    }

    public boolean arePostsUnique(){
        List<String> results = new LinkedList<String>();

        postsWithGivenTitles.keySet()
                .stream()
                .filter(key -> postsWithGivenTitles.get(key).size() > 1)
                .forEach(results::add);

        return results.size() == 0;
    }


    public Map<User, User> getNearestUsers(){
        Map<User, User> results = new HashMap<User, User>();

        users.values().stream()
                .forEach(user1 -> {
                    List<User> otherUsers = users.values()
                            .stream()
                            .filter(user -> user != user1)
                            .collect(Collectors.toList());

                    double minDist = DistanceCounter.getDistance(user1, otherUsers.get(0) );
                    User minDistUser = otherUsers.get(0);

                    for(User user: otherUsers){
                        if (DistanceCounter.getDistance(user1, user) < minDist){
                            minDist = DistanceCounter.getDistance(user1, user);
                            minDistUser = user;
                        }
                    }

                    results.put(user1, minDistUser);
                });

        return results;
    }
}
