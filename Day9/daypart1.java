import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
//import java.util.ArrayList;
import java.util.Arrays;

public class daypart1 {

   private static String[][] grid;
public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        //ArrayList<Integer> numbers = new ArrayList<>();
        int a = 0;
	    String[][] grid = new String[100][];
        while(scanner.hasNextLine()) {
		    String input = scanner.nextLine();
		    String[] parts = input.split("");
		    grid[a] = parts;
            a++;
        }

        int total = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                int num = Integer.valueOf(grid[i][j]);
                
                if(num < Integer.valueOf(checker(i-1, j, grid)) 
                   && num < Integer.valueOf(checker(i, j-1, grid))
                   && num < Integer.valueOf(checker(i+1, j, grid))
                   && num < Integer.valueOf(checker(i, j+1, grid))) {
                    total += num+1;
                   }
            }
        }
        System.out.println(total);
    
   }
    public static String checker(int i, int j, String[][] grid) {
       if (i < 0 || j < 0 || i > 99 || j > 99) {
           return "10";
       } else {
           return grid[i][j];
       }
    }

       

} 

   

