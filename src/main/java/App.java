import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    int lastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public App(Scanner sc) {
        this.sc = sc;
    } // 키보드 입력 뿐 아니라 조작한 문자열 입력도 받을 수 있음

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    lastId++;
                    WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.%n", lastId);
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    wiseSayings
                            .reversed()
                            .stream()
                            .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n", wiseSaying.getId(),
                                    wiseSaying.getAuthor(), wiseSaying.getContent()));
                }
                case "종료" -> {
                    return;
                }
            }
        }
    }
}
