import java.util.Comparator;

public class Medic {
    String name;
    String proizv;
    int srok;
    int count;
    double cost;
    Medic(){
        name="";
        proizv="";
        srok=0;
        count=0;
        cost=0;
    }
    @Override
    public String toString(){
        return name + " " +srok+" "+proizv+" "+count+" "+cost;
    }
    public double getCost()
    {
        return cost;
    }
    public String getProizv()
    {
        return proizv;
    }
    public String getName()
    {
        return name;
    }

    Medic(String n1, String n2, int a, int b, double c){
        name=n1;
        proizv=n2;
        srok=a;
        count=b;
        cost=c;
    }
}