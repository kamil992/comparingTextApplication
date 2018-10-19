import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Text {


    public Map<String, Integer> checkTexts(String fileName1, String fileName2) {
        Map<String, Integer> resultMap = new HashMap<>();
        File file1 = new File("src/main/resources/textContent/" + fileName1 + ".txt");
        File file2 = new File("src/main/resources/textContent/" + fileName2 + ".txt");
        List<String> fileList1 = this.charsFilter(file1);
        List<String> fileList2 = this.charsFilter(file2);
        List<String> noRepeatedList = this.getNotRepeatedWordsList(file1, file2);

       // Collections.sort(noRepeatedList, (s1, s2) -> s1.compareTo(s2));

        for (int i = 0; i < noRepeatedList.size(); i++) {
            int wordCounter = 0;
            for (int j = 0; j < fileList1.size(); j++) {
                if (noRepeatedList.get(i).equalsIgnoreCase(fileList1.get(j))) {
                    wordCounter++;
                }
            }
            for (int k = 0; k < fileList2.size(); k++) {
                if (noRepeatedList.get(i).equalsIgnoreCase(fileList2.get(k))) {
                    wordCounter++;
                }
            }
            resultMap.put(noRepeatedList.get(i), wordCounter);
        }


        return resultMap;
    }

    public List<String> getNotRepeatedWordsList(File file1, File file2) {
        Set<String> stringSet = new HashSet<>();

        for (String word : this.charsFilter(file1)) {
            stringSet.add(word.toUpperCase());
        }

        for (String word : this.charsFilter(file2)) {
            stringSet.add(word.toUpperCase());
        }
        List<String> noRepeatedList = new ArrayList<>();

        for (String str : stringSet) {
            noRepeatedList.add(str);
        }

        return noRepeatedList;
    }

    public List<String> charsFilter(File file) {
        //read file as list with one element which is text inside.
        List<String> textList = this.readFile(file);
        //get first element from file which is our text.
        String text = textList.get(0);
        //create array by splitting whole text to single words.
        String[] textArray = text.split(" ");

        // stream which rid of all unwanted chars
        List<String> filteredText = Arrays.stream(textArray)
                .map((s) -> s.endsWith(".") ||
                        s.endsWith(",") ||
                        s.endsWith("-") ? s.substring(0, s.length() - 1) : s.substring(0, s.length()))
                .collect(Collectors.toList());

        return filteredText;
    }

    public List<String> readFile(File file) {
        List<String> strList = null;
        try {
            strList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Some files doesn't exists.");
        }

        return strList;
    }
}
