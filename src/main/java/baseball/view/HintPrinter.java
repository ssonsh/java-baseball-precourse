package baseball.view;

import baseball.constant.JudgementResultMessage;
import baseball.domain.referee.Ball;
import baseball.domain.referee.Strike;

public class HintPrinter {
    private final Strike strike;
    private final Ball ball;

    public HintPrinter(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String printResult() {
        if (strike.getCount() == 3 && ball.getCount() == 0) {
            return String.format(JudgementResultMessage.THREE_STRIKE);
        }

        if (strike.has() && ball.has()) {
            return String.format(JudgementResultMessage.STRIKE_WITH_BALL, ball.getCount(), strike.getCount());
        }

        if (!strike.has() && ball.has()) {
            return String.format(JudgementResultMessage.ONLY_BALL, ball.getCount());
        }

        if (strike.has() && !ball.has()) {
            return String.format(JudgementResultMessage.ONLY_STRIKE, strike.getCount());
        }

        return JudgementResultMessage.NOTHING;
    }
}
