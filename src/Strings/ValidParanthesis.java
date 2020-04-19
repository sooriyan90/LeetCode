package Strings;

import java.util.ArrayList;
import java.util.Stack;
/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 */
public class ValidParanthesis {
	public static boolean checkValidString(String s) {
		char[] char_arr = s.toCharArray();
		if(char_arr.length == 0) {
			return true;
		}
		Stack<Character> stack_par = new Stack<Character>();
		for (int i=char_arr.length-1; i >= 0 ; i--) {
			if (char_arr[i] == ')' || char_arr[i] == '*') {
				stack_par.push(char_arr[i]);
			}
			// The case for left paranthesis
			else {
				// If the ( paranthesis occurs and then there is no correspoding )/*. Then we return false.
				if (stack_par.empty()) {
					System.out.println(i);
					return false;
				}
				else {
					int count_aster = 0;
					int size = stack_par.size();
					// We pop until ) is the top element
					while (!stack_par.empty() && stack_par.peek() == '*') {
						count_aster++;
						stack_par.pop();
					}
					// all the elements in the stack were *
					if (stack_par.empty()) {
						count_aster = size - 1;
					}
					else {
						stack_par.pop(); // Popping the top )
					}
					// Re-inserting the elements after the pop
					for (int j=0; j<count_aster; j++) {
						stack_par.push('*');
					}
				}
			}
		}
		// If the stack is empty everything matched, or if the stack has asterisk
		if (stack_par.empty()) {
			return true;
		}
		// If there is a left over close paranthesis, then we have to fail
		else if (stack_par.peek() == ')') {
			return false;
		}
		else if (stack_par.peek() == '*') {
			int aster_count = 0;
			while (!stack_par.empty()) {
				char c = stack_par.pop();
				if (c == '*') {
					aster_count++;
				}
				else {
					// If it has no prior *
					if (aster_count == 0) {
						return false;
					}
					// If there is a right paranthesis, decrement the * count
					else {
						aster_count--;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean checkValidStringAL(String s) {
		char[] char_arr = s.toCharArray();
		if(char_arr.length == 0) {
			return true;
		}
		ArrayList<Character> track_par = new ArrayList<Character>();
		for (int i=char_arr.length-1; i >= 0 ; i--) {
			if (char_arr[i] == ')' || char_arr[i] == '*') {
				track_par.add(0, char_arr[i]);
			}
			// The case for left paranthesis
			else {
				// If the ( paranthesis occurs and then there is no correspoding )/*. Then we return false.
				if (track_par.isEmpty()) {
					return false;
				}
				else {
					int initial_size = track_par.size();
					for (int j=0; j<initial_size; j++) {
						if (track_par.get(j) == ')') {
							track_par.remove(j);
							break;
						}
					}
					// This happens when no ) was found
					if (initial_size == track_par.size()) {
						track_par.remove(0);
					}
				}
			}
		}
		// If the stack is empty everything matched, or if the stack has asterisk
		if (track_par.isEmpty()) {
			return true;
		}
		// If there is a left over close paranthesis, then we have to fail
		else if (track_par.get(0) == ')') {
			return false;
		}
		else if (track_par.get(0) == '*') {
			int aster_count = 0;
			for (int i = 0; i<track_par.size(); i++) {
				if (track_par.get(i) == '*') {
					aster_count++;
				}
				else {
					// If it has no prior *
					if (aster_count == 0) {
						return false;
					}
					// If there is a right paranthesis, decrement the * count
					else {
						aster_count--;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkValidStringAL("(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))"));
		System.out.println(checkValidStringAL("(*))"));
		System.out.println(checkValidStringAL("()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))"));
	}

}
