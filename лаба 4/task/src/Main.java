import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in=new Scanner(new File("input.txt"));

        String text = " 123edd 31313 d.2 .3 330.2 ";
        Pattern pattern = Pattern.compile("\\s-?\\d+(\\.\\d+)?\\s");
        Matcher matcher = pattern.matcher(text);
        double res=0;
        String m;
        while (matcher.find()){
            m=text.substring(matcher.start(), matcher.end());
            System.out.print(m+" ");
            m.replaceAll("\\s+","");
            res+=Double.parseDouble(m);
        }
        System.out.println(res);
    }
}