package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("split() 문자열 분리 테스트")
    void split_메소드_결과_테스트_01() {
        // given
        String input = "1,2";

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split()의 결과인 배열반환 테스트")
    void split_메소드_결과_테스트_02() {
        // given
        String input = "1";

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).containsExactly("1");
    }


    @Test
    @DisplayName("substring() 메소드를 활용해 소괄호() 를 제거한다.")
    void substring_메소드로_소괄호_제거하기() {
        // given
        String input = "(1,2)";

        // when
        String substringInput = input.substring(1, input.length() - 1);

        // then
        assertThat(substringInput).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자 가져오기.")
    void charAt_메소드로_특정위치_문자_가져오기() {
        // given
        String input = "abc";

        // when
        // then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메소드로 특정위치 문자 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_메소드_StringIndexOutOfBoundsException_발생() {
        // given
        String input = "abc";

        // when
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()))
                .withMessageMatching("String index out of range: " + input.length());
    }
}