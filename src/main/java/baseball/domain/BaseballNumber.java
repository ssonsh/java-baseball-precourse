package baseball.domain;

import baseball.constant.BaseballNumberConstant;
import baseball.constant.ExceptionMessage;

public class BaseballNumber {
    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber of(Integer number) {
        validateNumber(number);
        return new BaseballNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    private static void validateNumber(Integer number) {
        if (number < BaseballNumberConstant.MIN || number > BaseballNumberConstant.MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BASEBALL_NUMBER);
        }
    }
}
