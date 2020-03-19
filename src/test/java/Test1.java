import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.posts.Post;
import model.users.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Test1 {
    float FLOAT_DELTA = 0.01f;
    String ACTIVITY_STRING_REGEX = "^.+[\\s]napisał\\(a\\)[\\s][\\d]+[\\s]postów$";

    private static SolutionProvider solutionProvider;

    private List<String> userNames = List.of("Bret", "Antonette", "Samantha", "Karianne",
            "Kamren", "Leopoldo_Corkery", "Elwyn.Skiles", "Maxime_Nienow", "Delphine", "Moriah.Stanton");

    private List<Integer> userActivityCount = List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

    private static List<String> usersActivity;



    private int nonUniqueTitlesCount = 0;
    private boolean areTitlesUnique = true;

    private static List<String> nonUniqueTitles;


    private static Map<User, User> closestUsers; //received
    private static Map<Integer, Integer> expectedClosestUserIds = Map.of(   1, 5,
                                                                            6, 10,
                                                                            7, 5,
                                                                            9, 4,
                                                                            3, 2,
                                                                            4, 9,
                                                                            5, 10,
                                                                            8, 4,
                                                                            2, 3,
                                                                            10, 5); //expected

    @BeforeAll
    public static void prepareSolution() throws IOException {
        solutionProvider = Main.getSolution();

        usersActivity = solutionProvider.getUsersActivity();
        nonUniqueTitles = solutionProvider.getNonUniquePostTitles();
        closestUsers = solutionProvider.getNearestUsers();
    }

    //Part 1

    @Test
    public void checkUserLoading(){
        User user = solutionProvider.getUsers().get(1); //returns user with id 1
        assertEquals(1, user.getId() );
        assertEquals("Leanne Graham", user.getName() );
        assertEquals("Bret", user.getUsername() );
        assertEquals("Sincere@april.biz", user.getEmail());
        assertEquals("Kulas Light", user.getAddress().getStreet() );
        assertEquals("Apt. 556", user.getAddress().getSuite() );
        assertEquals("Gwenborough", user.getAddress().getCity() );
        assertEquals("92998-3874", user.getAddress().getZipcode() );
        assertTrue( Math.abs(-37.3159 - user.getAddress().getGeo().getLat()) < FLOAT_DELTA );
        assertTrue( Math.abs(81.1496 - user.getAddress().getGeo().getLng()) < FLOAT_DELTA );
        assertEquals("1-770-736-8031 x56442", user.getPhone() );
        assertEquals("hildegard.org", user.getWebsite() );
        assertEquals("Romaguera-Crona", user.getCompany().getName());
        assertEquals("Multi-layered client-server neural-net", user.getCompany().getCatchPhrase() );
        assertEquals("harness real-time e-markets", user.getCompany().getBs() );
    }

    @Test
    public void checkPostLoading(){
        Post post = solutionProvider.getUsers().get(1).getPosts()
                .stream()
                .filter(p -> p.getId() == 1)
                .collect(Collectors.toList()).get(0);

        assertEquals(1, post.getId());
        assertEquals(1, post.getUserId() );
        assertEquals( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.getTitle());
        assertEquals(
                "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\n" +
                        "reprehenderit molestiae ut ut quas totam" +
                        "\nnostrum rerum est autem sunt rem eveniet architecto", post.getBody());
    }

    @Test
    public void checkUser1PostLinkage(){
        solutionProvider.getUsers().values()
                .forEach(user -> {
                    user.getPosts()
                            .forEach(post -> {
                                assertEquals(user.getId(), post.getUserId());
                            });
                });

    }


    //Part 2
    @Test
    public void userActivityCheckFormat() throws IOException {
        //check if all entries satisfy expected format
        for(String record: usersActivity){
            assertTrue(record.matches(ACTIVITY_STRING_REGEX));
        }
    }
    @Test
    public void checkUser1Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(0)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(0), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void checkUser2Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(1)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(1), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void checkUser3Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(2)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(2), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser4Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(3)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(3), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser5Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(4)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(4), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser6Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(5)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(5), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser7Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(6)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(6), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser8Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(7)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(7), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void checkUser9Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(8)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(8), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void checkUser10Activity(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(9)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(9), Integer.parseInt(record.split(" ")[2])));
    }



    //Part 3

    @Test
    public void nonUniqueTitlesCountCheck(){
        assertEquals(nonUniqueTitlesCount, nonUniqueTitles.size());
    }
    @Test
    public void nonUniqueTitlesCheck(){
        assertEquals(nonUniqueTitlesCount, nonUniqueTitles.size());
    }



    //Part 4

    @Test
    public void checkUser1ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 0)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser2ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 1)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser3ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 2)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser4ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 3)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser5ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 4)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser6ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 5)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser7ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 6)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser8ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 7)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser9ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 8)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void checkUser10ClosestUser(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 9)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

}