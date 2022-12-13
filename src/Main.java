import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine(); //while true?
        System.out.println(calc(input));

    }
    public static String calc(String input) {

        String[] string = input.split(" "); // !
        int result = 0;
        String output = null;
        int index = 0;
        for (String s : string) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                index++;
            }
        }
        if (index == 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. строка не является математической операцией";
            }
        }
        if (index > 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
        }

        if (index == 1) {
            if (arabic(string[0]) && arabic(string[2])) {
                byte a = Byte.parseByte(string[0]);
                byte b = Byte.parseByte(string[2]);
                if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
                    if (string[1].equals("+")) {
                        result = a + b;
                        output = Integer.toString(result);
                    }
                    if (string[1].equals("-")) {
                        result = a - b;
                        output = Integer.toString(result);
                    }
                    if (string[1].equals("/")) {
                        result = a / b;
                        output = Integer.toString(result);
                    }
                    if (string[1].equals("*")) {
                        result = a * b;
                        output = Integer.toString(result);
                    }
                } else return "throws Exception //т.к. числа не удовлетворяют условию задания: 'от 1 до 10 включительно' ";
            } else if (roman(string[0]) && roman(string[2])) {
                int c = 0;
                int d = 0;
                String[] romaNum = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                for (int i = 0; i < romaNum.length; i++) {
                    if (string[0].equals(romaNum[i])) {
                        c = i + 1;
                    }
                    if (string[2].equals(romaNum[i])) {
                        d = i + 1;
                    }
                }
                if (string[1].equals("+")) {
                    result = c + d;
                }
                if (string[1].equals("-")) {
                    result = c - d;
                }
                if (string[1].equals("/")) {
                    result = c / d;
                }
                if (string[1].equals("*")) {
                    result = c * d;
                }
                if (result <= 0) {
                    return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                }
                String[] noBrain = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
                        "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV",
                        "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                        "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                        "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
                output = noBrain[result - 1];

            }
            else {
                return "throws Exception //т.к. используются одновременно разные системы счисления, либо не удовлетворяет условию задания: 'от I до X включительно'";
            }
        }
        return output;
    }
    public static boolean arabic(String str) {
        try {
            Byte.parseByte(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean roman(String str) {
        String[] romaNum = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int count = 0;
        for (String s : romaNum) {
            if (str.equals(s)) {
                count++;
                break;
            }
        }
        return count != 0;
    }
}

