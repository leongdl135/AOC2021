import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        //ArrayList<Integer> numbers = new ArrayList<>();
        int score = 0;

        while(scanner.hasNextLine()) {
           String input = scanner.nextLine();
           String[] parts = input.split("");
           ArrayList<String> tracker = new ArrayList<>();
           for(int i = 0; i < parts.length; i++) {
              if (parts[i].equals("(")) {
                 tracker.add(parts[i]);
              } else if (parts[i].equals("[")) {
                 tracker.add(parts[i]);
              } else if (parts[i].equals("{")) {
                 tracker.add(parts[i]);
              } else if (parts[i].equals("<")) {
                 tracker.add(parts[i]);
              } else if (parts[i].equals(")")) {
                 if (tracker.get(tracker.size() - 1).equals("(")) {
                    tracker.remove(tracker.size() - 1);
                 } else {
                     score += 3;
                     break;
                 }
              } else if (parts[i].equals("]")) {
                  if (tracker.get(tracker.size() - 1).equals("[")) {
                    tracker.remove(tracker.size() - 1);
                 } else {
                     score += 57;
                     break;
                 }
               } else if (parts[i].equals("}")) {
                  if (tracker.get(tracker.size() - 1).equals("{")) {
                    tracker.remove(tracker.size() - 1);
                 } else {
                     score += 1197;
                     break;
                 }
               } else if (parts[i].equals(">")) {
                  if (tracker.get(tracker.size() - 1).equals("<")) {
                    tracker.remove(tracker.size() - 1);
                 } else {
                     score += 25137;
                     break;
                 }
               }
           }
           
        }
        System.out.println(score);
        
   } 
}
