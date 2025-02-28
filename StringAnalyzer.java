import java.util.Scanner;

public class StringAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int specialChars = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }
            else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
            else if (ch >= '0' && ch <= '9') {
                digits++;
            }
            else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + specialChars);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
