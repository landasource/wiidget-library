package com.landasource.wiidget.library.html.table;

import java.util.List;

import com.landasource.wiidget.Extension;
import com.landasource.wiidget.WiidgetException;
import com.landasource.wiidget.antlr.WiidgetParser.StatementDeclarationContext;
import com.landasource.wiidget.parser.ParserException;
import com.landasource.wiidget.parser.StatementProcessor;

/**
 *
 * @author Zsolti
 *
 */
public class ContentColumn extends Column implements Extension {

	/**
	 * Variable of context.
	 */
	private String rowVar;

	private List<StatementDeclarationContext> renderedStatements;
	private StatementProcessor statementProcessor;

	@Override
	protected String getValue(final Object object) {

		startBuffer();

		getEngine().getContext().set(rowVar, object);

		try {
			statementProcessor.processStatements(renderedStatements);
		} catch (final ParserException e) {
			throw new WiidgetException("Cannot render", e);
		}

		final String buffer = endBuffer();
		return buffer;

	}

	public String getRowVar() {
		return rowVar;
	}

	public void setRowVar(final String rowVar) {
		this.rowVar = rowVar;
	}

	@Override
	public void processStatements(final List<StatementDeclarationContext> statements, final StatementProcessor statementProcessor) throws ParserException {
		this.statementProcessor = statementProcessor;
		this.renderedStatements = statements;
	}

}
