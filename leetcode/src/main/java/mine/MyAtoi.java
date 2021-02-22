package main.java.mine;
/**
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class MyAtoi {
    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
           return 0;
        }
        int i = 0;
        for (; i < s.length(); ++i) {
            if (!Character.isSpaceChar(s.charAt(i))) {
                break;
            }
        }
        char fuHao = '+';
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); ++j) {
            if (j == i) {
                if (s.charAt(j) == '+' || s.charAt(j) == '-') {
                    if (s.charAt(j) == '-') {
                        fuHao = '-';
                    }
                    continue;
                }
                else if (Character.isDigit(s.charAt(j))) {
                    sb.append(s.charAt(j));
                    continue;
                }
                else {
                    return 0;
                }
            }
            if (Character.isDigit(s.charAt(j))) {
                sb.append(s.charAt(j));
            }
            else {
                break;
            }
        }
        try {
            if (fuHao == '-') {
                return Integer.parseInt(sb.toString()) * -1;
            }
            return Integer.parseInt(sb.toString());
        }
        catch (Exception ex) {
            if (fuHao == '-') {
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
    }
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        myAtoi.myAtoi(".1");
    }
}
