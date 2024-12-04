import java.io.File;
import java.util.*;
import java.util.regex.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> matches = new ArrayList<String>();
        int multiplicationResult = 0;

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day3\\input.txt");

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)");
                Matcher matcher = pattern.matcher(data);

                while (matcher.find()) {
                    matches.add(matcher.group());
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    multiplicationResult += (num1 * num2);
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Multiplication result: " + multiplicationResult);
    }
}
