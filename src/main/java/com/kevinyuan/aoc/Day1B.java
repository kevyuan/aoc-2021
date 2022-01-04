package com.kevinyuan.aoc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * https://adventofcode.com/2021/day/1
 *
 */
public class Day1B {
	public static void main(String[] args) {

		String path = "src/main/resources/day1_input.txt";

		List<String> lines = null;
		int measurements = 0;
		String first = null;
		String second = null;
		String third = null;
		String fourth = null;

		int windowFirst = 0;
		int windowSecond = 0;

		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String line : lines) {

			first = line;
			if (fourth == null) {
				// Do nothing
				if (third != null) {
					windowFirst = Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third);
					System.out.println(windowFirst + " (N/A - no previous sum)");
				}
			}

			else {
				windowFirst = Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third);
//				System.out.println("windowFirst: " + windowFirst);
				windowSecond = Integer.parseInt(second) + Integer.parseInt(third) + Integer.parseInt(fourth);
//				System.out.println("windowSecond: " + windowSecond);

				if (windowFirst > windowSecond) {
					System.out.println(windowFirst + " (increased)");
					measurements++;
				} else if (windowFirst == windowSecond) {
					System.out.println(windowFirst + " (no change)");
				} else
					System.out.println(windowFirst + " (decreased)");

			}

			fourth = third;
//			System.out.println("fourth: " + fourth);
			third = second;
//			System.out.println("third: " + third);
			second = first;
//			System.out.println("second: " + second);
		}

		System.out.println(measurements);
	}
}
