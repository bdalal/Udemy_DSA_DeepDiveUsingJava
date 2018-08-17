package deepdive.stack.challenges;

import deepdive.stack.impl.StackArrImpl;

public class StackChallenge1 {
    public static void main(String... args) {
        String[] checkPalindrome = {"I did, did I?", "raceCar", "HELLO"};
        String pattern = "[^a-zA-Z0-9]+";

        for (String pal : checkPalindrome) {
            StackArrImpl<String> s = new StackArrImpl<>(pal.length());
            String pal2 = pal.replaceAll(pattern, "");
            for (char c : pal2.toCharArray())
                s.push(String.valueOf(c));
            String res = "";
            while (true)
                try {
                    res += s.pop();
                } catch (IllegalAccessException e) {
                    break;
                }
            if (res.equalsIgnoreCase(pal2))
                System.out.println(pal + " IS a palindrome");
            else
                System.out.println(pal + " IS NOT a palindrome");
        }
    }
}
