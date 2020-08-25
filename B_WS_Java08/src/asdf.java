
class A{
	A(){
	}
	void hello() {
		System.out.println("h b");
	}
}
class B extends A{
	B(){
	}
	void hello() {
		System.out.println("h c");
	}
}
public class asdf {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A ab = new B();
		if(a instanceof A)
			System.out.println("A");
		if(a instanceof B)
			System.out.println("B");
		if(b instanceof A)
			System.out.println("C");
		if(b instanceof B)
			System.out.println("D");
		if(ab instanceof B)
			System.out.println("E");
	}

}
