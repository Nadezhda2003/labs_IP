import java.util.Comparator;

public class Book implements Comparable<Book> {
    String name;
    String author_name;
    Book(){
        name=" ";
        author_name=" ";
    }
    @Override
    public String toString(){
        return name + " " +author_name;
    }

    Book(String n1, String n2){
        name=n1;
        author_name=n2;
    }

    @Override
    public int compareTo(Book o) {
        return name.compareTo(o.name);
    }
}