package LinkedList;
/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * 
 * 
 * @author VenkataramaSooriyakumar
 *
 */
public class listNode {
	int val;
	listNode next;
	listNode() {}
	listNode(int val) { this.val = val; }
	listNode(int val, listNode next) { this.val = val; this.next = next; }

	public listNode rotateRight(listNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}
		int sizeOfList = 1;
		listNode curr = null;

		// finding the size of the list
		curr = head;
		while (curr.next != null) {
			curr = curr.next;
			sizeOfList++;
		}

		int numberOfRotations = k % sizeOfList;

		for (int i = 0; i < numberOfRotations; i++) {
			curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
				
			}
			curr.next.next = head;
			head = curr.next;
			curr.next = null;
		}
		return head;
	}
	// There is also another approach where you can travel upto size of the list (N) minus number of rotations, and then make the next pointer  point to the head
	// and then continue the iteration until the number of rotations expire and make the (N-numofrotations) point to NULL
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
