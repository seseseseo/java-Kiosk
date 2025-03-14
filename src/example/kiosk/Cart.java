package example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> cartItem;

    public Cart() {
        cartItem = new ArrayList<MenuItem>();
    }
    //장바구니에 메뉴 추가
    public void addItem(MenuItem item) {
        cartItem.add(item);
        System.out.println(item.getName() + " 이(가) 장바구니에 추가되었습니다.\n");
    }
    //장바구니 담긴 내용 출력
    public void displayCart() {
        if(cartItem.isEmpty()){
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        System.out.println("\n[ 🛒 장바구니 ]");
        double totalPrice = cartItem.stream().mapToDouble(MenuItem::getPrice).sum();
        for(MenuItem item : cartItem){
            System.out.println(item.toString());
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " +totalPrice);
    }
    //총 금액 계산
    public double getTotalPrice() {
        double totalPrice = cartItem.stream().mapToDouble(MenuItem::getPrice).sum();
        return totalPrice;
    }
    //장바구니 초기화(주문 완료시)
    public void clearCart() {
        cartItem.clear();
        System.out.println("주문이 확인되었습니다. 장바구니를 초기화합니다.\n");
    }
    public boolean isEmpty() {
        return cartItem.isEmpty();
    }

    //음?
}
