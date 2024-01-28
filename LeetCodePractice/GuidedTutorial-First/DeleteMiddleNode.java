package deleteMiddleNode;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		ListNode e = new ListNode(5);
		ListNode d = new ListNode(4, e);
		ListNode c = new ListNode(3, d);
		ListNode b = new ListNode(2, c);
		ListNode a = new ListNode(1, b);

		System.out.println("We have a Linked list consisting of 1, 2, 3, 4, 5. It is length 5");
		System.out.println("With our function, we will remove 3.");
		System.out.println(b.toString() + "'s next value is " + b.next.toString());
		System.out.println("When we remove the middle, it's next value turns to " + deleteMiddle(a).toString());

	}

	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(){
			
		}
		
		ListNode(int val) { 
			this.val = val; 
			}
		
		ListNode(int val, ListNode next) { 
			this.val = val; this.next = next; 
			}
		
		public String toString() {
			return Integer.toString(this.val);
		}
	}
	
	public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
		
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        	
        	slow.next = slow.next.next;
		
		
        //for leetcode, return dummy.next since it is the head of the linkedlist
		return slow.next;
    }

}
