package mitratech.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  SplitWords {
    public static String[] WordSplit(String[] strArr, String str) {
        // Create a pattern to match each word within the string
        StringBuilder patternBuilder = new StringBuilder();
        for (String word : strArr) {
            patternBuilder.append("\\b").append(Pattern.quote(word)).append("\\b|");
        }
        String patternStr = patternBuilder.toString();
        patternStr = patternStr.substring(0, patternStr.length() - 1); // Remove the last "|"
        
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        
        // Split the string around each matched word
        return pattern.split(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordsInput = scanner.nextLine();
        String[] strArr = wordsInput.split(",");

        // Input the string
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();

        // Call WordSplit function with user input words and string
        String[] result = WordSplit(strArr, str);
        
        // Print the parts of the string that are split
        for (String part : result) {
            System.out.println(part.trim());
        }

        scanner.close();
    }
}
