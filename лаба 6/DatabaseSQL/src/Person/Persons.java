package Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Persons implements  Cloneable{
    public ArrayList<Person> persons;
    public Persons() {
        persons = new ArrayList<>();
    }

    public void Add(Person b) {
        persons.add(b);
    }

    public void read(String FileName) throws IOException {
        Scanner in=new Scanner(new File(FileName));
        String res="";
        while(in.hasNextLine())
        {
            res=in.nextLine();
            String[] mas=res.split(" ");
            persons.add(new Person(Integer.parseInt(mas[0]), mas[1], mas[2], mas[3]));
        }
        in.close();
    }
    public int getSize() {return persons.size();}
    public void print() {
        var stream = persons.stream();
        stream.forEach(System.out::println);
    }
}