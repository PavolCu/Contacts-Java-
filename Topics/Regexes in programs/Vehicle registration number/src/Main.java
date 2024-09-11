import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        /* write your code here */
        String regex = "[ABEKMHOPCTYX]{1}\\d{3}[ABEKMHOPCTYX]{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regNum);

        System.out.println(matcher.matches() ? "true" : "false");
    }
}