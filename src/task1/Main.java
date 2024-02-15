package task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        printAbbreviations(str);
    }
    private static void printAbbreviations(String str) {
        Pattern pattern = Pattern.compile("\\b[A-ZА-Я]{2,6}\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            do {
                System.out.println(matcher.group());
            } while (matcher.find());
        } else {
            System.out.println("Аббревиатуры в тексте не обнаружены");
        }
    }
}
