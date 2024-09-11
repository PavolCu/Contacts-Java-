import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here
        String regex = "\\b\\d{10,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            String number = matcher.group();
            System.out.println(number + ":" + number.length());
        }
    }
}