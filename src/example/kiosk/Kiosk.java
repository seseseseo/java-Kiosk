package example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
public class Kiosk {
    private List<Menu> categories; // 카테고리 목록
    private Cart cartItem;
    private Scanner scanner;

    public Kiosk(List<Menu> categories) {
        this.categories = categories; //Main에서 받은 category 사용
        this.cartItem = new Cart(); // 장바구니 기능 추가
        scanner = new Scanner(System.in);
    }

    public List<Menu> getCategories() {
        return categories;
    }
    //setter
    public void setCategories(List<Menu> categories) {
        this.categories = categories;
    }
    
    public void start(){
        while (true){
            displayMainMenu();
            int categoryChoice = getUserInput();  //사용자의 입력을 받음

            if (categoryChoice == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            } else if (categoryChoice > 0 &&categoryChoice <= categories.size()) {
                displayCategory(categoryChoice);
            } else if (!cartItem.isEmpty() && categoryChoice == 4 ) {
                // 만약 장바구니에 물건을 담겨져있으면 장바구느 목록 출력
                processOrder();
            } else if(!cartItem.isEmpty() && categoryChoice == 5) {
                //5번을 누르게 된다면 진행중인 주문 취소
                cancelOrder();
            }  else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }


    // [ 메인메뉴 ] 1. 버거 2.음료 3.디저트
    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        // [ 메인메뉴 ]
        IntStream.range(0, categories.size())
                .forEach( i -> System.out.println((i+1) +". " + categories.get(i).toString()));
        //
        System.out.println("0. 종료 | 종료");
        // 장바구니가 비어져있지 않다면 다음 기능이 보이게
        if(!cartItem.isEmpty()){
            System.out.println("\n[ ORDER MENU ]");
            System.out.println(categories.size()+1 + ". "+ " Orders    | 장바구니 확인 후 주문합니다. ");
            System.out.println(categories.size() + 2 + ". "+ "Cancel     | 진행중인 주문을 취소합니다"    );
        }

    }
    // [메뉴아이템 1.쉑쉑버거 2.불고기버거 3.등등 ]
    private void displayCategory(int categoryChoice) {
        Menu selectedCategory = categories.get(categoryChoice -1);
        System.out.println("\n[ " + selectedCategory.getCategory() + " ]");
        var items = selectedCategory.getMenuItem();

        // [스트림]으로 메뉴아이템
        IntStream.range(0, items.size())
                .forEach(i -> System.out.println((i+1) + ". " + items.get(i)));

        //메뉴 선택 안내
        System.out.println("0. 뒤로 가기");
        //System.out.print("메뉴를 선택하세요: ");

        // 메뉴 입력 시
        int menuChoice = getUserInput();
        System.out.println();
        if(menuChoice == 0){
            return;
        }else if(menuChoice > 0 && menuChoice <= items.size()){
            addToCart(items.get(menuChoice-1));
        } else {
            System.out.println("올바른 번호를 입력해주세요.");
        }
    }

    // [장바구니에 아이템을 추가하는 메서드]
    private void addToCart(MenuItem item) {
        System.out.println("선택한 메뉴는 " + item.toString()+"\n");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? ");
        System.out.println("1. 확인      | 2.취소  ");
        int choice = getUserInput(); // 예외처리는 이 메서드에서 함
        if(choice == 1 ){
            cartItem.addItem(item);
        }else {
            System.out.println(" 메뉴 추가가 취소되었습니다.");
        }

    }
    // 장바구니 내역 보여줌
    private void processOrder() {
        if(cartItem.isEmpty()){
            System.out.println("장바구니가 비어있습니다. 먼저 메뉴를 추가해주세요.");
            return;
        }
        cartItem.displayCart();

        System.out.println("\n1. 주문            2. 메뉴판");
        int choice = getUserInput();

        if(choice == 1){
            Discount();
        }

    }
    // [할인 적용 후 결제]
    private void Discount() {
        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10% ");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");
        int discoutChoice = getUserInput();
        UserType userType;
        switch (discoutChoice) {
            case 1 -> userType = UserType.NATIONAL_PERSON;
            case 2 -> userType = UserType.SOLDIER;
            case 3 -> userType = UserType.STUDENT;
            case 4 -> userType = UserType.GENERAL;
            default -> {
                System.out.println(" 잘못된 입력입니다. 기본값(일반)으로 설정됩니다.");
                userType = UserType.GENERAL;
            }
        }

        double totalPrice = cartItem.getTotalPrice();
        double discount = totalPrice * userType.getDiscountRate();
        double finalPrice = totalPrice - discount;

        System.out.println("\n 주문이 완료되었습니다.");
        System.out.printf("원래 금액: W %.1f\n", totalPrice);
        System.out.printf("할인 금액: W %.1f (%.0f%% 할인)\n", discount, userType.getDiscountRate() * 100);
        System.out.printf("최종 결제 금액: W %.1f\n", finalPrice);

        cartItem.clearCart();
    }


    //5번 . 주문 취소 눌렀을 시
    private void cancelOrder() {
        cartItem.clearCart();
        System.out.println("주문을 취소합니다.");

    }


    //사용자 입력을 정수로 바꺼ㅜ줌
    private int getUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력하세요");
            return -1;
        }
    }



}
