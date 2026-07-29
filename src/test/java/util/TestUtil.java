package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {
    private static PrintStream ORIGINAL_OUT = System.out;
    private static PrintStream CURRENT_OUT = System.out;

    public static Scanner genScanner(String input) {
        return new Scanner(input.trim().stripIndent());
    }

    public static ByteArrayOutputStream setOutToByteArray() {

        ORIGINAL_OUT = System.out; // 원래 출력을 변수에 저장
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 출력 바이트 스트림 만듦
        PrintStream printStream = new PrintStream(outputStream);
        // 문자열 쉽게 출력하도록 바이트를 감싸는 PrintStream 생성
        // 프로그램 -> printstream (보조스트림) -> ByteStream(outputstream)
        System.setOut(printStream);
        // 자바의 기본 출력 장치를 모니터가 아니라, 방금 만든 메모리 통로(printstream) 으로 나오도록

        CURRENT_OUT = printStream;
        // 나중에 닫기 위해서 현재 통로 저장

        return outputStream;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream outputStream) throws IOException {
        System.setOut(ORIGINAL_OUT);
        // 원래로 출력 되돌리기
        outputStream.close();
        CURRENT_OUT.close();
    }
}