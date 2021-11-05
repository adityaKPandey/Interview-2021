
public class Solution {

	String col;
	/*
	 Given two numbers represented in form of a linked list, where each digit of number represents
	  node in linked list. 
Find the sum of these numbers and return the result again in form of a linked list. 
      Example : 9->9->2>3 + 9->8 = 1->0->0->2->1
	 
	 Node{
	   int data,
	   Node next;
	 }
	 
	 */
	
	public static  Node sum1(Node head1 , Node head2) {
		
		int len1 = findLen(head1);
		int len2 = findLen(head2);
		
		Node lesser = head1;
		Node more = head2;
		int diff = Math.abs(len1 - len2);
		if(len2 < len1) {
		    lesser = head2;
		    more = head1;
		}
		
		while(diff > 0) {
			Node node = new Node(0);
			node.next = lesser;
			lesser = node;
			diff--;
		}
		
		
		Node sum = add(lesser , more);
		
	    if(sum.carry > 0) {
	    	Node headResult = new Node(sum.carry);
	    	headResult.next = sum;
	    	return headResult;
	    }
	    return sum;
	}
	
	private static Node add(Node node1 , Node node2) {
		
		if(node1.next != null && node2.next != null) {
			Node res = add(node1.next , node2.next);
			Node res1 = simpleSum(node1, node2, res.carry);
			res1.next = res;
			return res1;
		}else {
			return simpleSum(node1, node2 , 0);
		}
		
		
		
	}

	private static  Node simpleSum(Node node1, Node node2 , int oldCarry) {
		int num1 = node1.data + node2.data  + oldCarry;
		
		int carry = num1/10;
		int toAdd = num1 % 10;
		Node res = new Node (toAdd);
		res.carry = carry;
		return res;
	}
	
	private static int findLen(Node node) {
		
		int len = 0;
		
		if(node != null)
		while(node.next != null) {
			node = node.next;
			len++;
			
		}
		return len;
		
	}
	
	public static Node sum(Node head1 , Node head2) {
		Node sum = null;
		Node temp1 = head1;
		Node temp2 = head2;
		
		int carry = 0 ;
		Node prevSumNode = null;
		while(temp1 != null && temp2 != null) {
			
			int num1 = carry + temp1.data + temp2.data ;
			
			carry = num1/10;
			int toAdd = num1 % 10;
			
			Node sumDigit = new Node(toAdd);
			
			sumDigit.next = prevSumNode;
			prevSumNode = sumDigit;
			
			temp1 = temp1.next;
			temp2 = temp2.next;
			
		}
		
		Node leftOver = temp1;
		if(temp2 != null)
			leftOver = temp2;
		
		while(leftOver != null) {
			
			int num2 = leftOver.data + carry ;
			Node sumDigit = new Node(num2%10);
			carry = num2/10;
			sumDigit.next = prevSumNode;
			prevSumNode = sumDigit;
			leftOver = leftOver.next;
			sum = sumDigit;
		}
				
		if(carry > 0) {
			//create node for carry
			Node carryNode = new Node(carry) ;
			carryNode.next = prevSumNode;
			
			sum = carryNode;
		}
		
		return sum;
	}
	
	public static void print(Node node) {
		System.out.println();
		Node temp = node;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		
		/*byte b1 = 40 , b2 = 40;
		int result = (int)(b1*b2);
		System.out.println(result);*/
		
		Solution s = new Solution();
		//System.out.println(s.sum1(new Node() , new Node()));
		
		// TODO Auto-generated method stub
        Node node11 = new Node();
        node11.data = 9;
        
        Node node12 = new Node();
        node12.data = 9;
        
        Node node13 = new Node();
        node13.data = 2 ;
        
        Node node14 = new Node ();
        node14.data = 3;
        
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        
        Node node21 = new Node();
        node21.data = 9;
        
        Node node22 = new Node();
        node22.data = 8 ;
        
        node21.next = node22;
        
        print(sum1(node21,node11));
        
	}

}
