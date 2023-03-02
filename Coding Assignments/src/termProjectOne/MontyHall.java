package termProjectOne;

import java.util.Random;

public class MontyHall {

	static Random random = new Random();

	private static int numOfDoors = 3;
	private static int numGames = 10000;

	static int winsWithSwitch = 0;
	static int winsWithoutSwitch = 0;

	public static void playGame() {

		for (int i = 0; i <= numGames; i++) {
			
			System.out.println("Results after " + i + " wins in the Monty Hall Game");
			
			// Randomly simulates which door contains the prize.
            int winningDoor = random.nextInt(numOfDoors);

            // Randomly simulates which door the player would select.
            int selectedDoor = random.nextInt(numOfDoors);

            // Randomly simulates which door is opened after initial selection
            int otherDoor;
            do {
                otherDoor = random.nextInt(numOfDoors);
            } while (otherDoor == winningDoor || otherDoor == selectedDoor);

            // This statement simulates the player not switching doors after the initial selection.
            if (selectedDoor == winningDoor) {
            	winsWithoutSwitch++;
            }
            
            // This statement simulates the player switching doors after the initial selection.
            int switchDoor;
            do {
                switchDoor = random.nextInt(numOfDoors);
            } while (switchDoor == selectedDoor || switchDoor == otherDoor);
		
            if (switchDoor == winningDoor) {
            	winsWithSwitch++;
        }
            //cast the number of wins to double and divide them by 100 to change them to decimal form
            double winPercentageWithoutSwitch = (double) winsWithoutSwitch / numGames * 100;
            double winPercentageWithSwitch = (double) winsWithSwitch / numGames * 100;

            System.out.println("Wins with switch: " + winsWithSwitch + " (" + winPercentageWithSwitch + "%)");
            System.out.println("Wins without switch: " + winsWithoutSwitch + " (" + winPercentageWithoutSwitch + "%)\n");
        }
    }
}