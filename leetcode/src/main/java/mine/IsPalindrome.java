package main.java.mine;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x >= 0 && x / 10 == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int j = x - (x / 10 * 10);
        x = x / 10;
        while (j < x) {
            int k = x - (x / 10 * 10);
            x = x / 10;
            if (x == j) {
                return true;
            }
            else {
                j = j * 10;
                j = j + k;
            }
        }
        return j == x;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(10);
    }
}
