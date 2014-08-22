package com.landasource.wiidget.library.html;

import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.util.Strings;

import com.landasource.wiidget.library.base.RenderableWiidget;

/**
 * 
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 * 
 */
public class ChildrenOrValueWiidget extends Wiidget implements
		RenderableWiidget {

	/**
	 * Rendered value
	 */
	private String value;

	private String renderedValue;

	@Override
	public void init() {
		super.init();

		startBuffer();
	}

	@Override
	public void run() {
		super.run();

		String children = endBuffer();
		if (Strings.isEmpty(children)) {
			renderedValue = getValue();
		} else {
			renderedValue = children;
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String render() {
		return renderedValue;
	}

}
