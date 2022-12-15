import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x;
        int k;
        x=in.nextDouble();
        k=in.nextInt();
        double res=Calculation.cosi(x, k);
        System.out.println(res);
    }
}