import java.util.Arrays;
import java.util.Comparator;

public class Library {
    Book[] t;
    int n;
    Library(int k){
        n=k;
        t=new Book[n];
    }
    void sort_mas()
    {
        Arrays.sort(t);
    }
    void input(String a, String b, int i){
        t[i]=new Book(a,b);
    }
    void output(){
        for(int i=0;i<n;i++){
            System.out.println(t[i].author_name+" "+t[i].name);
        }
    }
    void search(String Name){
        Book book = new Book("","");
        book.name=Name;
        Comparator<Book> comparator = Comparator.comparing(obj -> obj.name);
        int i =Arrays.binarySearch(t, book, comparator);
        if(i>0) {
            System.out.println("Искомый элемент "+t[i].author_name + " " + t[i].name);
        }
        else{
            System.out.println("Книги с таким автором нет");
        }
    }
}