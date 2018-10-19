import java.util.Map;
import java.util.Scanner;

public class Menu {
    Text text = new Text();

    public void runApplication(){
        String file1;
        String file2;
        String option;
        Scanner sc = new Scanner(System.in);
        this.showInfo();
        do {
            this.showOptions();
            option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Enter the first file name");
                    System.out.print(">");
                    file1 = sc.nextLine();
                    System.out.println("Enter the second file name");
                    System.out.print(">");
                    file2 = sc.nextLine();
                    try {
                        Map<String, Integer> map = text.checkTexts(file1, file2);
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                    }catch (Exception e){
                        System.out.println("Invalid data.");
                        continue;
                    }
                    this.cleanLines();
                    break;
                case "x":
                    break;

                default:
                    System.out.println("Invalid entered data");
            }

        } while (!option.equals("x"));
    }

    private void showInfo(){
        System.out.println("COMPARING TEXT APPLICATION");
        System.out.println("This application compares two files of txt format\n" +
                "The result is map of words with the number of occurrence");
    }

    public void showOptions() {
        System.out.println("MAIN MENU");
        System.out.println(
                "[1] Enter two files to compare them.\n" +
                        "[x] Exit.");
    }

    public void cleanLines(){
        System.out.println("_________________________________________________");
        System.out.println();
    }
}
