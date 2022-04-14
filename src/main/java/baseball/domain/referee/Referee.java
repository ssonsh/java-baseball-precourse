package baseball.domain.referee;

import baseball.constant.GamePlayMessage;
import baseball.domain.BaseballNumbers;
import baseball.view.HintPrinter;


public class Referee {

    private Strike strike;
    private Ball ball;
    private HintPrinter hintPrinter;

    private JudgeStatus judgeStatus;

    private Referee() {
        this.strike = new Strike();
        this.ball = new Ball();
        this.hintPrinter = new HintPrinter(strike, ball);
        this.judgeStatus = JudgeStatus.IN_PLAY;
    }

    public static Referee create() {
        return new Referee();
    }

    public void judge(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        strike.judge(computerNumbers, playerNumbers);
        ball.judge(computerNumbers, playerNumbers);

        System.out.println(this.judgeResultMessage());
        if(this.isGameComplete()){
            System.out.println(GamePlayMessage.GAME_COMPLETE);
        }
        this.countClear();
    }

    private boolean isGameComplete() {
        boolean isStrike3 = this.strike.getCount() == 3 && this.ball.getCount() == 0;
        if(isStrike3){
            this.judgeStatus = JudgeStatus.GAME_OVER;
        }
        return isStrike3;
    }

    public String judgeResultMessage() {
        return this.hintPrinter.printResult();
    }

    public boolean isPlay() {
        return this.judgeStatus == JudgeStatus.IN_PLAY;
    }

    public void countClear() {
        this.strike.clear();
        this.ball.clear();
    }
}
