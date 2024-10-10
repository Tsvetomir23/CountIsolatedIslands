package org.example;

import java.util.Scanner;

public class NumberIslands {
        public static void main (String[]args) {
            try {
                int N, M;
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the number of rows: ");
                N = scanner.nextInt();

                System.out.println("Enter the number of columns: ");
                M = scanner.nextInt();

                scanner.nextLine();

                int[][] mat = new int[N][M];
                if (!isValidMatrix(mat)){
                    System.out.println("Invalid matrix boundaries. Please enter a matrix between a size of 2 x 500.");
                    return;
                }

                System.out.printf("Enter the matrix of size %d x %d:", N, M);
                String input = scanner.nextLine();

                input = input.replaceAll(",", "").trim();
                input = input.replaceAll("\u00A0", ""); // Non-breaking space!!
                input = input.replaceAll("\\s+", "");

                if (!validateInputString(input, N, M)) {
                    System.out.println("Invalid input! The string must contain exactly " + (N * M) + " zeros and ones." +
                            " Seperated or not by commas.");
                    return;
                }

                fillMatrixFromString(mat, input, N, M);

                System.out.println("The entered matrix is:");
                printMatrix(mat, N, M);


               System.out.println("Number of closed islands: " + countClosedIslands(mat));
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }

        }


    public static void printMatrix(int[][] mat, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixFromString(int[][] mat, String input, int N, int M) {
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = Character.getNumericValue(input.charAt(index++));
            }
        }
    }
    public static boolean validateInputString(String input, int N, int M) {
        if (input.length() != N * M) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidMatrix(int[][] mat) {
            return mat != null && mat.length > 1 && mat[0].length <= 500;
        }
    private static void DFSearch(int[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }

        mat[i][j] = 0;

        DFSearch(mat, i + 1, j);
        DFSearch(mat, i - 1, j);
        DFSearch(mat, i, j + 1);
        DFSearch(mat, i, j - 1);
    }
    public static int countClosedIslands(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;

        //Check left and right side
        for (int i = 0; i < N; i++) {
            for (int j : new int[]{0, M - 1}) {
                if (mat[i][j] == 1) {
                    DFSearch(mat, i, j);
                }
            }
        }

        //Check top and bottom side
        for (int j = 0; j < M; j++) {
            for (int i : new int[]{0, N - 1}) {
                if (mat[i][j] == 1) {
                    DFSearch(mat, i, j);
                }
            }
        }

        //Count the closed islands and mark them as visited (turn 1s into 0s)
        int closedIslands = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (mat[i][j] == 1) {
                    DFSearch(mat, i, j);
                    closedIslands++;
                }
            }
        }

        return closedIslands;
    }


}
