import java.util.*;

public class Library {
    ArrayList<Book> t = new ArrayList<Book>();

    Library() {
    }

    void sort_mas() {
        Collections.sort(t);
    }

    void input(String a, String b, int i) {
        t.add(new Book(a, b));
    }

    void output() {
        System.out.println(t.toString());
    }
    /*void search(String Name){
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
    }*/
}