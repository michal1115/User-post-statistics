import model.users.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDistanceTests {

    private static SolutionProvider solutionProvider;

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

        closestUsers = solutionProvider.getNearestUsers();
    }

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
