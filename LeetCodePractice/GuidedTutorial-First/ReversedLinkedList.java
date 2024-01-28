package reversedLinkedList;


public class ReversedLinkedList {
	
	public static void main(String args[]) {
		ListNode e = new ListNode(5);
		ListNode d = new ListNode(4,e);
		ListNode c = new ListNode(3,d);
		ListNode b = new ListNode(2,c);
		ListNode a = new ListNode(1,b);
		
		
		ListNode head = reverseList(a);
		ListNode iterate = head;
		
		while(iterate !=null) {
			System.out.print(iterate.toString() + " ");
			iterate = iterate.next;
		}
		
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

    
    
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        
        while (head != null) {
        	next = head.next;
        	head.next = prev;
        	prev = head;
        	head = next;
        	
        }

        return prev;
    }// iterative
    
    
    
    
    
    
}
