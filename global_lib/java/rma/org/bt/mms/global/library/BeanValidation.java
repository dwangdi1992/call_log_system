package rma.org.bt.mms.global.library;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * ====================================================================
 * Created by Dechen Wangdi on 3/2/2020.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified on:
 * Changes made :
 * ====================================================================
 */
public class BeanValidation {

    //TODO need to do again.
    public static String validate(Object dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

       /* Set<ConstraintViolation<dto>> violations = validator.validate(dto);

        for (ConstraintViolation<dto> violation : violations) {
            log.error(violation.getMessage());
        }*/

        return null;
    }
}
