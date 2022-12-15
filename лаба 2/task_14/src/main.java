import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

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
            fw.write('\n');
            TreeMap<Integer, Integer> min = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Integer frequency = min.get(matrix[i][j]);
                    min.put(matrix[i][j], frequency == null ? 1 : frequency + 1);
                }
            }
            for (Map.Entry entry : min.entrySet()) {
                fw.write(entry.getValue()+" "+ entry.getKey()+'\n');
            }
            int Min=0, count=0;
            for (Map.Entry entry : min.entrySet()) {
                if ((int)entry.getValue()==1)
                {
                    Min=(int)entry.getKey();
                    count++;
                    break;
                }
            }
            fw.write("\nМинимальное из чисел, встречающихся в заданной матрице ровно один раз.\n");
            if (count!=0)
                fw.write(Min+" ");
            else
                fw.write("В матрице нет чисел, повторяющихся только один раз.");
            scanner.close();
            fw.close();

        }
        catch (Exception e) {
            System.out.println("Error!");
        }
    }
}