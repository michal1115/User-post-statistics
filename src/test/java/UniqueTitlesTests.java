import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueTitlesTests {
    private static SolutionProvider solutionProvider;


    private int nonUniqueTitlesCount = 0;
    private boolean areTitlesUnique = true;

    private static List<String> nonUniqueTitles;


    @BeforeAll
    public static void prepareSolution() throws IOException {
        solutionProvider = Main.getSolution();

        nonUniqueTitles = solutionProvider.getNonUniquePostTitles();
    }

    @Test
    public void nonUniqueTitlesCountCheck(){
        assertEquals(nonUniqueTitlesCount, nonUniqueTitles.size());
    }
    @Test
    public void nonUniqueTitlesCheck(){
        assertEquals(nonUniqueTitlesCount, nonUniqueTitles.size());
    }
}
