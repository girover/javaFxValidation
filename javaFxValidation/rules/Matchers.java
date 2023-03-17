package javaFxValidation.rules;

import static javaFxValidation.Str.*;

import java.util.ArrayList;

import javaFxValidation.Regex;
import javaFxValidation.ValidationException;

public class Matchers {

	/*
	 * Explicit rules
	 */
	public static boolean required(String value, ArrayList<String> ruleParameters) {
		if(value == null || value.isBlank())
			return false;
		
		return true;
	}
	
	public static boolean notEmpty(String value, ArrayList<String> ruleParameters) {
		return !isEmpty(value);
	}
	
	public static boolean alpha(String value, ArrayList<String> ruleParameters) {
		return isAlpha(value);
	}
	
	public static boolean alphaNumeric(String value, ArrayList<String> ruleParameters) {
		return isAlphaNumeric(value);
	}
	
	public static boolean alphaDash(String value, ArrayList<String> ruleParameters) {
		return isAlphaDash(value);
	}
	
	public static boolean email(String value, ArrayList<String> ruleParameters) {
		return isEmail(value);
	}
	
	public static boolean numeric(String value, ArrayList<String> ruleParameters) {
		return isNumeric(value);
	}
	
	public static boolean date(String value, ArrayList<String> ruleParameters) {
		return isDate(value);
	}
	
	public static boolean Boolean(String value, ArrayList<String> ruleParameters) {
		return isBoolean(value);
	}
	
	/**
	 * Parameterized rules
	 * @throws ValidationException 
	 */
	public static boolean digits(String value, ArrayList<String> ruleParameters) {
		
		if(!isNumeric(value))
			return false;
		
		return value.length() == Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean between(String value, ArrayList<String> ruleParameters) {
		
		try {
			long fValue = Long.parseLong(value);
			long param1 = Long.parseLong(ruleParameters.get(0));
			long param2 = Long.parseLong(ruleParameters.get(1));
			
			if(fValue >= param1 && fValue <= param2)
				return true;
			
			return false;
			
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean max(String value, ArrayList<String> ruleParameters) {
		
		// if the value is number so max is value.
		if(isNumeric(value))
			return Long.parseLong(value) < Long.parseLong(ruleParameters.get(0));
		// otherwise Max is a length of the value
		return value.length() < Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean min(String value, ArrayList<String> ruleParameters) {
		
		// if the value is number so min is value.
		if(isNumeric(value))
			return Long.parseLong(value) > Long.parseLong(ruleParameters.get(0));
		// otherwise Min is a length of the value
			return value.length() > Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean digitsMax(String value, ArrayList<String> ruleParameters) {
		
		return value.length() <= Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean digitsMin(String value, ArrayList<String> ruleParameters) {
		
		return value.length() >= Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean lengthEqual(String value, ArrayList<String> ruleParameters) {
		
		return value.length() == Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean lengthMax(String value, ArrayList<String> ruleParameters) {
		
		return value.length() <= Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean lengthMin(String value, ArrayList<String> ruleParameters) {
		
		return value.length() >= Integer.parseInt(ruleParameters.get(0));
	}
	
	public static boolean in(String value, ArrayList<String> ruleParameters) {
		
		return ruleParameters.contains(value);
	}
	
	public static boolean notIn(String value, ArrayList<String> ruleParameters) {
		
		return !ruleParameters.contains(value);
	}
	
	public static boolean greaterThan(String value, ArrayList<String> ruleParameters) {
		
		return compareValue(value, ruleParameters, ">");
	}
	
	public static boolean greaterThanOrEqual(String value, ArrayList<String> ruleParameters) {
		
		return compareValue(value, ruleParameters, ">=");
	}
	
	public static boolean lessThan(String value, ArrayList<String> ruleParameters) {
		
		return compareValue(value, ruleParameters, "<");
	}
	
	public static boolean lessThanOrEqual(String value, ArrayList<String> ruleParameters) {
		
		return compareValue(value, ruleParameters, "<=");
	}
	
	public static boolean equal(String value, ArrayList<String> ruleParameters) {

			return value.equals(ruleParameters.get(0));
	}
	
	public static boolean dateFormat(String value, ArrayList<String> ruleParameters) {
		
		return isDate(value, ruleParameters.get(0));
	}
	
	public static boolean regexPattern(String value, ArrayList<String> ruleParameters) {
		
		return Regex.matches(value, ruleParameters.get(0));
	}
	
	public static boolean same(String value, ArrayList<String> ruleParameters) {
		
		return false;
	}
	
	private static boolean compareValue(String value, ArrayList<String> ruleParameters, String operator){
			try {
				Double v = Double.parseDouble(value);
				Double param = Double.parseDouble(ruleParameters.get(0));
				if(operator.equals(">="))
					return v >= param ? true : false;
				else if(operator.equals("<="))
					return v <= param ? true : false;
				else if(operator.equals("<"))
					return v < param ? true : false;
				else if(operator.equals(">"))
					return v > param ? true : false;
				else if(operator.equals("=="))
						return v == param ? true : false;
				
			} catch (Exception e) {
				return false;
			}
			return false;
	}
	
}
