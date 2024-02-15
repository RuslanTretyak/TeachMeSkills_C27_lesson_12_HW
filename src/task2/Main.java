package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "Программа на вход +(33)2879431 получает произвольный текст. В этом тексте может быть номер " +
                "документа(один или несколько) 1423-1512-51, емейл teachmeskills@gmail.com и номер " +
                "телефона +(29)2879431. Номер документа в формате: xxxx-xxxx-xx, где x - это любая цифра; номер " +
                "телефона в формате: +(xx)xxxxxxx. Документ может содержать не 1423-1512-52 всю +(44)2879431 " +
                "информацию teachme@gmail.com, т.е. например, может не содержать номер телефона, или другое. " +
                "Необходимо найти эту meskills@gmail.com информацию и вывести в консоль в формате 1423-1512-53";
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
