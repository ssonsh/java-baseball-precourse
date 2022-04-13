package baseball.domain.referee;

import baseball.constant.BaseballNumberConstant;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;

public class Ball {

    private int count;

    public Ball() {
        this.count = 0;
    }

    public void judge(BaseballNumbers computerBaseballNumbers, BaseballNumbers playerBaseballNumbers) {
        for (int i = 0; i < BaseballNumberConstant.SIZE; i++) {
            BaseballNumber computerBaseballNumber = computerBaseballNumbers.getBallNumberByIdx(i);
            BaseballNumber playerBaseballNumber = playerBaseballNumbers.getBallNumberByIdx(i);

            ballCheck(ballCondition(computerBaseballNumbers, computerBaseballNumber, playerBaseballNumber));
        }
    }

    private void ballCheck(boolean isBall) {
        if (isBall) {
            this.count++;
        }
    }

    private boolean ballCondition(BaseballNumbers computerBaseballNumbers, BaseballNumber computerBaseballNumber,
                                  BaseballNumber playerBaseballNumber) {

        return computerBaseballNumbers.contains(playerBaseballNumber) &&
                !computerBaseballNumber.equals(playerBaseballNumber);
    }

    public int getCount() {
        return this.count;
    }

    public void clear() {
        this.count = 0;
    }

    public boolean has() {
        return this.count > 0;
    }
}
