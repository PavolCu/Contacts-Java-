import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        String regex = "(?i)\\b" + part + "\\w*\\b|\\b\\w*" + part + "\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        System.out.println(matcher.find() ? "YES" : "NO");
    }
}