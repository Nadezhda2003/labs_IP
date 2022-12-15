import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Apteka {
    ArrayList<Medic> t = new ArrayList<Medic>();
    int n;
    void sort_mas()
    {
        Collections.sort(t, (Medic o1, Medic o2) -> o1.getName().compareTo(o2.getName()));
    }
    void sort_mas_reverse()
    {
        Comparator<Medic> comparator = (o1, o2) -> (int) (o1.getCost() - o2.getCost());
        Collections.sort(t, comparator.reversed());
    }
    void input(String a, String b, int c, int d, double e){
        t.add(new Medic(a,b, c, d, e));
    }
    void output(){
            System.out.println(t.toString());
    }
    void search(String Name){
        Medic medic = new Medic("","", 0, 0, 0);
        medic.name=Name;
        Comparator<Medic> comparator = Comparator.comparing(obj -> obj.name);
        int i =Collections.binarySearch(t, medic, comparator);
        if(i>=0) {
            System.out.println("Искомый элемент "+t.toString());
        }
        else{
            System.out.println("Препарата с таким названием нет");
        }
    }
}