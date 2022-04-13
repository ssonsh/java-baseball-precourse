package baseball.generator;

import baseball.constant.BaseballNumberConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < BaseballNumberConstant.SIZE) {
            numbers.add(Randoms.pickNumberInRange(BaseballNumberConstant.MIN, BaseballNumberConstant.MAX));
        }
        return new ArrayList<>(numbers);
    }
}
