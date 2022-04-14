package baseball;


import baseball.controller.BaseballGameController;
import baseball.generator.BaseballNumberGenerator;
import baseball.view.PlayerBaseballNumberInput;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(
                new PlayerBaseballNumberInput(),
                new BaseballNumberGenerator()
        );
        baseballGameController.play();
    }
}
