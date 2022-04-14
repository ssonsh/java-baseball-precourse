package baseball.constant;

public class GamePlayMessage {

    private GamePlayMessage(){
        throw new IllegalStateException("this is utility class");
    }
    public static final String INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
}
