package main.java.mine;

public class Reverse {
    public static int reverse(int x) {
        boolean negativeNumber = false;
        if (x < 0) {
            negativeNumber = true;
            x = -x;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            char temporary = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temporary;
        }
        int rtn;
        try {
            rtn = Integer.parseInt(String.valueOf(chars));
            if (negativeNumber) {
                rtn = -rtn;
            }
        }
        catch (Exception ex) {
            return 0;
        }
        return rtn;
    }
    public static void main(String[] args) {
        int a = reverse(-123);
        System.out.println(a);
    }
}
