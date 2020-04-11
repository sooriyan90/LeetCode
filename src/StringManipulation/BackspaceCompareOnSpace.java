package StringManipulation;
import java.util.List;
import java.util.ArrayList;

/**
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
*/
public class BackspaceCompareOnSpace {
	public static boolean backspaceCompare(String S, String T) {
	 List<Character> s = new ArrayList<Character>();
     List<Character> t = new ArrayList<Character>();
     int counter_for_hash = 0;
     for (int i=S.length()-1; i >= 0; i--) {
         if (S.charAt(i) == '#') {
             counter_for_hash++; // Incrementing the counter for consecutive #
             continue;
         } 
         else {
             if (counter_for_hash > 0) {
                 counter_for_hash--; // Decrementing the counter for the first backstroke.
                 continue;
             }
             else {
                 s.add(0, S.charAt(i));
             }
         }
     }
     counter_for_hash = 0; // Resetting the variable
     for (int i=T.length()-1; i >= 0; i--) {
         if (T.charAt(i) == '#') {
             counter_for_hash++; // Incrementing the counter for consecutive #
             continue;
         } 
         else {
             if (counter_for_hash > 0) {
                 counter_for_hash--; // Decrementing the counter for the first backstroke.
                 continue;
             }
             else {
                 t.add(0, T.charAt(i));
             }
         }
     }
     if (s.size() != t.size()) {
         return false;
     }
     for (int j = 0; j < s.size(); j++ ) {
         if (s.get(j) != t.get(j)) {
             return false;
         }
     }
     return true;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
		System.out.println(backspaceCompare("bxjt#w", "bxjw"));
	}

}
