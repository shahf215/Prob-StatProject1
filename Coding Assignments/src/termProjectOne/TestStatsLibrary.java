package termProjectOne;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class TestStatsLibrary {

	public static void main(String[] args) {
		
		StatsLibrary test = new StatsLibrary();
		ArrayList<Integer> someNumbers = new ArrayList<>();
		someNumbers.add(1);
		someNumbers.add(2);
		someNumbers.add(3);
		someNumbers.add(4);
		someNumbers.add(5);
		someNumbers.add(5);
		someNumbers.add(3);

		double result = test.findMean(someNumbers);
		System.out.println("The average is : " + result);

		double median = test.findMedian(someNumbers);
		System.out.println("The median is : " + median);

		String mode = test.findMode(someNumbers);
		System.out.println("The mode is : " + mode);

		double sd = test.findSD(someNumbers);
		System.out.println("The standard deviation is : " + sd);

		BigInteger fac = test.calculateFactorial(7);
		System.out.println("\n7! = " + fac);

		BigInteger comb = test.calculateCombinations(10, 5);
		System.out.println("10 nCr 5 = " + comb);

		BigInteger per = test.calculatePermutations(10, 5);
		System.out.println("10 nPr 5 = " + per);

		ArrayList<Integer> SetA = new ArrayList<>();
		SetA.add(1);
		SetA.add(2);
		SetA.add(3);
		SetA.add(4);
		SetA.add(6);

		ArrayList<Integer> SetB = new ArrayList<>();
		SetB.add(1);
		SetB.add(3);
		SetB.add(5);
		SetB.add(7);

		System.out.println("\nSet A is: " + SetA);
		System.out.println("Set B is: " + SetB);

		ArrayList<Integer> union = test.Union(SetA, SetB);
		System.out.println("The union of Set A and Set B is: " + union);

		ArrayList<Integer> intersection = test.Intersection(SetA, SetB);
		System.out.println("The intersection of Set A and Set B is: " + intersection);

		ArrayList<Integer> complement = test.Complement(SetA, SetB);
		System.out.println("The complement of Set A and Set B is: " + complement);

		ArrayList<Integer> difference = test.Difference(SetA, SetB);
		System.out.println("The difference of Set A and Set B is: " + difference + "\n");

		// Example 3.8 from the textbook, page 105
		BigDecimal BD = test.binomialDist(10, 9, .3);
		System.out.println("The binomial distribution is " + BD + "\n");

		// Example from
		// https://calcworkshop.com/discrete-probability-distribution/geometric-distribution/
		double geoPMF = test.geometricPMF(6, .04);
		System.out.println("The geometric distribution is " + geoPMF);

		// Example 3.11 from the textbook, page 116
		double geoCDF = test.geometricCDF(3, .02);
		System.out.println("\nThe geometric cumulative distribution is " + geoCDF);
	}

}
