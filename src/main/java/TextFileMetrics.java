import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TextFileMetrics {
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.###");
    final static Boolean DIAGNOSTICS = FALSE;

    /**
     * TextFileMetrics is a Java class that reads the contents of a plain text file and prints the following metrics:
     * <ul>
     * <li>The total number of words in the text file,
     * <li>The average word length,
     * <li>The most frequently occurring word length, and
     * <li>A list of the number of words of each length.
     * </ul>
     *
     * @param args the name of the file to be analysed.
     * @return void
     */
    public static void main(String[] args) {

        Long startTime = System.currentTimeMillis();

        String fileName = "provided-text-file.txt";  // default example
        if (args.length != 0) {
            fileName = args[0];  // use fileName passed as parameter
        }

        // The wordLengthOccurrence map contains the results of parsing the text file.
        // The wordLengthOccurrence map key is the word length and the wordLengthOccurrence map value is the number of occurrences of that word length.
        Map<Integer, Long> wordLengthOccurrence = new HashMap<>();

        try {
            parseTextFile(fileName, wordLengthOccurrence);

            if (DIAGNOSTICS) {
                System.out.printf("\nTarget file name = %s\n", fileName);
            }

            Long totalWordCount = getTotalWordCount(wordLengthOccurrence);

            System.out.printf("Word count = %s\n", totalWordCount);
            if (totalWordCount == 0) {
                return;
            }

            Long totalWordLength = getTotalWordLength(wordLengthOccurrence);

            System.out.println("Average word length = " + getAverageWordLength(totalWordLength, totalWordCount));

            wordLengthOccurrence.forEach((wordLength, occurrences) -> System.out.printf("Number of words of length " + wordLength + " is " + occurrences + "\n"));

            List<Integer> mostFrequentWordLength = getMostFrequentWordLength(wordLengthOccurrence);

            System.out.printf("The most frequently occurring word length is " +
                    wordLengthOccurrence.get(mostFrequentWordLength.get(0)) +
                    ", for word lengths of " +
                    String.join(" & ", mostFrequentWordLength.stream().map(Object::toString).toList()) +
                    "\n");

        } catch (FileNotFoundException e) {
            System.out.printf("FILE_NOT_FOUND fileName=%s message=%s\n", fileName, e.getMessage());
        } catch (IOException e) {
            System.out.printf("IO_EXCEPTION fileName=%s message=%s\n", fileName, e.getMessage());
        }

        if (DIAGNOSTICS) {
            System.out.printf("Elapsed milliseconds = %s\n", System.currentTimeMillis() - startTime);
        }
    }

    public static void parseTextFile(String fileName, Map<Integer, Long> wordLengthOccurrence) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            accumulateWordLengths(line, wordLengthOccurrence);
        }
        bufferedReader.close();
    }

    public static void accumulateWordLengths(String line, Map<Integer, Long> wordLengthOccurrence) {
        String[] text = line.split("[\\s,]+");
        for (String word : text) {
            if (!isAlpha(word) && isNumeric(word)) {
                incrementWordLengthOccurrence(word.length(), wordLengthOccurrence);  // count word as a number
            } else {
                String[] words = word.split("[.]+");
                for (String alphabeticWord : words) {
                    incrementWordLengthOccurrence(alphabeticWord.length(), wordLengthOccurrence);  // count word as a string
                }
            }
        }
    }

    public static void incrementWordLengthOccurrence(Integer wordLength, Map<Integer, Long> wordLengthOccurrence) {
        if (wordLength > 0) {
            wordLengthOccurrence.put(wordLength, wordLengthOccurrence.getOrDefault(wordLength, 0L) + 1);
        }
    }

    public static Long getTotalWordCount(Map<Integer, Long> WordLengthOccurrence) {
        return WordLengthOccurrence.values().stream().reduce(0L, Long::sum);
    }

    public static Long getTotalWordLength(Map<Integer, Long> wordLengthOccurrence) {
        long totalWordLength = 0;
        for (var wordLength : wordLengthOccurrence.entrySet()) {
            totalWordLength = totalWordLength + wordLength.getKey() * wordLength.getValue();
        }
        return totalWordLength;
    }

    public static String getAverageWordLength(Long totalWordLength, Long totalWordCount) {
        return DECIMAL_FORMAT.format((double) totalWordLength / totalWordCount);
    }

    public static List<Integer> getMostFrequentWordLength(Map<Integer, Long> wordLengthOccurrence) {
        Long max = Collections.max(wordLengthOccurrence.values());
        return wordLengthOccurrence.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), max)).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
