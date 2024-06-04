
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main2 {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// [2, 4, 3] = 342 + [5, 6, 4] = 465 == [7, 0, 8] = 807
		
		// Initial Variables
		Map<LinkedList<Integer>, LinkedList<Integer>> map = new HashMap<LinkedList<Integer>, LinkedList<Integer>>();
		LinkedList<Integer> ln_TEMP = new LinkedList<Integer>();
		String l1_sum = "";
		String l2_sum = "";
		String l3_sum = "";
		//
		// For Variables
		int node_length = 1;
		ListNode actual = l1;
		//
		
		//l1
		for(int i = 0; i <= node_length; i++) {
			if(actual != null) {
				ln_TEMP.add(actual.val);
				actual = actual.next;
				node_length++;
			}
		}
		
		ln_TEMP = ln_TEMP.reversed();
		
		for(Integer x : ln_TEMP) {l1_sum += x.toString();}
		
		ln_TEMP.clear();
		node_length = 1;
		actual = l2;
		//l2
		for(int i = 0; i <= node_length; i++) {
			if(actual != null) {
				ln_TEMP.add(actual.val);
				actual = actual.next;
				node_length++;
			}
		}

		ln_TEMP = ln_TEMP.reversed();
		
		for(Integer x : ln_TEMP) {l2_sum += x.toString();}
		
		//l3 - result
		ln_TEMP.clear();
		LinkedList<ListNode> ln = new LinkedList<>();
		l3_sum = new BigInteger(l1_sum).add(new BigInteger(l2_sum)).toString();
		for(int i = l3_sum.length() - 1; i >= 0; i--) {
			if(i == l3_sum.length() - 1) {
				ln.add(new ListNode(Integer.valueOf(l3_sum.substring(i))));
			}else if(i > 0) {
				ln.add(new ListNode(Integer.valueOf(l3_sum.substring(i, i+1))));
				ln.get(l3_sum.length() - (i + 2)).next = ln.get(l3_sum.length() - (i+1));
			}else {
				ln.add(new ListNode(Integer.valueOf(l3_sum.substring(0, 1))));
				ln.get(l3_sum.length() - (i + 2)).next = ln.get(l3_sum.length() - (i+1));
			}
		}
		
		return ln.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		ListNode node1_1 = new ListNode(9);
		
		ListNode node1_2 = new ListNode(1);
		ListNode node2_2 = new ListNode(9);
		ListNode node3_2 = new ListNode(9);
		ListNode node4_2 = new ListNode(9);
		ListNode node5_2 = new ListNode(9);
		ListNode node6_2 = new ListNode(9);
		ListNode node7_2 = new ListNode(8);
		ListNode node8_2 = new ListNode(9);
		ListNode node9_2 = new ListNode(9);
		ListNode node0_2 = new ListNode(9);
		
		node1_2.next = node2_2;
		node2_2.next = node3_2;
		node3_2.next = node4_2;
		node4_2.next = node5_2;
		node5_2.next = node6_2;
		node6_2.next = node7_2;
		node7_2.next = node8_2;
		node8_2.next = node9_2;
		node9_2.next = node0_2;
		
		System.out.println(addTwoNumbers(node1_1, node1_2));
	}
}
