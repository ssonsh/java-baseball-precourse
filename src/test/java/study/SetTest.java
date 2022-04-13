package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 활용해 numbers 사이즈를 확인한다.")
    void size_메소드() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contain() 메소드를 이용해 numbers에 값들이 존재하는지 테스트 한다.")
    void contains_메소드() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contain() 메소드를 이용해 numbers에 값들이 존재하는지 테스트 한다. (ParameterizedTest : ValueSource)")
    @ValueSource(ints = {1, 2, 3})
    void contains_메소드_parameterizedTest_ValueSource(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contain() 메소드를 이용해 numbers에 값들이 존재하는지 테스트 한다. (ParameterizedTest : CsvSource)")
    @CsvSource(
            value = {
                    "1:true",
                    "2:true",
                    "3:true",
                    "4:false",
                    "5:false"
            },
            delimiter = ':'
    )
    void contains_메소드_parameterizedTest_CsvSource(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
