package javaFxValidation.rules;

import java.util.ArrayList;

@FunctionalInterface
public interface Matcher {

	public boolean matches(String fieldValue, ArrayList<String> ruleParameters);
}
