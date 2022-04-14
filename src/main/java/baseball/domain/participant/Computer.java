package baseball.domain.participant;

import baseball.domain.BaseballNumbers;
import baseball.generator.NumberGenerator;
import java.util.List;

public class Computer extends Participant{
    private Computer(BaseballNumbers baseballNumbers) {
        super(baseballNumbers);
    }

    public static Computer generateBy(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate();
        return new Computer(BaseballNumbers.of(generateNumbers));
    }
}
