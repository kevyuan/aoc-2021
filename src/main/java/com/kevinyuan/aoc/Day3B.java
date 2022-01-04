package com.kevinyuan.aoc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * https://adventofcode.com/2021/day/3
 *
 */
public class Day3B {

	public static void main(String[] args) {

		String path = "src/main/resources/day3_input.txt";

		// Initialize variable to store all lines from the file
		List<String> lines = null;

		String lifeSupportRating = null;
		String oxygenGeneratorRating = null;
		String co2ScrubberRating = null;


		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		oxygenGeneratorRating = getOxygenGeneratorRating(lines);
		co2ScrubberRating = getCo2ScrubberRating(lines);
		System.out.println("Result: " + Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2));

	}

	static String getOxygenGeneratorRating(List<String> lines) {
		// Get the length of the binary numbers that we are using
		int lengthOfBinaryNumber = lines.get(0).length();
		
		// Initialize lines to process
		List<String> linesToCopy = new ArrayList<String>();
		List<String> linesToProcess = new ArrayList<String>();
		linesToProcess.addAll(lines);
		
		int zeroes;
		int ones;
		int bitCriteria;
		
		String oxygenGeneratorRating = null;

		for (int i = 0; i < lengthOfBinaryNumber; i++) {

//			System.out.println("New loop");

			linesToCopy.clear();
			zeroes = 0;
			ones = 0;

			// Figure out which is most common value
			for (String line : linesToProcess) {
				if (line.charAt(i) == '1') {
					ones++;
				} else {
					zeroes++;
				}
			}

			if (ones >= zeroes) {
				bitCriteria = '1';
			} else {
				bitCriteria = '0';
			}

			// If ones are most common, keep all those lines
			for (String line : linesToProcess) {
				if (line.charAt(i) == bitCriteria) {
					linesToCopy.add(line);
				}
			}

			// Create the new list of lines to process
			linesToProcess.clear();
			linesToProcess.addAll(linesToCopy);

//			for (String line : linesToCopy) {
//				System.out.println(line);
//			}
			
			if (linesToProcess.size() == 1) {
				break;
			}

		}

		oxygenGeneratorRating = linesToProcess.get(0);
//		System.out.println(oxygenGeneratorRating + " " + Integer.parseInt(oxygenGeneratorRating, 2));
		
		return oxygenGeneratorRating;
	}
	
	static String getCo2ScrubberRating(List<String> lines) {
		// Get the length of the binary numbers that we are using
		int lengthOfBinaryNumber = lines.get(0).length();
		
		// Initialize lines to process
		List<String> linesToCopy = new ArrayList<String>();
		List<String> linesToProcess = new ArrayList<String>();
		linesToProcess.addAll(lines);
		
		int zeroes;
		int ones;
		int bitCriteria;
		
		String co2ScrubberRating = null;

		for (int i = 0; i < lengthOfBinaryNumber; i++) {

			System.out.println("New loop");

			linesToCopy.clear();
			zeroes = 0;
			ones = 0;

			// Figure out which is most common value
			for (String line : linesToProcess) {
				if (line.charAt(i) == '1') {
					ones++;
				} else {
					zeroes++;
				}
			}

			if (ones >= zeroes) {
				bitCriteria = '0';
			} else {
				bitCriteria = '1';
			}

			// If ones are most common, keep all those lines
			for (String line : linesToProcess) {
				if (line.charAt(i) == bitCriteria) {
					linesToCopy.add(line);
				}
			}

			// Create the new list of lines to process
			linesToProcess.clear();
			linesToProcess.addAll(linesToCopy);

			for (String line : linesToCopy) {
				System.out.println(line);
			}
			
			if (linesToProcess.size() == 1) {
				break;
			}

		}

		co2ScrubberRating = linesToProcess.get(0);
		System.out.println(co2ScrubberRating + " " + Integer.parseInt(co2ScrubberRating, 2));
		
		return co2ScrubberRating;
	}

}
