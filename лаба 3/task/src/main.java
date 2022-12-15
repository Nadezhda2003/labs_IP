import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class main {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(new File("input.txt"));
        //FileWriter fw = new FileWriter("output.txt");
        String text="";
        while (in.hasNext())
        {
            text+=in.nextLine();
        }
        double res=0;
        String m;
        Pattern pattern = Pattern.compile("\\s([+-]?(\\d*[.])?\\d+)|([+-]?\\d+\\.\\d+)\\s");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            m=text.substring(matcher.start(), matcher.end());
            System.out.print(m+" ");
            m.replaceAll("\\s+","");
            res+=Double.parseDouble(m);
        }
        System.out.println();
        System.out.println(res);
    }
}