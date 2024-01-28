package maxSumTwinLinkedList;


public class MaxSumTwinLinkedList {

	public static void main(String[] args) {
		ListNode d = new ListNode(1);
		ListNode c = new ListNode(2,d);
		ListNode b = new ListNode(4,c);
		ListNode a = new ListNode(5,b);
		
		
		System.out.println(pairSum(a));

	}

    public static int pairSum(ListNode head) {
        int ans = 0;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode tail = reverseList(slow);
        
        while(tail != null) {
        	ans = Math.max(ans, (head.val + tail.val));
        	head = head.next;
        	tail = tail.next;
        }

    	return ans;
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
	
	
	
}
