import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

public class daypart2 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();

        String input = scanner.nextLine();
        String[] parts = input.split(",");
        for(int i = 0; i < parts.length; i++) {
           numbers.add(Integer.valueOf(parts[i]));
        }
        long[] tracker = new long[9];
        for(int i = 0; i < numbers.size(); i++) {
           tracker[numbers.get(i)] += 1;
        }
        

        

      //   for(int i = 0; i < 256; i++) {
      //      long[] temp = new long[9];
      //      for(int j = 0; j < 9; j++) {
      //         if (j == 8) {
      //            temp[j] = tracker[0];
      //         } else if (j == 6) {
      //            temp[j] = tracker[0] + tracker[7]; 
      //         } else {
      //            temp[j] = tracker[j+1];
      //         }
      //      }
      //      for(int x = 0; x < 9; x++) {
      //         tracker[x] = temp[x];
      //      }
      //   }
      long zeroVal = tracker[0];

      for(int i = 0; i < 256; i++) {
         for (int j = 0 ; j < 9; j++) {
            if(j == 6) {
               tracker[j] = tracker[j+1] + zeroVal;
            } else if (j == 8) {
               tracker[j] = zeroVal;
            } else if (j == 0) {
               zeroVal = tracker[0];
               tracker[j] = tracker[j+1];
            } else {
               tracker[j] = tracker[j+1];
            }
         }
      }
        System.out.println(Arrays.toString(tracker));

        long sum = 0;
        for(int i = 0; i < 9; i++) {
           sum += tracker[i];
        }

        System.out.println("Total number of fishes: " + sum);

   } 
}
