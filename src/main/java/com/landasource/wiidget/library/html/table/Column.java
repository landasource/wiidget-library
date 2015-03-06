package com.landasource.wiidget.library.html.table;

import com.landasource.wiidget.Tag;
import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.WiidgetException;
import com.landasource.wiidget.annotation.DefaultField;
import com.landasource.wiidget.library.format.Formatter;
import com.landasource.wiidget.reflect.Reflection;

public class Column extends Wiidget {

	@DefaultField
	public String field;

	public String header;

	public String footer;

	public Formatter<Object> formatter;

	@Override
	public void run() {
	}

	public String renderRow(final Object object) {
		final StringBuilder builder = new StringBuilder();

		builder.append(Tag.tag("td", getValue(object)));

		return builder.toString();
	}

	protected String getValue(final Object object) {

		Object value;
		try {
			value = Reflection.getFieldValue(object, field);

		} catch (final IllegalArgumentException accessException) {
			throw new WiidgetException("Cannot read field value: " + field + " of" + object.getClass().toString(), accessException);
		}

		if (null == formatter) {
			return value.toString();
		}

		return formatter.format(value);

	}

	@Override
	public String toString() {
		return "Column [field=" + field + ", formatter=" + formatter + "]";
	}

	public String renderHeader() {

		if (header == null) {
			return "";
		}

		return Tag.tag("th", header);
	}

	public String renderFooter() {
		if (footer == null) {
			return "";
		}

		return Tag.tag("td", footer);
	}

}
