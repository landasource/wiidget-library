package com.landasource.wiidget.library.template;

import java.nio.file.Path;

import com.landasource.wiidget.library.html.TemplatedHtmlWiidget;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class Template extends TemplatedHtmlWiidget {

	/**
	 * Name of the template. This is a file path.
	 */
	private String value;

	@Override
	protected String getTemplateName() {
		return getValue();
	}

	/**
	 *
	 * @return name of the directory of this template
	 */
	public String getDirectory() {
		final Path path = getEngine().getConfiguration().getFileLoader().getPath(getTemplateName());
		return path.getParent().toFile().getAbsolutePath();

	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
