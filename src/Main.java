import example.kiosk.Kiosk;
import example.kiosk.Menu;
import example.kiosk.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu burgerMenu = new Menu("Burgers Menu");
        burgerMenu.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // drinkMenu 객체 생성하면서 카테고리 이름 설정
        Menu drinkMenu = new Menu("Drink Menu");
        drinkMenu.addItem(new MenuItem("Coke", 2.5, "시원한 코카콜라"));
        drinkMenu.addItem(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));

        // dessertMenu 객체 생성하면서 카테고리 이;름 설정
        Menu dessertMenu
                = new Menu("Dessert Menu");
        dessertMenu.addItem(new MenuItem("Bread",4.0,"갓 구운 빵"));
        dessertMenu.addItem(new MenuItem("Sandwich",5.0,"따끈한 샌드위치"));

        // 카테고리 객체 생성
        List<Menu> categories = new ArrayList<>();
        categories.add(burgerMenu);
        categories.add(drinkMenu);
        categories.add(dessertMenu);

        //키오스크 객체 생성
        Kiosk kiosk = new Kiosk(categories);
        kiosk.start();


    }
}