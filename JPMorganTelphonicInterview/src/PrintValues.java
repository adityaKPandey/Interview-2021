

public class PrintValues {
	/*public void print(int val) {
		System.out.println("The int value is: " + val);
	}*/
	public void print(Long val) {
		System.out.println("The long value is: " + val);
	}

	public static void main(String[] args) {
		PrintValues obj = new PrintValues();
		obj.print(15);
		obj.print(8L);
	}
}
