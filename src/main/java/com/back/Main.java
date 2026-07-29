package com.back;

import com.back.global.AppContext;

public class Main {
    public static void main(String[] args) {
        AppContext.init(); // 실제 앱에서는 매개변수 없이 키보드로 입력받도록 (System.in)
        App app = new App();
        app.run();
    }
}
