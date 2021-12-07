import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Arrays;

public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        //ArrayList<Integer> numbers = new ArrayList<>();

        
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
           numbers[i] = Integer.valueOf(parts[i]);
        }

        int total = 0;
        for(int i = 0; i < numbers.length; i++) {
           total += numbers[i];
        }

        int max = 0;
        int min = 100;

        for(int i = 0; i < numbers.length; i++) {
           if (numbers[i] > max) {
              max = numbers[i];
           }
           if (numbers[i] < min) {
              min = numbers[i];
           }
        }
        long leastFuelUsed = 100000000;
        for(int i = min; i <= max; i++) {
           long sum = 0;
           for(int j = 0; j < numbers.length; j++) {
               sum += Math.abs(i - numbers[j]);
           }
           if (sum < leastFuelUsed) {
              leastFuelUsed = sum;
           }
        }

        System.out.println("fuel: " + leastFuelUsed);
        
         
        
        


   } 
}
