package com.budget.budgetsavings.exceptions;

import com.budget.budgetsavings.auth.dto.User;
import org.springframework.http.HttpStatus;

public class BudgetException extends Exception {

    private final HttpStatus httpStatusCode;
    private final User userInfo;

    public BudgetException(HttpStatus httpStatusCode, User userInfo, Exception e) {
        super(makeMessage(httpStatusCode, userInfo), e);
        this.httpStatusCode = httpStatusCode;
        this.userInfo = userInfo;
    }

    private static String makeMessage(HttpStatus httpStatusCode, User userInfo) {
        return "{" +
                "httpStatusCode=" + httpStatusCode +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
