import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class TextFileMetrics {
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.###");

    public static void main(String[] args) {

        Long startTime = System.currentTimeMillis();

        String fileName = "provided-text-file.txt";  // default example
        if (args.length != 0) {
            fileName = args[0];  // use fileName passed as parameter
        }

        try {
            // The map contains the results of parsing the text file.
            // The map key is the word length and the map value is the number of occurrences of that word length.
            Map<Integer, Long> map = parseTextFile(fileName);
            System.out.printf("\nTarget file name = %s\n", fileName);

            Long totalWordCount = getTotalWordCount(map);
            System.out.printf("Word count = %s\n", totalWordCount);
            if (totalWordCount == 0) {
                return;
            }

            Long totalWordLength = getTotalWordLength(map);
            System.out.println("Average word length = " + getAverageWordLength(totalWordLength, totalWordCount));

            map.forEach((wordLength, occurrences) -> System.out.printf("Number of words of length " + wordLength + " is " + occurrences + "\n"));

            List<Integer> mostFrequentWordLengths = getMostFrequentWordLengths(map);
            System.out.printf("The most frequently occurring word length is " +
                    map.get(mostFrequentWordLengths.get(0)) +
                    ", for word lengths of " +
                    String.join(" & ", mostFrequentWordLengths.stream().map(Object::toString).toList()) +
                    "\n");

        } catch (FileNotFoundException e) {
            System.out.printf("FILE_NOT_FOUND fileName=%s message=%s\n", fileName, e.getMessage());
        } catch (IOException e) {
            System.out.printf("IO_EXCEPTION fileName=%s message=%s\n", fileName, e.getMessage());
        }
        System.out.printf("Elapsed milliseconds = %s\n", System.currentTimeMillis() - startTime);
    }

    public static Map<Integer, Long> parseTextFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        Map<Integer, Long> map = new HashMap<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordCounter(map, line);
        }
        bufferedReader.close();
        return map;
    }

    public static void wordCounter(Map<Integer, Long> map, String line) {
        String[] text = line.split("[\\s,]+");
        for (String positWord : text) {
            if (!isAlpha(positWord) && isNumeric(positWord)) {
                map.put(positWord.length(), map.getOrDefault(positWord.length(), 0L) + 1);
            } else {
                String[] words = positWord.split("[.]+");
                for (String realWord : words) {
                    if (realWord.length() > 0) {
                        map.put(realWord.length(), map.getOrDefault(realWord.length(), 0L) + 1);
                    }
                }
            }
        }
    }

    public static Long getTotalWordCount(Map<Integer, Long> map) {
        return map.values().stream().reduce(0L, Long::sum);
    }

    public static Long getTotalWordLength(Map<Integer, Long> map) {
        long totalWordLength = 0;
        for (var wordLength : map.entrySet()) {
            totalWordLength = totalWordLength + wordLength.getKey() * wordLength.getValue();
        }
        return totalWordLength;
    }

    public static String getAverageWordLength(Long totalWordLength, Long totalWordCount) {
        return DECIMAL_FORMAT.format((double) totalWordLength / totalWordCount);
    }

    public static List<Integer> getMostFrequentWordLengths(Map<Integer, Long> map) {
        Long max = Collections.max(map.values());
        return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), max)).map(Map.Entry::getKey).collect(Collectors.toList());
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
