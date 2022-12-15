import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, bomb, count = 0;
        n=in.nextInt();
        m=in.nextInt();
        bomb= in.nextInt();
        char[][] A = new char[34][34];
        int x, y;
        for (int i = 0; i < n + 2; i++){
            for (int j = 0; j < m + 2; j++){
                A[i][j] = '0';
            }
        }
        for (int i = 0; i < bomb; i++){
            x=in.nextInt();
            y=in.nextInt();
            A[x][y] = '*';
        }
        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                if (A[i][j] != '*'){
                    if (A[i-1][j] == '*') count++;
                    if (A[i-1][j-1] == '*') count++;
                    if (A[i-1][j+1] == '*') count++;
                    if (A[i+1][j+1] == '*') count++;
                    if (A[i+1][j-1] == '*') count++;
                    if (A[i+1][j] == '*') count++;
                    if (A[i][j-1] == '*') count++;
                    if (A[i][j+1] == '*') count++;
                    System.out.print(count);
                    count = 0;
                }
                else System.out.print(A[i][j]);
                if (j != m) System.out.print(" ");
            }
            System.out.println();
        }
    }
}