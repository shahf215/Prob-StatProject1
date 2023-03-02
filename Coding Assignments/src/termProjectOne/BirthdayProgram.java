package termProjectOne;

import java.util.ArrayList;
import java.util.Random;

public class BirthdayProgram {

	private ArrayList<Person> people;
	private int numOfPeople;
	private int numOfSim;

	public BirthdayProgram(int numOfPeople, int numOfSim) {
		this.numOfPeople = numOfPeople;
		this.numOfSim = numOfSim;
		people = new ArrayList<>();

		for (int i = 0; i < numOfSim; i++) {
			genPeople();
			showBirthdays(i + 1);
			people.clear();
			System.out.println();
		}
	}

	public void genPeople() {

		Random random = new Random();

		for (int i = 0; i < numOfPeople; i++) {
			int birthMonth = random.nextInt(12) + 1;
			int maxNumDays = 31;

			if (birthMonth == 2) {
				maxNumDays = 28; //making a special case for February
			} 
			//making cases for all the months that only have 30 days
			else if (birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) {
				maxNumDays = 30;
			}

			int birthDay = random.nextInt(maxNumDays) + 1;
			int birthday = birthMonth * 100 + birthDay;

			Person person = new Person(birthday);
			people.add(person);
		}
	}

	public void showBirthdays(int simNumber) {
		System.out.println("\nSimulation #" + simNumber + ":");
		int studentID = 1;
		
		//This for loop prints the resulting birthdays of the people generated
		for (Person person : people) {
			System.out.println("Student " + studentID + "'s Birthday: " + person);
			studentID++;
		}

		//this set of loops counts the number of matching birthdays that are generated 
		//if two or more people in the set share a birthday it returns the count and date
		for (int month = 1; month <= 12; month++) {
			for (int day = 1; day <= 31; day++) {
				int count = 0;

				for (Person person : people) {
					if (person.getBirthMonth() == month && person.getBirthDay() == day) {
						count++;
					}
				}
				if (count > 1) {
					System.out.println(count + " people have a birthday on " + month + "/" + day);
				}
			}
		}
	}
	
	//Formula to calculate probability was derived from this website: https://betterexplained.com/articles/understanding-the-birthday-paradox/
	public void calculateProbability() {
	    double n = numOfPeople;
	    double probability =  1 - Math.exp(-n * (n - 1) / (2 * 365));
	    System.out.println("The probability of two people sharing a birthday in a class of " + numOfPeople + ": " + probability);
	}
}