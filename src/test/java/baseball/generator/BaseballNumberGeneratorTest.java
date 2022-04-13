package baseball.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자는 3자리여야 한다.")
    void generate01() {
        // given
        NumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        // when
        // then
        assertEquals(3, numbers.size(), "생성된 numbers의 사이즈는 3이어야 한다.");
        assertNotEquals(2, numbers.size(), "생성된 numbers의 사이즈는 3이어야 한다.");
    }

    @Test
    @DisplayName("생성된 3자리 숫자는 서로 중복이 없다.")
    void generate02() {
        // given
        NumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        // when
        Set<Integer> numberSet = new HashSet<>(numbers);

        // then
        assertEquals(numbers.size(),
                numberSet.size(),
                "List 컬랙션의 사이즈와 Set 컬랙션의 사이즈가 같아야 한다. (= 중복이 없다)");

        assertEquals(3, numbers.size(), "생성된 (List) numbers의 사이즈는 3이어야 한다.");
        assertEquals(3, numberSet.size(), "Set 컬랙션으로 변환한 numbers의 사이즈는 3이어야 한다.");

    }
}