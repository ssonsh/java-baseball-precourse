package baseball.domain.referee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.constant.JudgeResultMessage;
import baseball.domain.BaseballNumbers;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("Referee 심판 객체로 Computer와 Player 판정 (713 <> 123)")
    void judgement01(){

        // given
        List<Integer> givenComputerNumbers = new ArrayList<>();
        givenComputerNumbers.add(7);
        givenComputerNumbers.add(1);
        givenComputerNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(2);
        givenPlayerNumbers.add(3);

        BaseballNumbers computerNumbers = BaseballNumbers.of(givenComputerNumbers);
        BaseballNumbers playerNumbers = BaseballNumbers.of(givenPlayerNumbers);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, playerNumbers);

        // then
        assertTrue(referee.isPlay());
        assertEquals(String.format(JudgeResultMessage.STRIKE_WITH_BALL, 1, 1), referee.judgeResultMessage());
    }


    @Test
    @DisplayName("Referee 심판 객체로 Computer와 Player 판정 (713 <> 145)")
    void judgement02(){

        // given
        List<Integer> givenComputerNumbers = new ArrayList<>();
        givenComputerNumbers.add(7);
        givenComputerNumbers.add(1);
        givenComputerNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(4);
        givenPlayerNumbers.add(5);

        BaseballNumbers computerNumbers = BaseballNumbers.of(givenComputerNumbers);
        BaseballNumbers playerNumbers = BaseballNumbers.of(givenPlayerNumbers);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, playerNumbers);

        // then
        assertTrue(referee.isPlay());
        assertEquals(String.format(JudgeResultMessage.ONLY_BALL, 1), referee.judgeResultMessage());
    }

    @Test
    @DisplayName("Referee 심판 객체로 Computer와 Player 판정 (713 <> 671)")
    void judgement03(){

        // given
        List<Integer> givenComputerNumbers = new ArrayList<>();
        givenComputerNumbers.add(7);
        givenComputerNumbers.add(1);
        givenComputerNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(6);
        givenPlayerNumbers.add(7);
        givenPlayerNumbers.add(1);

        BaseballNumbers computerNumbers = BaseballNumbers.of(givenComputerNumbers);
        BaseballNumbers playerNumbers = BaseballNumbers.of(givenPlayerNumbers);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, playerNumbers);

        // then
        assertTrue(referee.isPlay());
        assertEquals(String.format(JudgeResultMessage.ONLY_BALL, 2), referee.judgeResultMessage());
    }

    @Test
    @DisplayName("Referee 심판 객체로 Computer와 Player 판정 (713 <> 216)")
    void judgement04(){

        // given
        List<Integer> givenComputerNumbers = new ArrayList<>();
        givenComputerNumbers.add(7);
        givenComputerNumbers.add(1);
        givenComputerNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(2);
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(6);

        BaseballNumbers computerNumbers = BaseballNumbers.of(givenComputerNumbers);
        BaseballNumbers playerNumbers = BaseballNumbers.of(givenPlayerNumbers);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, playerNumbers);

        // then
        assertTrue(referee.isPlay());
        assertEquals(String.format(JudgeResultMessage.ONLY_STRIKE, 1), referee.judgeResultMessage());
    }


    @Test
    @DisplayName("Referee 심판 객체로 Computer와 Player 판정 (713 <> 713)")
    void judgement05(){

        // given
        List<Integer> givenComputerNumbers = new ArrayList<>();
        givenComputerNumbers.add(7);
        givenComputerNumbers.add(1);
        givenComputerNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(7);
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(3);

        BaseballNumbers computerNumbers = BaseballNumbers.of(givenComputerNumbers);
        BaseballNumbers playerNumbers = BaseballNumbers.of(givenPlayerNumbers);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, playerNumbers);

        // then
        assertFalse(referee.isPlay());
        assertEquals(String.format(JudgeResultMessage.THREE_STRIKE), referee.judgeResultMessage());
    }

}