
public class C1 {

	public void m1(Object a) {
		System.out.println("m1 c1");
	}
	
	/*
	public void mNum(Object a) {
		System.out.println("m1 c1 num object");
	}
	*/
	public void mNum(Long a) {
		System.out.println("mNum c1 Long");
	}
	
	public void print(CC1 cc1) {
		cc1.print();
	}
	
	public CC1  cc1() {
		return new CC1("");
	}
	
	public static void main(String [] args) {
		
		C1 obj = new C2();
		obj.m1("QWE"); // by default maps to Parent class (Object class in this case)
		
		obj.mNum(0); //Since we have Object Long , it will not compile. Had method declaration used primitives , it would have worked
		
		System.out.println(obj.cc1());//cc2
		obj.print(new CC1(""));	
		
		Integer q = 1;
		C2 obj2 = new C2();
		obj2.mNum(12); // if int is there it maps to int . If not , then autoboxing is used and maps to Integer . If Integer is not there , maps to Object
		obj2.mNum(q);
	}
	
	
}
