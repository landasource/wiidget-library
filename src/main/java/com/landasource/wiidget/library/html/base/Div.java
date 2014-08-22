package com.landasource.wiidget.library.html.base;

import com.landasource.wiidget.annotation.Attribute;

import com.landasource.wiidget.library.html.HtmlTagWiidget;

public class Div extends HtmlTagWiidget {

	@Attribute(name = "class")
	public String cssClass;

	@Attribute
	public String style;

}
