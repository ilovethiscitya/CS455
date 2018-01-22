/**
 * Created by jianzhe on 2017/10/14.
 */
public class isPalindrome {
    private static boolean isPalindrome(String test) {
        int length = test.length();

        if (length <= 1) return true;
        else {
            char first = Character.toLowerCase(test.charAt(0));
            char last = Character.toLowerCase(test.charAt(length - 1));

            if (Character.isLetter(first) && Character.isLetter(last)) {
                if (first == last) {
                    String shorter = test.substring(1,length - 1);
                    return isPalindrome(shorter); //return 的是下一层的结果啊，因为首尾去掉的子串已经是palindrome,只需要判断shorter是否是palindrome就行了
            }  else {
                    return false;
                }
            } else if (Character.isLetter(first)) {
                String shorter = test.substring(0,length - 1);
                return isPalindrome(shorter);
            } else {
                String shorter = test.substring(1);
                return isPalindrome(shorter);
            }
        }
    }
}
