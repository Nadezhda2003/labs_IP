public class Calculation {
    public static double cosi(double x, int k)
    {
        while (x<-2*Math.PI || x>2*Math.PI)
        {
            if (x<-2*Math.PI)
            {
                x+=2*Math.PI;
            }
            else
            {
                x-=2*Math.PI;
            }
        }
        int c = 2;
        double res = 1, d=-1*Math.pow(x,2)/2;
        double e=Math.pow(10, -k);
        while (Math.abs(d) >= e)
        {
            res+=d;
            c+=2;
            d*=(-1*Math.pow(x,2))/((c-1)*c);
        }
        return res;
    }
}
