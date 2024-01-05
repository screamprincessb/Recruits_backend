package com.sense.service.util;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {

    private static List<String> getExceptionMessageChain(Throwable throwable) {
        List<String> result = new ArrayList<>();
        while (throwable != null) {
            result.add(throwable.getMessage());
            throwable = throwable.getCause();
        }
        return result; //["THIRD EXCEPTION", "SECOND EXCEPTION", "FIRST EXCEPTION"]
    }

    public static String getLastErrorMessage(Throwable throwable) {
        String ex;

        List<String> errorList = getExceptionMessageChain(throwable);

        if ((errorList != null) && (errorList.size() > 1)) {
            ex = errorList.get(errorList.size() - 1).trim();
        } else {
            ex = throwable.getMessage().trim();
        }

        return ex;
    }
}
