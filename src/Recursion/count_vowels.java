package Recursion;

public class count_vowels {

        public int countVowels(String s, int index) {
            if (index == s.length()) {
                return 0;
            }

            char ch = Character.toLowerCase(s.charAt(index));

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                return 1 + countVowels(s, index + 1);
            }

            return countVowels(s, index + 1);
        }

        public static void main(String[] args) {
            count_vowels obj = new count_vowels();
            System.out.println(obj.countVowels("hello", 0));
        }
    }

