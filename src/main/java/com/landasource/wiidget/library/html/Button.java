package com.landasource.wiidget.library.html;

import com.landasource.wiidget.annotation.Attribute;

public class Button extends HtmlTagWiidget {

	@Attribute
	private String type = "button";

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type) {
		this.type = type;
	}

}
