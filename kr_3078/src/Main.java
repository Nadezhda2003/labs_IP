import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int prv, cur;
        prv=in.nextInt();
        if (prv!=0)
        {
            cur=in.nextInt();
            int count = 1, count_max = 1;
            int sgn_prv = cur - prv, sgn_cur;

            while (cur != 0)
            {
                sgn_cur = cur - prv;
                if (sgn_prv * sgn_cur > 0)
                    count++;
                else
                    if (sgn_prv * sgn_cur == 0)
                        count = 1;
                    else
                        count = 2;
                count_max = Math.max(count_max, count);
                sgn_prv = sgn_cur;
                prv = cur;
                cur=in.nextInt();
            }
            System.out.println(count_max);
        }
        else
            System.out.println(0);
    }
}
