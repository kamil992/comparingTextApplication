
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileTest {

    @Test
    public void checkExistsTest(){
        File file1 = new File("src/main/resources/textContent/java.txt");
        File file2 = new File("src/main/resources/textContent/c++.txt");

        assertTrue("can't find", file1.exists());
        assertTrue("file1 is not file", file1.isFile());


        assertTrue("can't find", file2.exists());
        assertTrue("file2 is not file", file2.isFile());
    }

    @Test
    public void containsDigsTest(){
        Text text = new Text();
        File file1 = new File("src/main/resources/textContent/java.txt");
        File file2 = new File("src/main/resources/textContent/c++.txt");
        List<String> strList1= text.charsFilter(file1);
        List<String> strList2 = text.charsFilter(file2);
        int counter = 0;

        for(String s : strList2){
            if(s.endsWith(".") || s.endsWith(","))
                counter++;
            System.out.println(s);
        }
//        for(String s : strList1){
//            if(s.endsWith(".") || s.endsWith(","))
//                counter++;
//        }
        System.out.println(counter);
        assertTrue("text has unwanted chars! bad streaming.", counter == 0);
    }

    @Test
    public void checkSetTest(){
        Text text = new Text();
        File file1 = new File("src/main/resources/textContent/java.txt");
        File file2 = new File("src/main/resources/textContent/c++.txt");


        for(String s : text.getNotRepeatedWordsList(file1, file2)){
            System.out.println(s);
        }
    }
}
