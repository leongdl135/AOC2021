import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class day1part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("day1inputlol.txt"));
        int[] numbers = new int[2000];
        int count = 0;
        int current = 0;
        int counter = 0;
        while (scanner.hasNextLine()) {
            int num = Integer.valueOf(scanner.nextLine());
            numbers[count] = num;
            count++;
        }

        for(int i = 0; i < numbers.length-2; i++) {
            int temp = numbers[i] + numbers[i+1] + numbers[i+2];
            if (temp > current) {
                counter++;
            }
            current = temp;
        }

        System.out.println("Count: " + (counter - 1));

    }    
}
