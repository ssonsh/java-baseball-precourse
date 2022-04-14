package baseball.view;

import baseball.constant.JudgeResultMessage;
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
            return String.format(JudgeResultMessage.THREE_STRIKE);
        }

        if (strike.has() && ball.has()) {
            return String.format(JudgeResultMessage.STRIKE_WITH_BALL, ball.getCount(), strike.getCount());
        }

        if (!strike.has() && ball.has()) {
            return String.format(JudgeResultMessage.ONLY_BALL, ball.getCount());
        }

        if (strike.has() && !ball.has()) {
            return String.format(JudgeResultMessage.ONLY_STRIKE, strike.getCount());
        }

        return JudgeResultMessage.NOTHING;
    }
}
