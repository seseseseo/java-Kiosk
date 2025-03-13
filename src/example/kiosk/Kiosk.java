package example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
public class Kiosk {
    private List<MenuItem> menuItems; // MenuItem을 관리하는 리스트가 필드로 존재합니다.
    private Scanner scanner;


    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        // 처음에 this.menuItems = new ArrayList<>(); 이렇게 자동완성되는대로
        // 작성해서 메뉴가 안떴었다.. 초기화를 해버린 것이다.

        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){

            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i< menuItems.size(); i++){
                System.out.println((i+1) + ". "+ menuItems.get(i));
            } System.out.println("0. 종료          | 종료");
            int choice;

            while(true){
                System.out.print("메뉴 번호를 선택하세요: ");
                choice = getUserInput();  //사용자의 입력을 받음
                if(choice != -1) {
                    System.out.println("올바른 번호를 입력해주세요.");
                    break;
                }
            }


            if (choice > 0 && choice <= menuItems.size()) {
                System.out.println("선택한 메뉴는: " + menuItems.get(choice-1));
                System.out.println();
            } else if (choice == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
        }

    }

    private int getUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {

            System.out.println("올바른 숫자를 입력하세요");
            return -1;
        }
    }
    public void addMenuItem(MenuItem menuItem) { //Kiosk 객체에 새로운 MenuItem을 추가하는 역할
        menuItems.add(menuItem); // 외부에서 직접 변경될 위험이 있어 메서드를 추가함

    }
}
