import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in= new Scanner(new File("input.txt"));
        int n= in.nextInt();
        Library k=new Library(n);
        for(int i=0;i<n;i++){
            String buf1=in.next();
            String buf2=in.next();
            k.input(buf1,buf2,i);
        }
        k.output();
        System.out.println("---------------------------------");
        k.sort_mas();
        k.output();
        String search_name;
        search_name=in.next();
        k.search(search_name);
    }
}