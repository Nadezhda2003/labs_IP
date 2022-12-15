import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {
    public static String GetJavaFileWithoutComments(String fileName) throws FileNotFoundException {
        enum StringCondition {Start, StringBody, StringBody1,StringEnd1, StringEnd, SpecSymbol, CommentBegin, CommentToEnd, CommentLines, CommentEnd, Symbol, EscapeSymbol, SymbolEnd, StringConst, StringConst2}

        Scanner sc = new Scanner(new File(fileName));
        StringBuilder fileString = new StringBuilder();
        while (sc.hasNext()) {
            fileString.append(sc.nextLine() + '\n');
        }
        StringBuilder resultFile = new StringBuilder();
        var charArray = fileString.toString().toCharArray();

        StringCondition condition = StringCondition.Start;
        for (char c : charArray) {
            switch (condition) {
                case Start:
                    if(c == '"'){
                        //resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    else if (c=='\'')
                    {
                        //resultFile.append(c);
                        condition = StringCondition.StringBody1;
                    }
                    else if (c == '/'){
                        resultFile.append(c);
                        condition = StringCondition.CommentBegin;
                    }
                    else {
                        condition = StringCondition.Start;
                    }
                    break;
                case StringBody1:
                    if(c == '\''){
                        //resultFile.append(c);
                        condition = StringCondition.StringEnd1;
                    }
                    else if(c == '\\'){
                        //resultFile.append(c);
                        condition = StringCondition.SpecSymbol;
                    }
                    else {
                        //resultFile.append(c);
                        condition = StringCondition.StringBody1;
                    }
                    break;
                case StringBody:
                    if(c == '"'){
                        //resultFile.append(c);
                        condition = StringCondition.StringEnd;
                    }
                    else if(c == '\\'){
                        //resultFile.append(c);
                        condition = StringCondition.SpecSymbol;
                    }
                    else {
                        //resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    break;
                case SpecSymbol:
                    //resultFile.append(c);
                    condition = StringCondition.StringBody;
                    break;
                case StringEnd:
                    if(c == '"'){
                        //resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    else {
                        /*.out.println(resultFile.toString());
                        resultFile = new StringBuilder("");*/
                        condition = StringCondition.Start;
                    }
                    break;
                case StringEnd1:
                    if(c == '\''){
                        //resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    else {
                        /*System.out.println(resultFile.toString());
                        resultFile = new StringBuilder("");*/
                        condition = StringCondition.Start;
                    }
                    break;
                case CommentBegin:
                    if (c == '/') {
                        resultFile.append(c);
                        condition = StringCondition.CommentEnd;
                    }
                    else if (c == '*') {
                        resultFile.append(c);
                        condition = StringCondition.CommentLines;
                    }
                    else
                    {
                        condition=StringCondition.Start;
                    }
                    break;
                case CommentToEnd:
                    if (c == '\n') {
                        resultFile.append(c);
                        System.out.println(resultFile.toString());
                        resultFile = new StringBuilder("");
                        condition = StringCondition.Start;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.CommentToEnd;
                    }
                case CommentLines:
                    if (c == '*') {
                        resultFile.append(c);
                        condition = StringCondition.CommentEnd;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.CommentLines;
                    }
                    break;
                case CommentEnd:
                    if (c == '/') {
                        resultFile.append(c);
                        System.out.println(resultFile.toString());
                        resultFile = new StringBuilder("");
                        condition = StringCondition.Start;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.CommentLines;
                    }
                    break;
            }
        }
        return resultFile.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(GetJavaFileWithoutComments("input.txt"));
    }
}
