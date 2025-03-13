package example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems;
    String category;

    //생성자
    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }
    //getter
    public String getCategory() {
        return category;
    }
    // Menu 객체에 포함된 MenuItem 객체들의 리스트를 반환하는 역할
    // 외부에서 menuItem을 접근할 수 있게 해줌
    public List<MenuItem> getMenuItem() {
        return menuItems;
    }

    //setter
    public void setMenuItem(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    //메뉴 항목 추가 메서드
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public String toString() {
        return category;
    }

}
