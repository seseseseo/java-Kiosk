package example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems;
    String category; 
    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }
    public String getCategory() {
        return category;
    }
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public String toString() {
        return category;
    }

    public List<MenuItem> getMenuItem() {
        return menuItems;
    }
}
