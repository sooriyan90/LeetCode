package StringManipulation;
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
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
	 public static boolean backspaceCompare(String S, String T) {
	        int i = S.length()-1;
	        int j = T.length()-1;
	        int counter_for_S = 0;
	        int counter_for_T = 0;
	        char s_char = ' ';
	        char t_char = ' ';
	        while(i>=0 && j>=0) {
	            if (S.charAt(i) == '#') {
	                counter_for_S++; // Incrementing the counter for consecutive #
	                i--;
	            }
	            else {
	                if (counter_for_S > 0) {
	                    counter_for_S--; // Decrementing the counter for the first backstroke.
	                    i--;
	                }
	                else {
	                    s_char = S.charAt(i);
	                }
	            }
	            if (T.charAt(j) == '#') {
	                counter_for_T++; // Incrementing the counter for consecutive #
	                j--;
	            }
	            else {
	                if (counter_for_T > 0) {
	                    counter_for_T--; // Decrementing the counter for the first backstroke.
	                    j--;
	                }
	                else {
	                    t_char = T.charAt(j);
	                }
	            }
	            if (s_char == ' ' || t_char == ' ') {
	                continue;
	            }
	            if (s_char == t_char) {
	                i--;
	                j--;
	                // Resetting the char variables
	                s_char = ' ';
	                t_char = ' ';
	            } 
	            else {
	            	// Encountered end of both string
		            if (j == 0 && i == 0) {
		                if (s_char != ' ' || t_char != ' ') {
		                    return false;
		                }
		            }
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
