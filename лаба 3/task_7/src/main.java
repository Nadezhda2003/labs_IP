import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter fw = new FileWriter("output.txt");
            String text=scanner.nextLine();
            while (scanner.hasNextLine())
            {
                text+=" ";
                text+=scanner.nextLine();
            }
            String newtext="";
            char[] chr=text.toCharArray();
            for(char ch: chr)
            {
                if(Character.isLetter(ch) || Character.isWhitespace(ch))
                    newtext+=ch;
            }
            String[] words=newtext.split("\\s");
            newtext="";
            for(String st: words)
            {
                if(st.trim().length()>0)
                    newtext+=st+" ";
            }
            newtext=newtext.trim();
            fw.write(newtext);
            scanner.close();
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }
    }
}