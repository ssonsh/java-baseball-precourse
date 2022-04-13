package baseball.domain.referee;

import baseball.constant.BaseballNumberConstant;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;

public class Strike {

    private int count;

    public Strike() {
        this.count = 0;
    }

    public void judge(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        for (int i = 0; i < BaseballNumberConstant.SIZE; i++) {
            BaseballNumber computerBaseballNumber = computerNumbers.getBallNumberByIdx(i);
            BaseballNumber playerBaseballNumber = playerNumbers.getBallNumberByIdx(i);
            strikeCheck(computerBaseballNumber.equals(playerBaseballNumber));
        }
    }

    private void strikeCheck(boolean isStrike) {
        if(isStrike){
            this.count ++;
        }
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
