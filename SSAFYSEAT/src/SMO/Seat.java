package SMO;

import java.awt.Point;

public class Seat {
	String Name;
	String gender;
	int age;
	int row;
	int col;
	public Seat() {
		super();
	}

	
	public Seat(String name, String gender, int age, int row, int col) {
		super();
		Name = name;
		this.gender = gender;
		this.age = age;
		this.row = row;
		this.col = col;
	}


	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}



	

}
