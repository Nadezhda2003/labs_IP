import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.json"));
        Scanner in=new Scanner(System.in);
        Library _json = new Gson().fromJson(br,Library.class);
        System.out.println("\nПолный список:");
        _json.output();
        System.out.println("--------------------------------");
        _json.sort_mas();
        _json.output();
        System.out.println();
        FileWriter fw = new FileWriter("output.json");
        fw.write(new Gson().toJson(_json));
        fw.close();
        System.out.println("--------------------------------\n Grouping");
        Stream<Book> bookStream = _json.t.stream();

        Map<String, List<Book>> bookByAuthor = bookStream.collect(
                Collectors.groupingBy(Book::getAuthor));

        for(Map.Entry<String, List<Book>> item : bookByAuthor.entrySet()){
            System.out.println("\n"+item.getKey()+"\n");
            for(Book book : item.getValue()){

                System.out.println(book.getName());
            }
        }
        System.out.println("-------------------\n Filtering");
            String fil = in.nextLine();
            Stream<Book> BookStream = _json.t.stream();
            BookStream.filter(book->book.getAuthor().equals(fil)).forEach(book->System.out.println(book.name));
    }
}