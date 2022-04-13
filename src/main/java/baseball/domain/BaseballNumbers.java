package baseball.domain;

import baseball.constant.BaseballNumberConstant;
import baseball.constant.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateNumbers(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers of(List<Integer> numbers){
        List<BaseballNumber> results = new ArrayList<>();
        for (Integer number : numbers) {
            results.add(BaseballNumber.of(number));
        }

        return new BaseballNumbers(results);
    }

    public int size() {
        return this.baseballNumbers.size();
    }

    private void validateNumbers(List<BaseballNumber> baseballNumbers) {
        emptyValidate(baseballNumbers);
        availableSizeValidate(baseballNumbers);
    }

    private void availableSizeValidate(List<BaseballNumber> baseballNumbers) {
        if(baseballNumbers.size() != BaseballNumberConstant.SIZE){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BASEBALL_NUMBER_SIZE);
        }
    }

    private void emptyValidate(List<BaseballNumber> baseballNumbers) {
        if(baseballNumbers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.BASEBALL_NUMBER_IS_NOT_EMPTY);
        }
    }

    public BaseballNumber getBallNumberByIdx(int idx) {
        return this.baseballNumbers.get(idx);
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return this.baseballNumbers.contains(baseballNumber);
    }
}
