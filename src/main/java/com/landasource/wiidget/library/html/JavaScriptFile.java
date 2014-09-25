package com.landasource.wiidget.library.html;

import com.landasource.wiidget.Tag;

import com.landasource.wiidget.library.format.AbstractResourceLinkWiidget;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class JavaScriptFile extends AbstractResourceLinkWiidget {

	private String type = "text/javascript";

	public void setType(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String getTemplate() {

		final String path = getEngine().getConfiguration().getUrlResolver().createURL(getUrl());

		return new Tag("script").a("type", getType()).a("src", path).toString();
	}

}
