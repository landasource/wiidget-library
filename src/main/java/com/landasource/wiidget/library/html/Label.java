/**
 * 
 */
package com.landasource.wiidget.library.html;

import com.landasource.wiidget.Tag;
import com.landasource.wiidget.Wiidget;

/**
 * @author Zsolti
 * 
 */
public class Label extends Wiidget {

	public String value;

	@Override
	public void run() {

		write(Tag.tag("label", value));

	}

	@Override
	public void init() {
	}
}
