package jbr.saxon;

import java.time.LocalDate;
import java.time.Period;

import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.lib.ExtensionFunctionDefinition;
import net.sf.saxon.om.Sequence;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.value.SequenceType;
import net.sf.saxon.value.StringValue;

public class AgeCalculator extends ExtensionFunctionDefinition {

	@Override
	public SequenceType[] getArgumentTypes() {
		return new SequenceType[] { SequenceType.SINGLE_STRING };
	}

	@Override
	public StructuredQName getFunctionQName() {
		return new StructuredQName("up", "http://example.com/saxon-extension", "upper");
	}

	@Override
	public SequenceType getResultType(SequenceType[] arg0) {
		return SequenceType.SINGLE_STRING;
	}

	@Override
	public ExtensionFunctionCall makeCallExpression() {
		return new ExtensionFunctionCall() {

			@Override
			public Sequence call(XPathContext ctx, Sequence[] args) throws XPathException {
				String output = null;

				String[] input = args[0].iterate().next().getStringValue().split("-");
				int year = Integer.valueOf(input[0]);
				int month = Integer.valueOf(input[1]);
				int dayOfMonth = Integer.valueOf(input[2]);

				LocalDate dob = LocalDate.of(year, month, dayOfMonth);
				output = String.valueOf(Period.between(dob, LocalDate.now()).getYears());

				return StringValue.makeStringValue(output);
			}

		};
	}

}
