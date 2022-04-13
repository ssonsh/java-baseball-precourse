package baseball.domain.referee;

import baseball.domain.BaseballNumbers;
import baseball.view.HintPrinter;


public class Referee {

    private Strike strike;
    private Ball ball;
    private HintPrinter hintPrinter;

    private Referee() {
        this.strike = new Strike();
        this.ball = new Ball();
        this.hintPrinter = new HintPrinter(strike, ball);
    }

    public static Referee create() {
        return new Referee();
    }

    public void judge(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        strike.judge(computerNumbers, playerNumbers);
        ball.judge(computerNumbers, playerNumbers);
    }

    private boolean isGameComplete() {
        return this.strike.getCount() == 3 && this.ball.getCount() == 0;
    }

    public String judgeResultMessage() {
        return this.hintPrinter.printResult();
    }

    public boolean isPlay() {
        return !isGameComplete();
    }
}
