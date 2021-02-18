package main.java.mine;

public class LongestPalindrome {


    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] path = new boolean[length][length];
        String string = "";
        for (int l = 0 ; l < length; ++l) {
            for (int i = 0; i + l < length; ++i) {
                int j = i + l;
                if (l == 0) {
                    path[i][j] = true;
                }
                else if (l == 1) {
                    path[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    path[i][j] = (s.charAt(i) == s.charAt(j) && path[i + 1][j - 1]);
                }

                if (path[i][j] && j - i + 1 > string.length()) {
                    string = s.substring(i, j + 1);
                }
            }

        }
        return string;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
