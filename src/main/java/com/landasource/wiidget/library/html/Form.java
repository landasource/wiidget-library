/**
 * 
 */
package com.landasource.wiidget.library.html;

import com.landasource.wiidget.annotation.Attribute;

import com.landasource.wiidget.library.html.table.Table;

/**
 * @author Zsolti
 */
public class Form extends HtmlTagWiidget {

	@Attribute
	private String method = "GET";

	@Attribute
	private String action = "?";

	public void label(final String value) {

		this.wiidget(Label.class, data().set("value", value));
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(final String method) {
		this.method = method;
	}

	public String getAction() {
		return action;
	}

	public void setAction(final String action) {
		this.action = action;
	}

	public void label() {
		this.wiidget(Label.class, data().set("value", "Form created" + getId()));
	}

	public void hello() {
		write("Itt vagyok");
	}

	public Input input() {
		return this.getEngine().createWiidget(Input.class);
	}

	public Table table() {

		final Table table = this.getEngine().createWiidget(
				Table.class);

		return table;

	}

}
