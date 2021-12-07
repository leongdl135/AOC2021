import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;


public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<String[][]> game = new ArrayList<>();
      Scanner scanner = new Scanner(new File("input.txt"));
      String firstLine = scanner.nextLine();
      String[] numberOrder = firstLine.split(",");
      int count = 0;
      int count2 = 0;

      while(true) {
         if (count2 == 100) {
            break;
         } else if (count == 0) {
            String temp = scanner.nextLine();
            count++;
         } else {
            String[][] arrays = new String[5][];
            for(int i = 0; i < 5; i++) {
               String nums = scanner.nextLine();
               String[] temp = nums.trim().split("\\s+");
               arrays[i] = temp;
            }
            game.add(arrays);
            count = 0;
            count2++;
         }

           
      }
      Boolean cont = true;
      for(int i = 0; i < numberOrder.length && cont; i++) {
         String checker = numberOrder[i];
         for(String[][] board:game) {
            for(int x = 0; x < 5; x++) {
               for (int y = 0; y < 5; y++) {
                  if(board[x][y].equals(checker)) {
                     board[x][y] = "X";
                  }
               }
            }
            if(winner(board)) {
               int sum = sumArray(board);
               System.out.println(Arrays.deepToString(board));
               System.out.println("Last digit: " + checker);
               System.out.println("Sum to array: " + sum);
               System.out.println("Answer: " + (sum*Integer.valueOf(checker)));
               cont = false;
               break;
            }
         }

         
         }
      }

   
   
      

   public static Boolean winner(String[][] board) {
      Boolean truthy = true;
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 5; j++) {
            truthy = truthy && board[i][j].equals("X");
         }
         if(truthy) {
            return true;
         }
      }
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 5; j++) {
            truthy = truthy && board[j][i].equals("X");
         }
         if(truthy) {
            return true;
         }
      }
      return false;
   }
   
   public static int sumArray(String[][] board) {
      int total = 0;
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 5; j++) {
            if (board[i][j].equals("X")) {
            } else {
               total = total + Integer.valueOf(board[i][j]);
            }
         }
      }
      return total;
   }
      
} 

