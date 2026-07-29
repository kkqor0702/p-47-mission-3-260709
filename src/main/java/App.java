import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController = new SystemController();

    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayingController = new WiseSayingController(sc);
    } // 키보드 입력 뿐 아니라 조작한 문자열 입력도 받을 수 있음

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController.actionList();
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}
