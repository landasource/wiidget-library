package com.landasource.wiidget.library.template;

import java.util.List;
import java.util.Map;

import com.landasource.wiidget.Extension;
import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.WiidgetException;
import com.landasource.wiidget.antlr.WiidgetParser.StatementDeclarationContext;
import com.landasource.wiidget.parser.ParserException;
import com.landasource.wiidget.parser.StatementProcessor;

public class DynamicPart extends Wiidget implements Extension {

	private List<StatementDeclarationContext> statements;
	private StatementProcessor statementProcessor;

	/**
	 *
	 * @param context
	 * @return
	 */
	public String render(final Map<String, Object> context) {

		startBuffer();

		getEngine().getContext().setAll(context);

		try {
			statementProcessor.processStatements(statements);
		} catch (final ParserException e) {
			throw new WiidgetException("Cannot render", e);
		}

		final String buffer = endBuffer();
		return buffer;
	}

	public String render() {
		return render(data());
	}

	@Override
	public void processStatements(final List<StatementDeclarationContext> statements, final StatementProcessor statementProcessor) throws ParserException {
		this.statements = statements;
		this.statementProcessor = statementProcessor;

	}

}
