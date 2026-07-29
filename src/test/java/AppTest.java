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
}