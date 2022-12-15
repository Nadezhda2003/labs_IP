import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            try {
                Scanner scanner = new Scanner(new File("input.txt"));
                int n=scanner.nextInt();
                int m= scanner.nextInt();
                int max=0;
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
                int[]mas1=new int[m];
                int count=0, count1=0;
                for (int i=0; i<n; i++) {
                    for (int j = 0; j < m; j++)
                        fw.write(matrix[i][j] + " ");
                    fw.write('\n');
                }
                for (int i=0; i<n; i++) {
                    for (int j = 0; j < m; j++) {
                        mas1[j]=matrix[i][j];
                    }
                    Arrays.sort(mas1);
                    for (int k=0; k<m; k++)
                    {
                        if (mas1[k] == matrix[i][k]) {
                            count++;
                        }
                        if (mas1[mas1.length-k-1]==matrix[i][k]) {
                            count1++;
                        }
                    }
                    if (count==m || count1 == m)
                    {
                        if (max < mas1[mas1.length-1])
                            max=mas1[mas1.length-1];
                    }
                    count=0;
                    count1=0;
                }
                fw.write("\nМаксимальный элемент в строках, где элементы по убыванию/возрастанию.\n");
                fw.write(max+" ");
                scanner.close();
                fw.close();
            }
            catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
