/** QUESTION
 *
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 *
 * **/

package Strings;

public class PerformStringShift {

    /** SOLUTION 1
     *  Time Complexity - O(m * n) as there
     *  We are constantly changing the string on every iteration
     * **/
    public static String stringShift(String s, int[][] shift) {
        char[] sChar = s.toCharArray();
        for(int i = 0; i < shift.length; i++){
            int dir = shift[i][0];
            int amt = shift[i][1];
            if(dir == 0)
                sChar = rotateLeft(sChar, amt);
            else
                sChar = rotateRight(sChar,amt);
        }

        return String.valueOf(sChar);
    }

    public static char[] rotateLeft(char[] chars, int amt){
        char[] res = new char[chars.length];
        if(amt == chars.length)
            return chars;
        if(amt > chars.length)
            amt = amt - chars.length;
        int j = chars.length - 1;
        for(int i = chars.length - 1 ; i >= 0; i--){
            if(i - amt < 0)
                res[j--] = chars[i];
            else
                res[i - amt] = chars[i];
        }

        return res;
    }

    public static char[] rotateRight(char[] chars, int amt){
        char[] res = new char[chars.length];
        if(amt == chars.length)
            return chars;
        if(amt > chars.length)
            amt = amt - chars.length;
        int j = 0;
        for(int i = 0 ; i < chars.length; i++){
            if(i + amt > chars.length - 1)
                res[j++] = chars[i];
            else
                res[i + amt] = chars[i];
        }

        return res;
    }

    /** SOLUTION 2
     * O(m + n)
     * We only construct the final string once
     * We iterate over the shift array and find a final position of start index
     * Rotate the string or char array of string by the start index value to the right
     * **/
    public static String stringShiftOnce(String s, int[][] shift) {
        // the 0th index letter will be shifted to this index(startIndex) and all subsequent letters will be shifted by this number
        int startIndex = 0;
        for(int i = 0; i < shift.length; i++){
            int dir = shift[i][0];
            int amt = shift[i][1];
            startIndex = dir == 0 ? startIndex - amt: startIndex + amt;
            // always keep the start index within the array boundary
            if(startIndex > s.length())
                startIndex = startIndex - s.length();
            else
                startIndex = startIndex < 0 ? s.length() + startIndex : startIndex;
        }
        char[] sChar = rotate(s.toCharArray(), startIndex);
        return String.valueOf(sChar);
    }

    public static char[] rotate(char[] chars, int index){
        char[] res = new char[chars.length];
        if(index == chars.length)
            return chars;
        // if the index is beyond array length, pull it inside the array
        if(index > chars.length)
            index = index - chars.length;
        int j = 0;
        for(int i = 0 ; i < chars.length; i++){
            if(i + index > chars.length - 1)
                res[j++] = chars[i];
            else
                res[i + index] = chars[i];
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(stringShift("abc", new int[][]{{0,1}, {1,2}}));
        System.out.println(stringShift("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}));
        System.out.println(stringShiftOnce("abc", new int[][]{{0,1}, {1,2}}));
        System.out.println(stringShiftOnce("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}));
    }
}
