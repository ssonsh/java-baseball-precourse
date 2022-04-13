package baseball.domain;

import baseball.constant.BaseballNumberConstant;
import baseball.constant.ExceptionMessage;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
