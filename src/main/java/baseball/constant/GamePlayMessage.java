package baseball.constant;

public class GamePlayMessage {

    private GamePlayMessage() {
        throw new IllegalStateException("this is utility class");
    }

    public static final String INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String IS_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

}
