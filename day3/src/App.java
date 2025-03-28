import java.io.File;
import java.util.*;
import java.util.regex.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> matches = new ArrayList<String>();
        int multiplicationResult = 0;
        boolean active = true;

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day3\\input.txt");

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                // Updated pattern to match "mul(num1, num2)" or "do()" or "don't()"
                Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");
                Matcher matcher = pattern.matcher(data);

                while (matcher.find()) {
                    String match = matcher.group();
                    matches.add(match);
                    
                    // Only perform multiplication for mul() patterns
                    if (match.startsWith("mul") && active) {
                        int num1 = Integer.parseInt(matcher.group(1));
                        int num2 = Integer.parseInt(matcher.group(2));
                        multiplicationResult += (num1 * num2);
                    } else if (match.equals("do()")) {
                        active = true;
                    } else if (match.equals("don't()")) {
                        active = false;
                    }
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Matches: " + matches);
        System.out.println("Multiplication result: " + multiplicationResult);
    }
}
