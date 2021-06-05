import java.util.ArrayList;

public class Test {
	public static void main(String[] args){

		A a = new A();

		System.out.println(a);

		ArrayList<Integer> arr = a.getArr();

		arr.add(12);
		arr.add(13);
		arr.add(14);

		System.out.println(a);


	}
}


class A{
	private ArrayList<Integer> arr;
	public A(){
		this.arr = new ArrayList<Integer>();
		this.arr.add(3);
		this.arr.add(4);
		this.arr.add(5);
	}
	public ArrayList<Integer> getArr(){
		return this.arr;
	}
	@Override
	public String toString(){
		return this.arr.toString();
	}
}

