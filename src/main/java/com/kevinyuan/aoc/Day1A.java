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
public class Day1A {
	public static void main(String[] args) {

		String path = "src/main/resources/day1_input.txt";

		List<String> lines = null;
		int measurements = 0;
		String first = null;
		String second = null;

		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String line : lines) {

			second = line;
			if (first == null) {
				System.out.println(line + " (N/A - no previous measurement)");
			}

			else if (Integer.parseInt(second) > Integer.parseInt(first)) {
				System.out.println(line + " (increased)");
				measurements++;
			}

			else {
				System.out.println(line + " (decreased)");
			}

			first = second;
		}

      System.out.println(measurements);
	}
}
