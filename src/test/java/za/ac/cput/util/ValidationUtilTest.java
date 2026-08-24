package za.ac.cput.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {
 @Test void singletonReturnsSameInstance(){assertSame(ValidationUtil.getInstance(), ValidationUtil.getInstance());}
 @Test void validationWorks(){assertTrue(ValidationUtil.getInstance().isValidEmail("a@b.com"));assertFalse(ValidationUtil.getInstance().isValidEmail("bad"));}
}
