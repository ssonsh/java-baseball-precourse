package baseball.constant;

public class ExceptionMessage {

    public static final String INVALID_BASEBALL_NUMBER =
            String.format("%d ~ %d 사이의 숫자만 유효합니다.", BaseballNumberConstant.MIN, BaseballNumberConstant.MAX);
    public static final String INVALID_BASEBALL_NUMBER_SIZE = "유효하지 않은 숫자 길이입니다.";
    public static final String BASEBALL_NUMBER_IS_NOT_EMPTY = "숫자는 비어있을 수 없습니다.";
}
