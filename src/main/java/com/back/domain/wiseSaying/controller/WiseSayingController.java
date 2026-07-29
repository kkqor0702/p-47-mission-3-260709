package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.global.Rq;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.%n", wiseSaying.getId());
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findListDesc();

        wiseSayings
                .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                        wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));

    }

    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        boolean deleted = wiseSayingService.delete(id);

        // 삭제?id=" " 에서 숫자가 아닌 다른 값 넣으면 -1번 명언은 존재하지 않습니다에 대한 예외 처리
        if (id == -1) {
            System.out.println("잘못된 id 파라미터를 입력하였습니다.");
        }

        if (!deleted) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", id);
            return;
        }

        System.out.printf("%d번 명언이 삭제되었습니다.%n", id);
    }
}