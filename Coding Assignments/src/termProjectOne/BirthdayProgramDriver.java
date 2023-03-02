package termProjectOne;

import java.util.Scanner;

public class BirthdayProgramDriver {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
		System.out.print("Enter the number of people: ");
        int numOfPeople = scanner.nextInt();
        
        System.out.print("Enter the number of times to simulate: ");
        int numOfSim = scanner.nextInt();

        BirthdayProgram birthdayProgram = new BirthdayProgram(numOfPeople, numOfSim);
	    birthdayProgram.calculateProbability();
        
	}
}
