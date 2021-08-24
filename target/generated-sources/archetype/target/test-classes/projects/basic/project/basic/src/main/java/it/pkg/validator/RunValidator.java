package it.pkg.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import it.pkg.util.FunctionUtil;

/**
 * Run validator
 * @author max.martinez
 *
 */
public class RunValidator implements ConstraintValidator<Run, String> {
	 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return FunctionUtil.validateRUN(value);
            
        } catch (Exception e) {
            // log error
            return false;
        }
    }
}