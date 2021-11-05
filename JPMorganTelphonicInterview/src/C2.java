public class C2 extends C1 {

	
	public void m1(String a) {
		System.out.println("m1 c2");
	}
	
	/*@Override
	public void m1(Object a) {
		System.out.println("o:m1 c1");
	}*/
	
	
	public void mNum(Integer a) {
		System.out.println("mNum c2 integer");
	}
	
	/*
	public void mNum(int a) {
		System.out.println("mNum c2 int");
	}
	*/
	public void mNum(Long a) {
		System.out.println("mNum c2 Long");
	}
	
	@Override
	public void print(CC1 cc1) {
		cc1.print();
	}
	
	@Override
	public CC2  cc1() {
		return new CC2("");
	}

}
