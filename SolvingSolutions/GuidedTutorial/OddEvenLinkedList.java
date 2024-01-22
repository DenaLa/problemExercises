package oddEvenLinkedList;

public class OddEvenLinkedList {

//I don't know how to print this out to demonstrate what it does in leetcode.
//Please just insert the code into leetcode's problem to see it in action.

	
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
	

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
        	return null;
        }
    	
    	ListNode oddTrain = head;
    	ListNode evenTrain = head.next;
    	ListNode dummy = evenTrain;
    	
    	while(oddTrain.next != null && evenTrain.next != null) {
    		oddTrain.next = oddTrain.next.next;
    		evenTrain.next = evenTrain.next.next;
    		
    		oddTrain = oddTrain.next;
    		evenTrain = evenTrain.next;
    	}
    	
    	oddTrain.next = dummy;
    	
    	return head;
    }
}
