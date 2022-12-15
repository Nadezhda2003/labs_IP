import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int n=scanner.nextInt();
            int m= scanner.nextInt();
            int[][]matrix=new int[n][];
            for (int i=0; i<n; i++)
                matrix[i]=new int[m];
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<m; j++)
                {
                    matrix[i][j]=scanner.nextInt();
                }
            }
            FileWriter fw = new FileWriter("output.txt");
            for (int i=0; i<n; i++) {
                for (int j = 0; j < m; j++)
                    fw.write(matrix[i][j] + " ");
                fw.write('\n');
            }
            int k=0, flag;
            for (int i=0; i < n; i++)
            {
                flag=0;
                for (int j=0; j < m-1; j++)
                {
                    if (matrix[i][j] == matrix[i][j+1] || matrix[i][j]<(-1*m) || matrix[i][j]>-1) {
                        flag = 1;
                        break;
                    }
                }
                if (matrix[i][m-1]<(-1*m) || matrix[i][m-1]>-1)
                    flag=1;
                if(flag!=1)
                    k++;
            }
            fw.write("\nКоличество строк заданной матрицы, являющихся перестановкой чисел -1, -2, ..., -10.\n");
            fw.write(k+" ");
            scanner.close();
            fw.close();

        }
        catch (Exception e) {
            System.out.println("Error!");
        }
    }
}