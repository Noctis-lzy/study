package main.java.answer;

public class Reverse {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a = reverse(-123);
        System.out.println(a);
    }
}
