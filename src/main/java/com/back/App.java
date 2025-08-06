package com.back;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

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

                WiseSaying wiseSaying = new WiseSaying();
                wiseSaying.saying = saying;
                wiseSaying.author = author;
            }
        }
    }
}
