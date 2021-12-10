import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class daypart2 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        ArrayList<String[]> incomplete = new ArrayList<>();
        ArrayList<Long> scores = new ArrayList<>();
        

        while(scanner.hasNextLine()) {
           int score = 0;
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
           if (score == 0) {
              incomplete.add(parts);
           }
           
        }

        for(int j = 0; j < incomplete.size(); j++) {
           String[] parts = incomplete.get(j);
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
                 } 
              } else if (parts[i].equals("]")) {
                  if (tracker.get(tracker.size() - 1).equals("[")) {
                    tracker.remove(tracker.size() - 1);
                 } 
               } else if (parts[i].equals("}")) {
                  if (tracker.get(tracker.size() - 1).equals("{")) {
                    tracker.remove(tracker.size() - 1);
                 } 
               } else if (parts[i].equals(">")) {
                  if (tracker.get(tracker.size() - 1).equals("<")) {
                    tracker.remove(tracker.size() - 1);
                 } 
               }
            }
            long score = 0;
            for(int k = tracker.size()-1; k >= 0; k--) {
               if (tracker.get(k).equals("(")) {
                  score = score*5;
                  score += 1;
               } else if (tracker.get(k).equals("[")) {
                  score = score*5;
                  score += 2;
               } else if (tracker.get(k).equals("{")) {
                  score = score*5;
                  score += 3;
               } else if (tracker.get(k).equals("<")) {
                  score = score*5;
                  score += 4;
               } 
            }
            scores.add(score);
        }  
        Collections.sort(scores);
        //System.out.println(scores);
        System.out.println(scores.get((scores.size()-1)/2));



   }
}