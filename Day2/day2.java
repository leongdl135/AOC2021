import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class day2 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int x = 0;
        int y = 0;
        int aim = 0;

        while(scanner.hasNextLine()) {
            String name = scanner.nextLine();
            String[] arr = name.split(" ");
            if (arr[0].equals("forward")) {
                x += Integer.valueOf(arr[1]); 
                y += aim * Integer.valueOf(arr[1]);
            } else if (arr[0].equals("down")) {
                aim += Integer.valueOf(arr[1]); 
            } else {
                aim -= Integer.valueOf(arr[1]);
            }
        }

        System.out.println(x*y);

   } 
}
