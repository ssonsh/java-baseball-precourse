package baseball.constant;

public class ExceptionMessage {

    private ExceptionMessage(){
        throw new IllegalStateException("this is utility class");
    }

    public static final String INVALID_BASEBALL_NUMBER =
            String.format("%d ~ %d 사이의 숫자만 유효합니다.", BaseballNumberConstant.MIN, BaseballNumberConstant.MAX);
    public static final String INVALID_BASEBALL_NUMBER_SIZE = "유효하지 않은 숫자 길이입니다.";
    public static final String BASEBALL_NUMBER_IS_NOT_EMPTY = "숫자는 비어있을 수 없습니다.";

    public static final String INVALID_INPUT_BASEBALL_NUMBER = "1 ~ 9 사이 숫자로 구성된 서로다른 3개의 숫자만 입력 가능합니다.";
}
