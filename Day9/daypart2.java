import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
//import java.util.ArrayList;
import java.util.Arrays;

public class daypart2 {

   private static String[][] grid;
   public static int[][] number = new int[100][100];
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

        for(int i = 0; i < 100; i++) {
           for(int j = 0; j < 100; j++) {
              number[i][j] = Integer.parseInt(grid[i][j]);
           }
        }

        int marker = -1;

        for(int i = 0; i < 100; i++) {
           for(int j = 0; j < 100; j++) {
              if (number[i][j] == 0) {
                 dfs(i, j, marker);
                 marker--;
              }
           }
        }
      int[] reference = new int[100];
       for(int i = 0; i < 100; i++) {
          for(int j = 0; j < 100; j++) {
            if (number[i][j] < 0) {
               reference[-1*number[i][j]] += 1;
            }
          }
       }

       //finding the maximum 
       int max1 = 0;
       int max2 = 0; 
       int max3 = 0;
       for(int i = 0; i < 100; i++) {
          if (reference[i] > max1) {
             max3 = max2;
             max2 = max1;
             max1 = reference[i];
          } else if (reference[i] > max2) {
             max3 = max2;
             max2 = reference[i];
          } else if (reference[i] > max3) {
             max3 = reference[i];
          }
       }
       System.out.println("Basin sizes: " + max1 + ", " + max2 + ", " + max3);
       System.out.println("Answer: " +  max1*max2*max3);

      

    
   }
    public static int checker(int i, int j) {
       if (i < 0 || j < 0 || i > 99 || j > 99) {
           return 10;
       } else {
           return number[i][j];
       }
    }

    public static void dfs(int i, int j, int marker) {
       int num = number[i][j];
       number[i][j] = marker;
       if (checker(i-1, j) < 9 && checker(i-1, j) > 0 && checker(i-1, j) > num) {
          dfs(i-1, j, marker);
       }
       if (checker(i+1, j) < 9 && checker(i+1, j) > 0 && checker(i+1, j) > num) {
          dfs(i+1, j, marker);
       }
       if (checker(i, j-1) < 9 && checker(i, j-1) > 0 && checker(i, j-1) > num) {
          dfs(i, j-1, marker);
       }
       if (checker(i, j+1) < 9 && checker(i, j+1) > 0 && checker(i, j+1) > num) {
          dfs(i, j+1, marker);
       }
    }

   

       

} 
