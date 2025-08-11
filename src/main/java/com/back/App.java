package com.back;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    WiseSaying[] wiseSayings = new WiseSaying[10];
    int idx = 0;
    int lastRegisterNumber = 1;

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
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
            } else if (order.startsWith("삭제")) {
                int deleteId = Integer.parseInt(order.split("\\?")[1].split("=")[1]);
                boolean delete = false;

                for (int i = 0; i < lastRegisterNumber - 1; i++) {
                    if (wiseSayings[i].registerNumber == deleteId) {
                        delete = true;
                        System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
                        for (int j = deleteId - 1; j < lastRegisterNumber - 2; j++) {
                            wiseSayings[j] = wiseSayings[j + 1];
                        }
                        lastRegisterNumber--;
                        break;
                    }
                }

                if (delete == false) {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
                }


            } else if (order.startsWith("수정")) {
                int modifyId = Integer.parseInt(order
                        .split("\\?")[1]
                        .split("=")[1]);
                boolean modifyTF = false;

                for (int i = 0; i < lastRegisterNumber - 1; i++) {
                    if (wiseSayings[i].registerNumber == modifyId) {
                        modifyTF = true;
                        System.out.println("명언(기존) : %s".formatted(wiseSayings[i].saying));
                        System.out.print("명언 : ");
                        String newSaying = sc.nextLine();
                        wiseSayings[i].saying = newSaying;

                        System.out.println("작가(기존) : %s".formatted(wiseSayings[i].author));
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();
                        wiseSayings[i].author = newAuthor;

                    }
                }

                if (modifyTF == false) {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyId));
                }
            }
        }
    }
}
