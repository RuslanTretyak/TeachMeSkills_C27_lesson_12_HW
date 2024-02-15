package task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        findData(str);
    }
    private static void findData(String str) {
        Pattern pattern = Pattern.compile("\\b[0-9]{4}-[0-9]{4}-[0-9]{2}\\b|\\b[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\b|\\+\\([0-9]{2}\\)[0-9]{7}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            do {
                if (matcher.group().matches("[0-9]{4}-[0-9]{4}-[0-9]{2}")) {
                    System.out.println("document number: " + matcher.group());
                } else if (matcher.group().matches("[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+")) {
                    System.out.println("email: " + matcher.group());
                }else {
                    System.out.println("phone number:  " + matcher.group());
                }
            } while (matcher.find());
        } else {
            System.out.println("данные не обнаружены");
        }
    }
}
