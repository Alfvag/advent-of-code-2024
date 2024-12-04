import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int safeReports = 0;

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day2\\input.txt");

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                ArrayList<String> levelString = new ArrayList<>(Arrays.asList(data.split(" ")));
                ArrayList<Integer> levelInt = new ArrayList<>();

                for (String s : levelString) {
                    levelInt.add(Integer.parseInt(s));
                }

                if (isSafe(levelInt) && (isDecreasing(levelInt) || isIncreasing(levelInt))) {
                    safeReports++;
                } else {
                    if (problemDampener(levelInt)) {
                        safeReports++;
                    }
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("There are " + safeReports + " safe reports.");
    }

    public static boolean isSafe(ArrayList<Integer> levels) {
        for (int i = 1; i < levels.size(); i++) {
            int diff = Math.abs(levels.get(i) - levels.get(i - 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(ArrayList<Integer> levels) {
        for (int i = 1; i < levels.size(); i++) {
            if (levels.get(i - 1) <= levels.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIncreasing(ArrayList<Integer> levels) {
        for (int i = 1; i < levels.size(); i++) {
            if (levels.get(i - 1) >= levels.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean problemDampener(ArrayList<Integer> levels) {
        for (int i = 0; i < levels.size(); i++) {
            ArrayList<Integer> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(i);
            if (isSafe(modifiedLevels) && (isDecreasing(modifiedLevels) || isIncreasing(modifiedLevels))) {
                return true;
            }
        }
        return false;
    }
}