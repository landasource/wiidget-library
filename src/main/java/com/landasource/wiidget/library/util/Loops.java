package com.landasource.wiidget.library.util;

import java.util.ArrayList;
import java.util.List;

import com.landasource.wiidget.Wiidget;

/**
 * 
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 * 
 */
public class Loops extends Wiidget {

	public List<Integer> numbers(final int start, final int end, final int step) {
		final List<Integer> numbers = new ArrayList<>();

		for (int num = start; num <= end; num += step) {
			numbers.add(num);
		}
		return numbers;
	}

}
