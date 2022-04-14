package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @DisplayName("BaseballNumber 도메인 생성 테스트 (정상범위)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void generateBaseballNumber(int number) {
        // given
        // when
        BaseballNumber baseballNumber = BaseballNumber.of(number);

        // then
        assertEquals(number, baseballNumber.getNumber());
    }

    @DisplayName("BaseballNumber 도메인 생성 테스트 (비정상범위)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void IllegalArgumentExceptionGenerateBaseballNumber(int number) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumber.of(number))
                .withMessageMatching(ExceptionMessage.INVALID_BASEBALL_NUMBER);
    }
}