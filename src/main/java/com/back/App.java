package com.back;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

    void run() {
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");

        String order = sc.nextLine();
        if (order.equals("종료")) {
            return;
        }
    }
}
