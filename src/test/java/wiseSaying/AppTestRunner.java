package wiseSaying;

import com.back.App;
import com.back.global.AppContext;
import util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        AppContext.init(sc); // test에는 sc로 매개변수 줘서 테스트용으로
        new App().run();
        return outputStream.toString();
    }
}
