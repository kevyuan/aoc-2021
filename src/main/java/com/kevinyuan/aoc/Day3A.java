package com.kevinyuan.aoc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * https://adventofcode.com/2021/day/3
 *
 */
public class Day3A {
	public static void main(String[] args) {

		String path = "src/main/resources/day3_input.txt";

		// Initialize variable to store all lines from the file
		List<String> lines = null;

		int lengthOfBinaryNumber = 0;
		int i = 0;
		int numberOfRows = 0;
		int numberOfRowsHalved = 0;
		String gammaRate = "";
		String epsilonRate = "";

		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the length of the binary numbers that we are using
		lengthOfBinaryNumber = lines.get(0).length();

		// Declare int array to store flattened result
		int[] flattenedResult = new int[lengthOfBinaryNumber];

		// Get the number of rows in the input
		numberOfRows = lines.size();
		numberOfRowsHalved = numberOfRows / 2;


		for (String line : lines) {

			for (i = 0; i < lengthOfBinaryNumber; i++) {
				if (Character.getNumericValue(line.charAt(i)) == 1) {
					flattenedResult[i]++;
				}
			}

		}

		for (i = 0; i < lengthOfBinaryNumber; i++) {
			System.out.print(flattenedResult[i] + ", ");
			if (flattenedResult[i] > numberOfRowsHalved) {
				gammaRate = gammaRate + "1";
				epsilonRate = epsilonRate + "0";
			} else {
				gammaRate = gammaRate + "0";
				epsilonRate = epsilonRate + "1";
			}
				
		}

		System.out.println();
		System.out.println(numberOfRows);
		System.out.println(gammaRate + " " + Integer.parseInt(gammaRate,2));
		System.out.println(epsilonRate + " " + Integer.parseInt(epsilonRate, 2));
		
		System.out.println("Result: " + Integer.parseInt(gammaRate,2) * Integer.parseInt(epsilonRate,2));
		
	}
}
