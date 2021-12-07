//solution 1 is naive and will not work for longer days/larger inputs

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();

        String input = scanner.nextLine();
        String[] parts = input.split(",");
        for(int i = 0; i < parts.length; i++) {
           numbers.add(Integer.valueOf(parts[i]));
        }

        int i = 0;
        while(i < 256) {
           for(int j = 0; j < numbers.size(); j++) {
              int num = numbers.get(j);
              if (num == 0) {
                 numbers.set(j, 6);
                 numbers.add(9);
              } else {
                 numbers.set(j, num - 1);
              }
           }
           i++;
           //System.out.println(numbers);
        }

        System.out.println(numbers.size());



        

   } 
}
