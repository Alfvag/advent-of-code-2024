import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        int occurrences = 0;
        ArrayList<String> lines = new ArrayList<>();

        // Regex match inline occurences and push line to arraylist

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day4\\input.txt");

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                lines.add(data);

                Pattern pattern = Pattern.compile("XMAS|SAMX");
                Matcher matcher = pattern.matcher(data);

                while (matcher.find()) {
                    occurrences++;
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Find vertical matches downwards

        for (int i = 0; i < lines.size(); i++) {
            if (!((i + 3) > (lines.size() - 1))) {
                for (int j = 0; j < lines.get(i).length(); j++) {
                    if (lines.get(i).charAt(j) == 'X' && lines.get(i + 1).charAt(j) == 'M' && lines.get(i + 2).charAt(j) == 'A' && lines.get(i + 3).charAt(j) == 'S') {
                        occurrences++;
                    } else if (lines.get(i).charAt(j) == 'S' && lines.get(i + 1).charAt(j) == 'A' && lines.get(i + 2).charAt(j) == 'M' && lines.get(i + 3).charAt(j) == 'X') {
                        occurrences++;
                    }
                }
            }
        }

        // Find vertical matches upwards

        for (int i = lines.size() - 1; i >= 0; i--) {
            if (!((i - 3) < 0)) {
                for (int j = 0; j < lines.get(i).length(); j++) {
                    if (lines.get(i).charAt(j) == 'X' && lines.get(i - 1).charAt(j) == 'M' && lines.get(i - 2).charAt(j) == 'A' && lines.get(i - 3).charAt(j) == 'S') {
                        occurrences++;
                    } else if (lines.get(i).charAt(j) == 'S' && lines.get(i - 1).charAt(j) == 'A' && lines.get(i - 2).charAt(j) == 'M' && lines.get(i - 3).charAt(j) == 'X') {
                        occurrences++;
                    }
                }
            }
        }

        // Find diagonal matches downwards to the right 

        for (int i = 0; i < lines.size(); i++) {
            if (!((i + 3) > (lines.size() - 1))) {
                for (int j = 0; j < lines.get(i).length(); j++) {
                    if (!((j + 3) > (lines.get(i).length() - 1))) {
                        if (lines.get(i).charAt(j) == 'X' && lines.get(i + 1).charAt(j + 1) == 'M' && lines.get(i + 2).charAt(j + 2) == 'A' && lines.get(i + 3).charAt(j + 3) == 'S') {
                            occurrences++;
                        } else if (lines.get(i).charAt(j) == 'S' && lines.get(i + 1).charAt(j + 1) == 'A' && lines.get(i + 2).charAt(j + 2) == 'M' && lines.get(i + 3).charAt(j + 3) == 'X') {
                            occurrences++;
                        }
                    }
                }
            }
        }

        // Find diagonal matches upwards to the right   

        for (int i = lines.size() - 1; i >= 0; i--) {
            if (!((i - 3) < 0)) {
                for (int j = 0; j < lines.get(i).length(); j++) {
                    if (!((j + 3) > (lines.get(i).length() - 1))) {
                        if (lines.get(i).charAt(j) == 'X' && lines.get(i - 1).charAt(j + 1) == 'M' && lines.get(i - 2).charAt(j + 2) == 'A' && lines.get(i - 3).charAt(j + 3) == 'S') {
                            occurrences++;
                        } else if (lines.get(i).charAt(j) == 'S' && lines.get(i - 1).charAt(j + 1) == 'A' && lines.get(i - 2).charAt(j + 2) == 'M' && lines.get(i - 3).charAt(j + 3) == 'X') {
                            occurrences++;
                        }
                    }
                }
            }
        }

        // Find diagonal matches downwards to the left

        for (int i = 0; i < lines.size(); i++) {
            if (!((i + 3) > (lines.size() - 1))) {
                for (int j = lines.get(i).length() - 1; j >= 0; j--) {
                    if (!((j - 3) < 0)) {
                        if (lines.get(i).charAt(j) == 'X' && lines.get(i + 1).charAt(j - 1) == 'M' && lines.get(i + 2).charAt(j - 2) == 'A' && lines.get(i + 3).charAt(j - 3) == 'S') {
                            occurrences++;
                        } else if (lines.get(i).charAt(j) == 'S' && lines.get(i + 1).charAt(j - 1) == 'A' && lines.get(i + 2).charAt(j - 2) == 'M' && lines.get(i + 3).charAt(j - 3) == 'X') {
                            occurrences++;
                        }
                    }
                }
            }
        }

        // Find diagonal matches upwards to the left

        for (int i = lines.size() - 1; i >= 0; i--) {
            if (!((i - 3) < 0)) {
                for (int j = lines.get(i).length() - 1; j >= 0; j--) {
                    if (!((j - 3) < 0)) {
                        if (lines.get(i).charAt(j) == 'X' && lines.get(i - 1).charAt(j - 1) == 'M' && lines.get(i - 2).charAt(j - 2) == 'A' && lines.get(i - 3).charAt(j - 3) == 'S') {
                            occurrences++;
                        } else if (lines.get(i).charAt(j) == 'S' && lines.get(i - 1).charAt(j - 1) == 'A' && lines.get(i - 2).charAt(j - 2) == 'M' && lines.get(i - 3).charAt(j - 3) == 'X') {
                            occurrences++;
                        }
                    }
                }
            }
        }

        System.out.println("Occurrences: " + occurrences);
    }
}
