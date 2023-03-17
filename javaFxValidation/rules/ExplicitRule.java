package javaFxValidation.rules;

import javaFxValidation.ValidationException;

public class ExplicitRule extends Rule {

	/**
	 * @param fieldName      The field under validation.
	 * @param fieldValue     The value of the field under validation.
	 * @param name           The rule this field must pass.
	 * @throws ValidationException
	 */
	public ExplicitRule(String name) throws ValidationException {
		super(name);
		setMatcher(parseMatcher(name));
	}
	
	
	/**
	 * Here we generate Lambda function for a rule to check if the field value
	 * passes the given rule.
	 * @param rule
	 * @return Lambda Function to matches a value for given rule.
	 * @throws ValidationException
	 */
	protected Matcher parseMatcher(String rule) throws ValidationException {
		switch (rule) {
		case "required": {
			return Matchers::required;
		}
		case "notEmpty": {
			return Matchers::notEmpty;
		}
		case "alpha": {
			return Matchers::alpha;
		}
		case "alphaNumeric": {
			return Matchers::alphaNumeric;
		}
		case "alphaDash": {
			return Matchers::alphaDash;
		}
		case "email": {
			return Matchers::email;
		}
		case "numeric": {
			return Matchers::numeric;
		}
		case "date": {
			return Matchers::date;
		}
		case "boolean": {
			return Matchers::Boolean;
		}
		default:
			throw new ValidationException("Could not generate rule: " + rule);
		}
	}
}
