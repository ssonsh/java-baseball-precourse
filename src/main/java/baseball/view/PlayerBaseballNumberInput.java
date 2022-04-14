package baseball.view;

import baseball.constant.BaseballNumberConstant;
import baseball.constant.ExceptionMessage;
import baseball.constant.GamePlayMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerBaseballNumberInput {

    public List<Integer> inputNumbers() {
        System.out.print(GamePlayMessage.INPUT_PLAYER_NUMBER);
        String inputNumber = Console.readLine();

        if (!isAvailableInputNumbers(inputNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_BASEBALL_NUMBER);
        }

        return convertStringNumberToListNumbers(inputNumber);
    }

    private List<Integer> convertStringNumberToListNumbers(String inputNumber) {
        List<String> strNumbers = Arrays.asList(inputNumber.split(""));
        List<Integer> numbers = new ArrayList<>();
        for (String strNumber : strNumbers) {
            numbers.add(Integer.parseInt(strNumber));
        }
        return numbers;
    }

    private boolean isAvailableInputNumbers(String inputNumber) {
        if (!isAvailableSize(inputNumber)) {
            return false;
        }

        if (!isUniqueInputNumbers(inputNumber)) {
            return false;
        }

        return isAvailableNumberRange(inputNumber);
    }

    private boolean isAvailableNumberRange(String inputNumber) {
        return inputNumber.matches(BaseballNumberConstant.INPUT_NUMBER_REG_EXP);
    }

    private boolean isUniqueInputNumbers(String inputNumber) {
        List<String> splitInputNumbers = Arrays.asList(inputNumber.split(""));
        Set<String> inputNumbersSet = new HashSet<>(splitInputNumbers);

        return inputNumbersSet.size() == BaseballNumberConstant.SIZE;
    }

    private boolean isAvailableSize(String inputNumber) {
        return inputNumber != null && inputNumber.length() == BaseballNumberConstant.SIZE;
    }
}
