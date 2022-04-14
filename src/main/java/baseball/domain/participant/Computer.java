package baseball.domain.participant;

import baseball.domain.BaseballNumbers;
import baseball.generator.NumberGenerator;
import java.util.List;

public class Computer{

    private final BaseballNumbers baseballNumbers;

    private Computer(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static Computer generateBy(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate();
        return new Computer(BaseballNumbers.of(generateNumbers));
    }


    public BaseballNumbers getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
