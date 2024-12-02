import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        int totalDifference = 0;

        try {
            File input = new File("E:\\Docs\\Projekt\\advent-of-code-2024\\day1\\input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();

                String[] split = data.split("\\s+");
                
                list1.add(Integer.parseInt(split[0]));
                list2.add(Integer.parseInt(split[1]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 

        Collections.sort(list1);
        Collections.sort(list2);

        for (Integer currInt : list1) {
            int difference = currInt - list2.get(list1.indexOf(currInt));

            if (difference < 0) {
                difference = difference * -1;
                totalDifference += difference;
            } else {
                totalDifference += difference;
            }
        }

        System.out.println("Total difference: " + totalDifference);
    }
}
