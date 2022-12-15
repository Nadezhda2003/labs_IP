import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\s(\\\"[а-яА-Яa-zA-Z\\s?]+\\\")\\s");
        Pattern pattern1=Pattern.compile("\\s(\\<[а-яА-Яa-zA-Z\\s?]+\\>)\\s");
        Pattern pattern2=Pattern.compile("\\s202[2-5]\\s");
        Pattern pattern3=Pattern.compile("\\s(\\d{1,2}|100)\\s");
        Pattern pattern4=Pattern.compile("\\s\\d+(?:\\.\\d+)\\s");
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int n= Integer.parseInt(in.readLine());
        Apteka k=new Apteka();
        String res;
        for(int i=0;i<n;i++){
            res=in.readLine();
            res=" "+res+" ";
            Matcher matcher = pattern.matcher(res);
            Matcher matcher1=pattern1.matcher(res);
            Matcher matcher2=pattern2.matcher(res);
            Matcher matcher3=pattern3.matcher(res);
            Matcher matcher4=pattern4.matcher(res);
            String a, b;
            int c, d;
            double e;
            a=b=" ";
            c=d=0;
            e=0;
            while (matcher.find())
            {
                a= matcher.group().trim();
            }
            while (matcher1.find())
            {
                b= matcher1.group().trim();
            }
            while (matcher2.find())
            {
                c= Integer.parseInt(matcher2.group().trim());
            }
            while (matcher3.find())
            {
                d= Integer.parseInt(matcher3.group().trim());
            }
            while (matcher4.find())
            {
                e = Double.parseDouble(matcher4.group().trim());
            }
            k.input(a, b, c, d, e);
        }
        k.output();
        System.out.println("---------------------------------\n reverse sort");
        k.sort_mas_reverse();
        k.output();
        System.out.println("---------------------------------\n sort");
        k.sort_mas();
        k.output();
        String search_name;
        search_name=in.readLine();
        System.out.println("---------------------------------\n search");
        k.search(search_name);
        System.out.println("--------------------------------\n Grouping");
        Stream<Medic> bookStream = k.t.stream();

        Map<String, List<Medic>> bookByAuthor = bookStream.collect(
                Collectors.groupingBy(Medic::getProizv));

        for(Map.Entry<String, List<Medic>> item : bookByAuthor.entrySet()){
            System.out.println("\n"+item.getKey()+"\n");
            for(Medic book : item.getValue()){

                System.out.println(book.toString());
            }
        }
    }
}