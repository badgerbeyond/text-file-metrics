import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextFileMetricsTest {
    @Test
    void providedExampleTest() {
        TextFileMetrics.main(new String[]{"provided-text-file.txt"});
    }

    @Test
    void bibleExtractTest() {
        TextFileMetrics.main(new String[]{"bible_daily_extract.txt"});
    }

    @ParameterizedTest
    @CsvSource({
            // String                 Total word count
            // --------------------   ----------------
            "'.',                     0",
            "'..',                    0",
            "',',                     0",
            "',,',                    0",
            "'a',                     1",
            "'ab',                    1",
            "'abc',                   1",
            "'a,b',                   2",
            "'a.b',                   2",
            "'a b',                   2",
            "'12.34',                 1",
            "'12.34 56.78',           2",
            "'12.34,56.78',           2",
            "'12.3A',                 2",
            "'21/05/2009',            1",
            "'21/05/2009 21/05/2010', 2"
    })
    void wordCountTest(String input, Long expected) {
        Map<Integer, Long> map = new HashMap<>();
        TextFileMetrics.wordCounter(map, input);
        assertEquals(expected, TextFileMetrics.getTotalWordCount(map));
    }

    @ParameterizedTest
    @CsvSource({
            // String                 Total word length
            // ---------------------  -----------------
            "'.',                     0",
            "'..',                    0",
            "',',                     0",
            "',,',                    0",
            "'a',                     1",
            "'ab',                    2",
            "'abc',                   3",
            "'a,b',                   2",
            "'a.b',                   2",
            "'a b',                   2",
            "'12.34',                 5",
            "'12.34 56.78',           10",
            "'12.34,56.78',           10",
            "'12.3A',                 4",
            "'21/05/2009',            10",
            "'21/05/2009 21/05/2010', 20"
    })
    void wordLengthTest(String input, Long expected) {
        Map<Integer, Long> map = new HashMap<>();
        TextFileMetrics.wordCounter(map, input);
        assertEquals(expected, TextFileMetrics.getTotalWordLength(map));
    }
}
