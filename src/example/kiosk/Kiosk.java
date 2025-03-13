package example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
public class Kiosk {

    private List<Menu> categories; // 카테고리 목록
    private Scanner scanner = new Scanner(System.in);

    public Kiosk(List<Menu> categories) {
        this.categories = categories; //Main에서 받은 category 사용
    }
    //getter
    public List<Menu> getCategories() {
        return categories;
    }
    public void setCategories(List<Menu> categories) {
        this.categories = categories;
    }


    public void start(){
        while (true){
            System.out.println("[ MAIN MENU ]");
            for(int i=0; i< categories.size(); i++){
                System.out.println((i+1) + ". "+ categories.get(i));
            } System.out.println("0. 종료          | 종료");

            int choice; // 사용자에게 받은 입력을 저장할 변수


                System.out.print("카테고리 번호를 선택하세요: ");
                choice = getUserInput();  //사용자의 입력을 받음
                if (choice == 0) {
                    System.out.println("\n프로그램을 종료합니다.");
                    break;
                } else if (choice > 0 && choice <= categories.size()) {

                    System.out.println("[ " + categories.get(choice-1) + " ]");

                    //선택된 카테고리에 메뉴 항복 출력

                    List<MenuItem> menuItems = categories.get(choice -1).getMenuItem();
                    for(int i=0; i< menuItems.size(); i++){
                        System.out.println((i+1) + ". "+ menuItems.get(i));
                    }
                    System.out.println("0. 뒤로 가기");
                    System.out.println();
                    System.out.print("메뉴를 선택하세요: ");

                    int menuChoice = getUserInput();
                    if(menuChoice > 0 && menuChoice <= categories.size()){
                        System.out.println("[ " + menuItems.get(menuChoice-1) + " ]");
                    }


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


}
