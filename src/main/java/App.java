import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    } // 키보드 입력 뿐 아니라 조작한 문자열 입력도 받을 수 있음

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                System.out.println("명언 : ");
                String content = sc.nextLine();
                System.out.println("작가 : ");
                String author = sc.nextLine();
            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
