import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("== 명언 앱 == 출력")
    void t1() {
//        Scanner sc = TestUtil.genScanner("종료");
//
//        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
//        new App(sc).run();
//        String out = outputStream.toString();

        String out = AppTestRunner.run("");

        assertThat(out).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("등록")
    void t2() {
        String out = AppTestRunner.run("""
                등록
                aaaa
                bbbb
                """);

        assertThat(out).contains("명령) ");
        assertThat(out).contains("명언 : ");
        assertThat(out).contains("작가 : ");
    }

    @Test
    @DisplayName("등록 후 명언 번호 출력")
    void t3() {

        String out = AppTestRunner.run("""
                등록
                aaaa
                bbbb
                """);

        assertThat(out).contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록 마다 명언 번호 증가")
    void t4() {

        String out = AppTestRunner.run("""
                등록
                너 자신을 알라
                소크라테스
                등록
                죽음을 적에게 알리지 마라
                이순신
                """);

        assertThat(out).contains("2번 명언이 등록되었습니다.");
    }
}