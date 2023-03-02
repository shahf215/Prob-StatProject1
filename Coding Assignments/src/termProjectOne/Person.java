package termProjectOne;

public class Person {
	private int birthday;
	
	public Person(int birthday) {
        this.birthday = birthday;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getBirthMonth() {
        return birthday / 100;
    }

    public int getBirthDay() {
        return birthday % 100;
    }
    
    //to display the int birthday in a more readable MM/DD format
    public String toString() {
        return String.format("%02d/%02d", getBirthMonth(), getBirthDay());
	}
}