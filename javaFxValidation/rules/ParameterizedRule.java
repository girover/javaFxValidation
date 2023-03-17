package javaFxValidation.rules;

import java.util.ArrayList;
import javaFxValidation.ValidationException;

public class ParameterizedRule extends Rule {

	/**
	 * Parameterized rules are rules that have parameters like:
	 * max:40 min:30       ---> max is a rule. 40 is a parameter.
	 * digits:10           ---> digits is a rule. 10 is a parameter.
	 * in:admin,student    ---> in is a rule. admin and student are parameters.
	 */
	protected ArrayList<String> parameters = new ArrayList<>();
	
	/**
	 * @param fieldName      The field under validation.
	 * @param fieldValue     The value of the field under validation.
	 * @param name           The rule this field must pass.
	 * @throws ValidationException
	 */
	public ParameterizedRule(String name) throws ValidationException {
		super(name);
		
		setMatcher(parseMatcher(getName()));
	}
	
	public ParameterizedRule(String name, ArrayList<String> params) throws ValidationException {
		this(name);
		parameters = params;
	}


	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(String param) {
		parameters.add(param);
	}
	
	public void addParameters(ArrayList<String> params) {
		parameters.addAll(params);
	}
	
	/**
	 * Here we generate Lambda function for a rule to match a field value.
	 * @param rule
	 * @return Lambda Function to matches a value for given rule.
	 * @throws ValidationException
	 */
	protected Matcher parseMatcher(String rule) throws ValidationException {
		switch (rule) {
		case "digits": {
			return Matchers::digits;
		}
		case "between": {
			return Matchers::between;
		}
		case "max": {
			return Matchers::max;
		}
		case "min": {
			return Matchers::min;
		}
		case "digits_max": {
			return Matchers::lengthMax;
		}
		case "digits_min": {
			return Matchers::lengthMin;
		}
		case "length": {
			return Matchers::lengthEqual;
		}
		case "length_max": {
			return Matchers::lengthMax;
		}
		case "length_min": {
			return Matchers::lengthMin;
		}
		case "in": {
			return Matchers::in;
		}
		case "notIn": {
			return Matchers::notIn;
		}
		case "gt": {
			return Matchers::greaterThan;
		}
		case "gte": {
			return Matchers::greaterThanOrEqual;
		}
		case "lt": {
			return Matchers::lessThan;
		}
		case "lte": {
			return Matchers::lessThanOrEqual;
		}
		case "equal": {
			return Matchers::equal;
		}
		case "format": {
			return Matchers::dateFormat;
		}
		case "regex": {
			return Matchers::regexPattern;
		}
		case "same": {
			return Matchers::same;
		}
		default:
			throw new ValidationException("Could not generate rule: " + rule);
		}
	}
}
