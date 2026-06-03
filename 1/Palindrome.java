public class Palindrome {
    public static void main(String[] args) {
        // Просто создаем массив слов для проверки
        String[] words = {"madam", "racecar", "apple", "kayak", "noon", "hello", "level", "world"};

        System.out.println("Проверка слов:");
        System.out.println("===============");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (isPalindrome(word)) {
                System.out.println(word + " -> палиндром") ;
            } else {
                System.out.println(word + " -> не палиндром ");
            }
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed = reversed + s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
}
