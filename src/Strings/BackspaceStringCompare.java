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
		int hashCharCount = 0;

		int len1 = S.length() - 1;
		int len2 = T.length() - 1;

		while(len1 >= 0 || len2 >= 0){
			for(int i = len1; i >= 0; i--){
				if(S.charAt(i) == '#'){
					hashCharCount++;
					len1--;
				}else if(hashCharCount > 0){
					hashCharCount--;
					len1--;
				}else{
					break;
				}
			}

			for(int j = len2; j >= 0; j--){
				if(T.charAt(j) == '#'){
					hashCharCount++;
					len2--;
				}else if(hashCharCount > 0){
					hashCharCount--;
					len2--;
				}else{
					break;  
				}
			}

			//checks the character
			if((len1 >= 0) && (len2 >= 0) && (S.charAt(len1) != T.charAt(len2))){
				return false;
			}

			//checks the string size. At the end they both have to be equal
			if((len1 != len2) && !((len1 >= 0) && (len2 >= 0))){
				return false;
			}

			len1--;
			len2--;
		}

		return true;
	}

	public static boolean backspaceCompareForward(String S, String T) {
		String sFinal = finalString(S);
		String tFinal = finalString(T);
		return sFinal.equals(tFinal);
	}

	public static String finalString(String str){
		StringBuilder strFinal = new StringBuilder();
		for(int i = 0; i< str.length(); i++){
			char c = str.charAt(i);
			if(c != '#')
				strFinal.append(c);
			else{
				if(strFinal.length() > 0)
					strFinal.deleteCharAt(strFinal.length() - 1);
			}   
		}
		return strFinal.toString();
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
		System.out.println(backspaceCompare("bxjt#w", "bxjw"));
		System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw"));
	}

}
