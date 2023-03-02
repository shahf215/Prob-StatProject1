/*
 * This class contains methods for calculating statistical measures, such as mean, median, mode, and standard deviation.
 * It also includes methods for calculating factorials, combinations, and permutations.
 */

package termProjectOne;

import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.BigInteger;

public class StatsLibrary {

	/**
	 * Returns the average of an ArrayList
	 * 
	 * @param inputNumbers : the list integers that will later be created and used to calculate the average.
	 * @return Average of the ArrayList
	 */

	public double findMean(ArrayList<Integer> inputNumbers) {

		double sum = 0;
		
		// sum of all the individual numbers in the ArrayList "inputNumbers"
		for (int singleElement : inputNumbers) {
			sum += singleElement;
		}

		double result = sum / inputNumbers.size();
		return result;
	}

	/**
	 * Returns the median of the ArrayList
	 * 
	 * @param inputNumbers: the list integers that will later be created and used to calculate the median number in the ArrayList.
	 * @return Median of the ArrayList
	 */

	public double findMedian(ArrayList<Integer> inputNumbers) {

		double median;
		
		//sort the ArrayList from least to greatest
		Collections.sort(inputNumbers);
		
		//this if-else statement takes the size of the ArrayList and checking to see if it is odd or even and using that information to find the median
		if (inputNumbers.size() % 2 == 1) {
			return inputNumbers.get((inputNumbers.size() + 1) / 2 - 1);
		}

		else {
			double lowerHalf = inputNumbers.get(inputNumbers.size() / 2 - 1);
			double upperHalf = inputNumbers.get(inputNumbers.size() / 2);

			return median = (lowerHalf + upperHalf) / 2.0;
		}

	}

	/**
	 * Returns the mode of the ArrayList
	 * 
	 * @param inputNumbers: the list integers that will later be created and used to find which number in the ArrayList occurs the most times.
	 * @return Mode of ArrayList
	 */

	public String findMode(ArrayList<Integer> inputNumbers) {

		int maxValue = 0;
		int maxCount = 0;
		int i;
		int j;

		for (i = 0; i < inputNumbers.size(); i++) {
			int count = 0;

			for (j = 0; j < inputNumbers.size(); j++) {
				if (inputNumbers.get(j) == inputNumbers.get(i))
					count++;
			}

			if (count > maxCount) {
				maxCount = count;
				maxValue = inputNumbers.get(i);
			}
		}

		int numOfModes = 0;
		
		// for loop to check if there is more than one mode
		for (i = 0; i < inputNumbers.size(); i++) {
			int count = 0;

			for (j = 0; j < inputNumbers.size(); j++) {
				if (inputNumbers.get(j) == inputNumbers.get(i))
					count++;
			}

			if (count == maxCount && inputNumbers.get(i) != maxValue) {
				numOfModes++;
				break;
			}
		}
		
		//if statement to check two or more numbers occur the same amount of times. If so it returns an error message and continues to parse the rest of the code.
		if (numOfModes > 0) {
			return "Due to two or more numbers occuring the same amount of times, no mode could be determined";
		} else {
			return String.valueOf(maxValue);
		}
	}

	/**
	 * Returns the standard deviation of the ArrayList
	 * 
	 * @param inputNumbers: the list integers that will later be created and used to find which number in the ArrayList occurs the most times.
	 * @return Standard Deviation of ArrayList
	 */
	public double findSD(ArrayList<Integer> inputNumbers) {

		double stdDev = 0.0;
		double mean = findMean(inputNumbers); //we already have a way to calculate the mean so we call that method.

		for (double temp : inputNumbers) {
			stdDev += (Math.pow(temp - mean, 2));
		}

		return Math.sqrt(stdDev / inputNumbers.size());
	}

	/**
	 * Returns the factorial of an integer as a BigInteger. If we cast to int there would be overflow at the higher ranges.
	 * 
	 * @param n : the number for which we want to calculate the factorial of
	 * @return the factorial of an integer
	 */
	public BigInteger calculateFactorial(int n) {

		BigInteger fact = BigInteger.valueOf(1);

		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}

	/**
	 * Calculates the number of combinations of selecting r number of items from a group of n number of items.
	 * 
	 * @param n the total number of items in the group
	 * @param r the number of items to be selected
	 * @return the number of combinations of selecting r number of items from a group of n number of items
	 */
	public BigInteger calculateCombinations(int n, int r) {

		//we call our previous method to calculate the factorials for us
		BigInteger factN = calculateFactorial(n);
		BigInteger factR = calculateFactorial(r);
		BigInteger factNSubR = calculateFactorial(n - r);

		return factN.divide(factR.multiply(factNSubR));
	}

	/**
	 * Calculates the number of permutations of r number of items from a group of n number of items, where order matters.
	 * 
	 * @param n the total number of distinct items
	 * @param r the number of items to be chosen
	 * @return the number of permutations of r items chosen from n distinct items
	 */
	public BigInteger calculatePermutations(int n, int r) {

		BigInteger factN = calculateFactorial(n);
		BigInteger factNSubR = calculateFactorial(n - r);

		return factN.divide(factNSubR);
	}
	
