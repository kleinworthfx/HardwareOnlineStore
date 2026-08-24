package za.ac.cput.util;

import java.math.BigDecimal;

/* Helper.java
   Helper Util Entity using regex
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

public class ValidationUtil {
    private static volatile ValidationUtil instance;

    private ValidationUtil() {}

    public static ValidationUtil getInstance() {
        if (instance == null) {
            synchronized (ValidationUtil.class) {
                if (instance == null) instance = new ValidationUtil();
            }
        }
        return instance;
    }
    public boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public void requireNotBlank(String field, String value) {
        if (!isNotBlank(value)) throw new IllegalArgumentException(field + " must not be blank");
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    //////////////////////////////////////////////

    public static boolean isValidString(String value) {
        return !isNullOrEmpty(value);
    }

    public static boolean isPositiveNumber(int value) {
        return value > 0;
    }

    public static boolean isNonNegativeNumber(int value) {
        return value >= 0;
    }

    public static boolean isPositiveAmount(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isNonNegativeAmount(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isPositiveDouble(double value) {
        return value > 0;
    }
}


