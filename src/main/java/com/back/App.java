package com.back;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    WiseSaying[] wiseSayings = new WiseSaying[10];
    int idx = 0;
    int lastRegisterNumber = 1;

    void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String order = sc.nextLine();

            if (order.equals("종료")) {
                break;
            } else if (order.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                wiseSayings[idx] = new WiseSaying();
                wiseSayings[idx].registerNumber = lastRegisterNumber;
                wiseSayings[idx].saying = saying;
                wiseSayings[idx].author = author;
                idx++;


                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastRegisterNumber++));
            } else if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = lastRegisterNumber - 2; i >= 0; i--) {
                    System.out.println("%d / %s / %s"
                            .formatted(wiseSayings[i].registerNumber, wiseSayings[i].author, wiseSayings[i].saying));
                }
            }
        }
    }
}
