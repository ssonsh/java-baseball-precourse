package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.participant.Computer;
import baseball.domain.referee.Referee;
import baseball.generator.NumberGenerator;
import baseball.view.PlayerBaseballNumberInput;
import java.util.List;

public class BaseballGameController {

    private final PlayerBaseballNumberInput playerBaseballNumberInput;
    private final NumberGenerator numberGenerator;

    public BaseballGameController(PlayerBaseballNumberInput playerBaseballNumberInput,
                                  NumberGenerator numberGenerator) {
        this.playerBaseballNumberInput = playerBaseballNumberInput;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        Referee referee = Referee.create();
        Computer computer = Computer.generateBy(numberGenerator);

        while (referee.isPlay()) {
            List<Integer> playerInputNumbers = this.playerBaseballNumberInput.inputNumbers();
            BaseballNumbers playerBaseballNumbers = BaseballNumbers.of(playerInputNumbers);

            referee.judge(computer.getBaseballNumbers(), playerBaseballNumbers);

        }
    }
}
