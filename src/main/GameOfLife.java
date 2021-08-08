package src.main;
import java.io.*;

/**
 * Home Work 1 - Game of Life:
 * Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * @author Botao Gao
 * @version <b>1.0</b> rev. 0
 *
 */
public class GameOfLife
{
    /**
     * main() method
     * User can indicate a txt format data
     * file to let the program knows the shape of initial
     * matrix and the detail living condition of each cell.
     * Finally the txt file of each generation will be
     * put into separate txt files with the name of its
     * generation number.
     * @param args arg[0] is the name of seed file. arg[1] is the generation numbers
     * @throws IOException Throus exception if some I/O issue occurred
     */

    public static void main(String[] args) throws IOException {


        String fileName = args[0];
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line, restline;

        // read the first line to get the size of grid
        line = in.readLine();
        String[] size= line.split(", ");
        String Q = size[0];    // row
        String P = size[1];    // column
        // convert String to Integer
        int M = Integer.parseInt(Q);  // Number of rows
        int N = Integer.parseInt(P);  // Number of columns

        // initialize a array to store Original Generation
        int [][] arr2 = new int[M][N];

//        int row=0;

        try {
            for (int row = 0; row < M; row++) {
                restline = in.readLine();
                String[] temp = restline.split(", ");
                for (int col = 0; col < N; col++) {
                    arr2[row][col] = (int) Double.parseDouble(temp[col]);
                }
            }
            in.close();

            // Displaying the grid
            int[][] grid = arr2;

            System.out.println("Original Generation");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0)
                        System.out.print("- ");
                    else
                        System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();

            int G = Integer.valueOf(args[1]);// Number of generations
            // Repeate G generations
            for (int i = 0; i < G; i++) {

                // create filePath for each generation
                String filename = String.format("generation_%d.txt", i + 1);
                File file = new File(filename);
                FileWriter out = new FileWriter(file);

                // print the result to the terminal
                System.out.printf("NEW GENERATION: %d\n", i + 1);
                grid = nextGeneration(grid, M, N);

                // write each generation into the file
                for (int m = 0; m < M; m++) {        // row
                    for (int n = 0; n < N; n++) {     // column
                        out.write(grid[m][n] + ",");    // each cell
                    }
                    out.write("\r\n");
                }
                out.write("\r\n");
                out.close();
            }
            
            System.out.printf("Data files are done. Please check them in the folder. \r\n");

        } catch (Exception e) {
            System.out.println();
            System.out.println("================= Attention please!!! =================");
            System.out.println("The size you entered is not consist with the grid of Original Generation\r\n");
        }
    }

    /**
     * This is function is used to generate the next generation.
     * Firstly input the last generation and create an empty
     * 2-D array for inputing the values of next generation.
     * Then go through eveery cell to compute the number of
     * neighbors of a cell. Recomute the coordinate if this is
     * an edge cell.
     * Output the next generation.
     * @param grid[][] The last generation arrays
     * @param M The number of rows
     * @param N The number of columns
     * @return A 2-D array of next generation
     */
    public static int[][] nextGeneration(int grid[][], int M, int N) {

        int[][] future = new int[M][N];

        // Loop through every cell
        for (int l = 0; l < M; l++){          // Rows
            for (int m = 0; m < N; m++){      // Columns
                //System.out.printf("l: %d, m:%d\n", l, m);
                // Finding numbers of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++) {
                        //System.out.printf("i: %d, j:%d\n", i, j);
                        int x = m;
                        int y = l;
                        // Solve the problems of edge cells
                        // Recompute the coordinate if it is an edge cell
                        if (m+i==-1) {
                            x = N;
                        }
                        if (m+i==N) {
                            x = - 1;
                        }
                        if (l+j==-1) {
                            y = M;
                        }
                        if (l+j==M) {
                            y = -1;
                        }
                        //System.out.printf("x + i: %d, y + j:%d\n", x + i, y + j);
                        aliveNeighbours += grid[y + j][x + i]; // compute the live cells around a cell
                    }

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // The rules of Game of life
                // Any live cell with fewer than two live neighbors dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Any live cell with two or three live neighbors lives
                else if ((grid[l][m] == 1) && (aliveNeighbours ==2 || aliveNeighbours ==3))
                    future[l][m] = 1;

                    // Any live cell with more than three live neighbors dies,
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // Any dead cell with exactly three live neighbors becomes a live cell
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Else remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }

        // Output the next generation
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print("- ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }

        return future;
    }
}
