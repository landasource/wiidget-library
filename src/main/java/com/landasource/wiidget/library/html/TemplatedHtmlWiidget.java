package com.landasource.wiidget.library.html;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.landasource.wiidget.WiidgetException;
import com.landasource.wiidget.antlr.WiidgetLexerException;
import com.landasource.wiidget.basewiidgets.WiidgetLangCompiler;
import com.landasource.wiidget.io.StringTemplate;
import com.landasource.wiidget.library.BaseTagWiidget;
import com.landasource.wiidget.library.template.Part;
import com.landasource.wiidget.util.DataMap;
import com.landasource.wiidget.util.WiidgetProperties;

/**
 * The wiidgets extend this class have an template file. By default this file is
 * in the same folder, and named: '{class simple name}.wdgt'. To template file
 * we can put placeholders and variables.
 * <p>
 * </p>
 *
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public abstract class TemplatedHtmlWiidget extends BaseTagWiidget {

	/**
	 * Keyword to attach the current wiidget.
	 */
	public static final String THIS_VAR = "this";

	@Override
	public void init() {

		// bind this wiidget to context
		getWiidgetFactory().getWiidgetContext().set(THIS_VAR, this);

		startBuffer();
	}

	@Override
	public void run() {

		endBuffer();

		final String fileContent = getTemplateContent();
		final DataMap partMap = getPartMap();

		final String content = replacePlaceholders(fileContent, partMap);

		write(content);

		getWiidgetFactory().getWiidgetContext().remove(THIS_VAR);

	}

	/**
	 * Replaces placeholders.
	 *
	 * @param content
	 * @param data
	 * @return
	 */
	protected String replacePlaceholders(final String content, final DataMap data) {

		final StringTemplate stringTemplate = new StringTemplate(content);
		return stringTemplate.render(data);
	}

	/**
	 * The template name by default is: '{class simple name}.wdgt'.
	 *
	 * @return template file name
	 */
	protected String getTemplateName() {

		final String simpleName = StringUtils.uncapitalize(getClass().getSimpleName());

		final String packaged = '/' + getClass().getPackage().getName().replaceAll("\\.", "/") + '/' + simpleName;

		final String wiidgetExtension = getWiidgetFactory().getWiidgetProperties().getString(WiidgetProperties.WIIDGET_FILE_EXTENSION);

		// check wiidget template
		final InputStream template = getClass().getResourceAsStream(simpleName + wiidgetExtension);

		if (null == template) {
			final String extension = getWiidgetFactory().getWiidgetProperties().getDefault("wiidget.template.extension", ".wdgt");
			return packaged + extension;
		}

		return packaged + wiidgetExtension;
	}

	/**
	 * String content of template.
	 *
	 * @return content
	 */

	protected String getTemplateContent() {

		final String fileName = getTemplateName();
		final String fileContent = getFileContent(fileName);

		if (isCompilableTemplate(fileName)) {
			startBuffer();

			try {
				wiidget(WiidgetLangCompiler.class, data().set("value", fileContent));
			} catch (final WiidgetLexerException exception) {
				throw new WiidgetException("Failed to render file: " + fileName, exception);
			}

			final String compileResult = endBuffer(); // get compile result
			return compileResult;

		}
		return fileContent;
	}

	protected boolean isCompilableTemplate(final String fileName) {

		final WiidgetProperties properties = getWiidgetFactory().getWiidgetProperties();

		final String fileSuffix = properties.getString(WiidgetProperties.WIIDGET_FILE_EXTENSION);

		return fileName.endsWith(fileSuffix);
	}

	/**
	 * @return
	 */
	protected DataMap getPartMap() {

		final List<Part> partList = getChildren(Part.class);

		final DataMap partMap = new DataMap();

		for (final Part part : partList) {

			final String name = part.getName();
			final String content = part.getContent();

			partMap.put(name, content);
		}
		return partMap;
	}
}
