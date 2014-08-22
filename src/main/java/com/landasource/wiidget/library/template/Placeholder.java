package com.landasource.wiidget.library.template;

import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.annotation.DefaultField;
import com.landasource.wiidget.validator.Required;

public class Placeholder extends Wiidget {

	@DefaultField
	@Required(message = "kell")
	private String name;

	@Override
	public void run() {
		write("{" + getName() + "}");
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
