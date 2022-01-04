package com.kevinyuan.aoc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * https://adventofcode.com/2021/day/2
 *
 */
public class Day2A {
	public static void main(String[] args) {

		String path = "src/main/resources/day2_input.txt";

		List<String> lines = null;
//		String first = null;
//		String second = null;
//		String third = null;
//		String fourth = null;

		int horizontal = 0;
		int depth = 0;

		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String line : lines) {
			if (line.startsWith("forward")) {
//				System.out.println(line.substring(8));
				horizontal += Integer.parseInt(line.substring(8));
			}

			else if (line.startsWith("down")) {
//				System.out.println(line.substring(5));
				depth += Integer.parseInt(line.substring(5));
			}

			else if (line.startsWith("up")) {
//				System.out.println(line.substring(3));
				depth -= Integer.parseInt(line.substring(3));
			}

		}

//		System.out.println(horizontal);
		System.out.println(horizontal * depth);
	}
}
