import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        ArrayList<int[][]> coordinates = new ArrayList<>();

        while(scanner.hasNextLine()) {
           String input = scanner.nextLine();
           String[] parts = input.split(" ");
           String[] firstCoord = parts[0].split(",");
           int[] array1 = new int[firstCoord.length];
           for (int i = 0; i < firstCoord.length; i++) {
              array1[i] = Integer.parseInt(firstCoord[i]);
           }
           String[] secondCoord = parts[2].split(",");
           int[] array2 = new int[secondCoord.length];
           for (int i = 0; i < secondCoord.length; i++) {
            array2[i] = Integer.parseInt(secondCoord[i]);
           }
           int[][] coord = {array1, array2};
           coordinates.add(coord);
           //System.out.println(Arrays.deepToString(coord));
        }
        int[][] board = new int[1000][1000];

        for(int i = 0; i < coordinates.size(); i++) {
           int[] firstCoordinate = coordinates.get(i)[0];
           int[] secondCoordinate = coordinates.get(i)[1];
           int x1 = firstCoordinate[0];
           int y1 = firstCoordinate[1];
           int x2 = secondCoordinate[0];
           int y2 = secondCoordinate[1];
           if (x1 == x2) {
              if (y1 > y2) {
                 for (int y = y2; y <= y1; y++) {
                    board[x1][y] += 1; 
                 }
               } else {
                 for (int y = y1; y <= y2; y++) {
                    board[x1][y] += 1; 
                 }
               }
            } else if (y1 == y2) {
               if (x1 > x2) {
                  for (int x = x2; x <= x1; x++) {
                    board[x][y1] += 1; 
                  }
               } else {
                  for (int x = x1; x <= x2; x++) {
                     board[x][y1] += 1;
                  }
               }
            }
         }
         int count = 0;
         for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
               if (board[i][j] > 1) {
                  count++;
               }
              }
         }
         System.out.println(count);

        }

} 

