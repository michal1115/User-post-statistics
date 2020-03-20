import model.posts.Post;
import model.users.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DataExtractionTests {
    float FLOAT_DELTA = 0.01f;

    private static SolutionProvider solutionProvider;

    @BeforeAll
    public static void prepareSolution() throws IOException {
        solutionProvider = Main.getSolution();
    }

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
    public void checkUserPostLinkage(){
        solutionProvider.getUsers().values()
                .forEach(user -> {
                    user.getPosts()
                            .forEach(post -> {
                                assertEquals(user.getId(), post.getUserId());
                            });
                });

    }
}
