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

        Arrays.sort(numbers);
        int median = numbers[numbers.length/2];
        int sum = 0; 
        for(int i = 0; i < numbers.length; i++) {
           sum += Math.abs(median- numbers[i]);
        }

        System.out.println("Fuel Used: " + sum);
   }
}
