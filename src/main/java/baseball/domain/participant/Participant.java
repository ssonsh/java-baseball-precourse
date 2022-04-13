package baseball.domain.participant;

import baseball.domain.BaseballNumbers;

public class Participant {

    private final BaseballNumbers baseballNumbers;

    public Participant(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public BaseballNumbers getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
