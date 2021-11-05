
public class Node {

	 int data;
	 Node next;
	 int carry = 0;
	 
	 public Node(int data) {
		 this.data = data;
	 }
	 
	 public Node() {
		 
	 }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	 
}
