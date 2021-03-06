package com.landasource.wiidget.library.html;

import com.landasource.wiidget.Tag;

import com.landasource.wiidget.library.format.AbstractResourceLinkWiidget;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class CssFile extends AbstractResourceLinkWiidget {

	/**
	 * Media.
	 */
	private String media = "all";

	@Override
	public String getTemplate() {

		final String path = getEngine().getConfiguration().getUrlResolver().createURL(getUrl());

		return new Tag("link").a("rel", "stylesheet").a("href", path).a("media", getMedia()).toString();
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(final String media) {
		this.media = media;
	}

}