	/**
	 * Returns the union of two ArrayLists of Integers
	 * @param SetA the first ArrayList of Integers to be used for the union.
	 * @param SetB the second ArrayList of Integers to be used for the union.
	 * @return an ArrayList of Integers that contains all unique elements from SetA and SetB.
	 */
	public ArrayList<Integer> Union(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<Integer>(SetA.size() + SetB.size());

		for (int singleElement : SetA) {
			if (newSet.indexOf(singleElement) == -1) {
				newSet.add(singleElement);
			}
		}

		for (int singleElement : SetB) {
			if (newSet.indexOf(singleElement) == -1) {
				newSet.add(singleElement);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}
	
	/*
	 * Returns the intersection of two ArrayLists of Integers
	 * The resulting ArrayList contains all unique elements from SetA and SetB.
	 * @param SetA the first ArrayList of Integers
	 * @param SetB the second ArrayList of Integers
	 * @return an ArrayList of integers containing the elements that are present in both sets
	 */
	public ArrayList<Integer> Intersection(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<Integer>();

		for (int singleElement : SetA) {
			if (SetB.contains(singleElement)) {
				newSet.add(singleElement);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}

	/*
	 * Returns the Complement of two ArrayLists of Integers
	 * The resulting ArrayList contains all elements in SetB that are not in SetA.
	 * @param SetA the first ArrayList of Integers 
	 * @param SetB the second ArrayList of Integers 
	 * @return an ArrayList of integers representing the complement of SetA with respect to SetB
	 */
	public ArrayList<Integer> Complement(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<Integer>();

		for (int singleElement : SetB) {
			newSet.add(singleElement);

			if (SetB.contains(singleElement)) {
				newSet.removeAll(SetA);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}

	/*
	 * Calculates the difference between two sets
	 * The resulting ArrayList contains all elements in SetB that are not in SetA.
	 * @param SetA the first ArrayList of Integers
	 * @param SetB the second ArrayList of Integers
	 * @return an ArrayList of integers that represents the difference between SetA and SetB
	 */
	public ArrayList<Integer> Difference(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<Integer>();

		for (int singleElement : SetA) {
			newSet.add(singleElement);

			if (SetA.contains(singleElement)) {
				newSet.removeAll(SetB);
			}

		}

		Collections.sort(newSet);
		return newSet;
	}

	/*
	 * Calculates the probability mass function of the binomial distribution.
	 * @param numOfTrials the number of trials
	 * @param numOfSuccess the number of successful trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return he probability mass function of the binomial distribution
	 */
	public BigDecimal binomialDist(int numOfTrials, int numOfSuccess, double probOfSuccess) {

	    // Calculates the number of combinations
		BigInteger comb = calculateCombinations(numOfTrials, numOfSuccess);
		
	    // Calculates the probability of failure
		BigDecimal probOfFail = BigDecimal.ONE.subtract(BigDecimal.valueOf(probOfSuccess));
		BigDecimal binomDist;

	    // Calculates the binomial distribution
		binomDist = BigDecimal.valueOf(Math.pow(probOfSuccess, numOfSuccess))
				.multiply(BigDecimal.valueOf(Math.pow(probOfFail.doubleValue(), numOfTrials - numOfSuccess)));
		binomDist = binomDist.multiply(new BigDecimal(comb));

	    // Calculates the mean, variance, and standard deviation
		double mean = numOfTrials * probOfSuccess;
		double vari = mean * (1 - probOfSuccess);
		double stdDev = Math.sqrt(mean * (1 - probOfSuccess));

		System.out.println("The mean of the binomial distribution is : " + mean);
		System.out.println("The variance of the binomial distribution is : " + vari);
		System.out.println("The standard deviation of the binomial distribution is : " + stdDev);

		return binomDist;
	}
	
	/*
	 * Calculates the probability mass function (PMF) of a geometric distribution.
	 * @param numOfTrials the number of trials
	 * @param numOfSuccess the number of successful trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return the probability mass function of the geometric distribution
	 */
	public double geometricPMF(int numOfTrials, double probOfSuccess) {

	    // Calculates the probability mass function
		double geoPMF = probOfSuccess * (Math.pow((1 - probOfSuccess), (numOfTrials - 1)));

	    // Calculates the mean, variance, and standard deviation
		double mean = 1 / probOfSuccess;
		double vari = (1 - probOfSuccess) / Math.pow(probOfSuccess, 2);
		double stdDev = Math.sqrt(vari);

		System.out.println("The mean of the geometric distribution is : " + mean);
		System.out.println("The variance of the geometric distribution is : " + vari);
		System.out.println("The standard deviation of the geometric distribution is : " + stdDev);

		return geoPMF;
	}

	/*
	 * Calculates the cumulative distribution function (CDF) of a geometric distribution.	 
	 * @param numOfTrials the number of trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return the CDF of a geometric distribution as a double
	 */
	public double geometricCDF(double numOfTrials, double probOfSuccess) {

		double probOfFail = 1 - probOfSuccess;
		double geoCDF = 0.0;

		for (double i = 1.0; i <= numOfTrials; i++) {
			geoCDF = Math.pow((probOfFail), (numOfTrials - 1));
		}

		return geoCDF;
	}
}
