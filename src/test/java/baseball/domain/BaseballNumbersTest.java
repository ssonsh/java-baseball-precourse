package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.constant.BaseballNumberConstant;
import baseball.constant.ExceptionMessage;
import baseball.generator.BaseballNumberGenerator;
import baseball.generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    @DisplayName("BaseballNumber 1급객체 생성 (정상)")
    void generateBaseballNumbers(){
        // given
        // when
        NumberGenerator numberGenerator = new BaseballNumberGenerator();
        BaseballNumbers baseballNumbers = BaseballNumbers.of(numberGenerator.generate());

        // then
        assertEquals(BaseballNumberConstant.SIZE, baseballNumbers.size());
    }

    @Test
    @DisplayName("BaseballNumber 1급객체 생성 (비정상) - 숫자 사이즈 초과")
    void exceptionGenerateBaseballNumbers01(){
        // give
        // when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.of(numbers))
                .withMessageMatching(ExceptionMessage.INVALID_BASEBALL_NUMBER_SIZE);
    }

    @Test
    @DisplayName("BaseballNumber 1급객체 생성 (비정상) - 빈 List 기반으로 생성")
    void exceptionGenerateBaseballNumbers02(){
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.of(new ArrayList<>()))
                .withMessageMatching(ExceptionMessage.BASEBALL_NUMBER_IS_NOT_EMPTY);
    }
}