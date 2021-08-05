package day14;

public class Student {
	private String name;
	private int jumsu1;
	private int jumsu2;
	private int jumsu3;
	
	public Student(String name, int jumsu1, int jumsu2, int jumsu3) {
		this.name = name;
		this.jumsu1 = jumsu1;
		this.jumsu2 = jumsu2;
		this.jumsu3 = jumsu3;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + jumsu1 + " " + jumsu2 + " " + jumsu3;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJumsu1() {
		return jumsu1;
	}
	public void setJumsu1(int jumsu1) {
		this.jumsu1 = jumsu1;
	}
	public int getJumsu2() {
		return jumsu2;
	}
	public void setJumsu2(int jumsu2) {
		this.jumsu2 = jumsu2;
	}
	public int getJumsu3() {
		return jumsu3;
	}
	public void setJumsu3(int jumsu3) {
		this.jumsu3 = jumsu3;
	}
	
	
	
}
