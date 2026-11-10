// console/MemberConsole.java
package console;

import service.MemberService;
import entity.Member;

import java.util.Scanner;

public class MemberConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final MemberService service;

    public MemberConsole(MemberService service) {
        this.service = service;
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("===== 회원 관리 =====");
            System.out.println("1. 등록");
            System.out.println("2. 목록");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");

            int menu = scanner.nextInt();
            scanner.nextLine();  // 남은 엔터 제거

            switch (menu) {
                case 1:
                    addMember();
                    break;
                case 2:
                    printMembers();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 0:
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    private void addMember() {
        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("전화번호: ");
        String phone = scanner.nextLine();
        // 서비스에 이름과 전화번호 넘겨서 저장해 달라고 요청
        boolean saved = service.addMember(name, phone);

        if (saved) {
            System.out.println("등록되었습니다.");
        } else {
            System.out.println("등록하지 못했습니다.");
        }
    }

    private void printMembers() {
        Member[] members = service.getMembers();

        if (members.length == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }

        System.out.println("===== 회원 목록 =====");
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i]);
        }
    }

    private void updateMember() {
        System.out.print("수정할 번호: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 남은 엔터 제거

        Member member = service.getMember(id);

        if (member == null) {
            System.out.println("없는 번호입니다.");
            return;
        }

        // 이름 수정
        String name = member.getName();
        System.out.println("이름: " + name);

        String nameAnswer;

        do {
            System.out.print("수정?(y/n) ");
            nameAnswer = scanner.nextLine();
        } while (!nameAnswer.equals("y") && !nameAnswer.equals("n"));

        if (nameAnswer.equals("y")) {
            System.out.print("새 이름: ");
            name = scanner.nextLine();
        }

        // 전화번호 수정
        String phone = member.getPhone();
        System.out.println("전화번호: " + phone);

        String phoneAnswer;

        do {
            System.out.print("수정?(y/n) ");
            phoneAnswer = scanner.nextLine();
        } while (!phoneAnswer.equals("y") && !phoneAnswer.equals("n"));

        if (phoneAnswer.equals("y")) {
            System.out.print("새 전화번호: ");
            phone = scanner.nextLine();
        }

        boolean updated = service.updateMember(id, name, phone);

        if (updated) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("수정하지 못했습니다.");
        }
    }

    private void deleteMember() {
        System.out.print("삭제할 번호: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 남은 엔터 제거

        boolean deleted = service.deleteMember(id);

        if (deleted) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("없는 번호입니다.");
        }
    }
}