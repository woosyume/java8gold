package app;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        // Console class is 'private'. ⇨　new로 생성 불가
        System.err.println("아 이런 것도 있네."); // 표준에러출력 처리['']

        System.out.println("************************");

        BufferedReader br1 = null;
        try (BufferedReader br2 = new BufferedReader(new FileReader("src/sample.txt"))) {
            br2.lines().forEach(line -> System.out.println(line));
            br1 = br2; // Resource leak: 'br1' is never closedJava(536871799)   
        } 
        // try블록 종료 시 Stream은 이미 닫혀있기 때문에 'java.io.IOException: Stream closed' 발생.
        System.out.println(br1.ready());
    }
}