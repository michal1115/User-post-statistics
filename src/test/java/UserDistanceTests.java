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
    public void user1ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 0)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user2ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 1)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user3ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 2)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user4ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 3)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user5ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 4)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user6ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 5)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user7ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 6)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user8ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 7)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user9ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 8)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }

    @Test
    public void user10ClosestUserTest(){
        closestUsers.values().stream()
                .filter(user -> user.getId() == 9)
                .forEach(user -> {
                    assertEquals(expectedClosestUserIds.get(user.getId()), closestUsers.get(user).getId());
                });
    }
}
