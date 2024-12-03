import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int safeReports = 0;

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day2\\input.txt");

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);

                String[] level = data.split(" ");

                if (isSafe(level)) {
                    if (isDecreasing(level) || isIncreasing(level)) {
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

    public static boolean isDecreasing(String[] level) {
        boolean isDecreasing = false;

        for (int i = 1; i < level.length; i++) {
            if (Integer.parseInt(level[i]) < Integer.parseInt(level[i - 1])) {
                isDecreasing = true;
            } else {
                return false;
            }
        }

        return isDecreasing;
    }

    public static boolean isIncreasing(String[] level) {
        boolean isIncreasing = false;

        for (int i = 1; i < level.length; i++) {
            if (Integer.parseInt(level[i]) > Integer.parseInt(level[i - 1])) {
                isIncreasing = true;
            } else {
                return false;
            }
        }

        return isIncreasing;
    }

    public static boolean isSafe(String[] level) {
        for (int i = 1; i < level.length; i++) {
            int step = Integer.parseInt(level[i]) - Integer.parseInt(level[i - 1]);

            if (step < 0) {
                step = step * -1;
            }

            if (step < 1 || step > 3) {
                return false;
            }
        }

        return true;
    }
}
