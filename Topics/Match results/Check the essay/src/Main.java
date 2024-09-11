import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String regex = "(?i)the\\s+key\\s+is\\s+" +
                "([bcdfghjklmnpqrstvwxyzBCDFGHJKL" +
                "MNPQRSTVWXYZ0-9]+|[aeiouAEIOU?!#]+)(?=\\s|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}