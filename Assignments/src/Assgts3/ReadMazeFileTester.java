// Name:Zhe Jian
// USC loginid:zhejian
// CS 455 PA3
// Fall 2017
//package Assgts3;
import java.io.File;
import java.util.Scanner;

/**
 * This is a test file for the readMazeFile function in the MazeViewer.
 */
public class ReadMazeFileTester {
    public static void main(String[] args) {
        String fileContent = "20 20\n" +
                "00000001111100000001\n" +
                "11111100111101111100\n" +
                "11011110011000011110\n" +
                "10010111011011000110\n" +
                "10110110001011110110\n" +
                "10110000101011000011\n" +
                "10111110001011011000\n" +
                "00000000000011111011\n" +
                "01111111001100001001\n" +
                "00111000001111101101\n" +
                "10000011111100001001\n" +
                "11101110000101111011\n" +
                "11111111111001111011\n" +
                "00000000000011000001\n" +
                "01111111111111011101\n" +
                "01111111011111111101\n" +
                "00000000011100000101\n" +
                "01111111000111010001\n" +
                "01111111111111011111\n" +
                "00000000000000000000\n" +
                "8 12\n" +
                "0 0";
        Scanner in = new Scanner(fileContent);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String cur = in.next();
            char[] curArr = cur.toCharArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = curArr[j] - '0';
            }
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int exitX = in.nextInt();
        int exitY = in.nextInt();
        System.out.println(startX);
        System.out.println(startY);






        /*
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col;j++) {
                System.out.println(matrix[i][j]);
            }
        }
        */
    }
}

