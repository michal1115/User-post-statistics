import model.users.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserActivityTests {

    String ACTIVITY_STRING_REGEX = "^.+[\\s]napisał\\(a\\)[\\s][\\d]+[\\s]postów$";

    private static SolutionProvider solutionProvider;

    private List<String> userNames = List.of("Bret", "Antonette", "Samantha", "Karianne",
            "Kamren", "Leopoldo_Corkery", "Elwyn.Skiles", "Maxime_Nienow", "Delphine", "Moriah.Stanton");

    private List<Integer> userActivityCount = List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

    private static List<String> usersActivity;

    @BeforeAll
    public static void prepareSolution() throws IOException {
        solutionProvider = Main.getSolution();

        usersActivity = solutionProvider.getUsersActivity();
    }

    @Test
    public void userActivityFormatTest() throws IOException {
        //check if all entries satisfy expected format
        for(String record: usersActivity){
            assertTrue(record.matches(ACTIVITY_STRING_REGEX));
        }
    }
    @Test
    public void user1ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(0)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(0), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void user2ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(1)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(1), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void user3ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(2)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(2), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user4ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(3)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(3), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user5ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(4)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(4), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user6ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(5)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(5), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user7ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(6)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(6), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user8ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(7)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(7), Integer.parseInt(record.split(" ")[2])));
    }

    @Test
    public void user9ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(8)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(8), Integer.parseInt(record.split(" ")[2])));
    }
    @Test
    public void user10ActivityTest(){
        usersActivity.stream()
                .filter(record -> record.split(" ")[0].equals(userNames.get(9)))
                .forEach(record -> assertEquals(
                        userActivityCount.get(9), Integer.parseInt(record.split(" ")[2])));
    }

}
