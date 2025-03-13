import example.kiosk.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems; // 메뉴 아이템 리스트 1.쉑쉑버거 2. 가격 3. 설명
        Scanner scanner = new Scanner(System.in);
        int choice;


        //List 선언 후 메뉴 추가
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i< menuItems.size(); i++){
                System.out.println((i+1) + ". "+ menuItems.get(i).toString());
            }
            System.out.println("0. 종료          | 종료");
            System.out.print("메뉴 번호를 선택하세요: ");
            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }else if (choice > 0 && choice <= menuItems.size()) {
                System.out.println("선택한 메뉴는: " + menuItems.get(choice-1).toString());
                System.out.println();
            }
        }

        scanner.close();
    }
}