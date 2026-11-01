
package Recursion;

public class CharacterOccurrence {

    public int countChar(String s, int index, char ch) {

        // Base case
        if (index == s.length()) {
            return 0;
        }

        if (s.charAt(index) == ch) {
            return 1 + countChar(s, index + 1, ch);
        }

        return countChar(s, index + 1, ch);
    }

    public static void main(String[] args) {
        CharacterOccurrence obj = new CharacterOccurrence();

        System.out.println(obj.countChar("hello", 0, 'l'));
    }
}