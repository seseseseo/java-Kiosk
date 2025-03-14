package example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
public class Kiosk {
    private List<Menu> categories; // 카테고리 목록
    private List<MenuItem> cart; // 장바구니 역할을 하는 리스트
    private Scanner scanner;

    public Kiosk(List<Menu> categories) {
        this.categories = categories; //Main에서 받은 category 사용
        this.cart = new ArrayList<>();
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
            } else if (!cart.isEmpty() && categoryChoice == categories.size() + 1) {
                // 만약 장바구니에 물건을 담겨져있으면 장바구느 목록 출력
                showCart();
            } else if(!cart.isEmpty() && categoryChoice == categories.size() + 2) {
                //5번을 누르게 된다면 진행중인 주문 취소
                cancelOrder();
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
        int choice = getUserInput();
        Optional<Menu> selectedMenu = IntStream.range(0, categories.size())
                .filter(i -> i == ( choice - 1 )) // 1-based 입력값을 0-based 인덱스로 변환
                .mapToObj(categories::get)
                .findFirst();
        selectedMenu.ifPresentOrElse(
                menu -> {
                    displayCategory(choice);
                },
                () -> System.out.println("잘못된 입력입니다. 1부터 " + categories.size() + " 사이의 숫자를 입력하세요.")
        );

        // 장바구니가 비어져있지 않다면 다음 기능이 보이게
        if(!cart.isEmpty()){
            System.out.println("\n[ ORDER MENU ]");
            System.out.println(categories.size()+1 + ". "+ " Orders    | 장바구니 확인 후 주문합니다. ");
            System.out.println(categories.size() + 2 + ". "+ "Cancel     | 진행중인 주문을 취소합니다"    );
        }
        System.out.print("메뉴를 선택하세요: ");
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
        System.out.println();
        System.out.print("메뉴를 선택하세요: ");

        // 메뉴 입력 시
        int menuChoice = getUserInput();
        if(menuChoice > 0 && menuChoice <= items.size()){
            addToCart(items.get(menuChoice-1));
        }
    }
    // 장바구니에 아이템을 추가하는 메서드
    private void addToCart(MenuItem item) {
        System.out.println("\n선택한 메뉴는 " + item.toString()+"\n");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? ");
        System.out.println("1. 확인      | 2.취소  ");
        int choice = getUserInput(); // 예외처리는 이 메서드에서 함
        if(choice == 1 ){
            cart.add(item);
            System.out.println(item.getName() + "이 장바구니에 추가되었습니다.");
        }

    }

    // 장바구니 내역 보여줌
    private void showCart() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ Orders ]");
        //cart에 있는 모든 MenuItem 객체를 하나씩 꺼내서 menu 변수에 할당
//        for (MenuItem item : cart) {
//            System.out.println(item.toString());
//            totalPrice += item.getPrice();
//        }

        // [스트림]을 장바구니에 담긴 것 출력
        double totalPrice = cart.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.println("\n[ Total ]");
        System.out.println("W " +totalPrice);

        System.out.println("1. 주문            2. 메뉴판");
        int choice = getUserInput();

        if (choice == 1) {
            System.out.println("주문이 완료되었습니다. 주문 금액은 W "+totalPrice +"입니다.\n");
            cart.clear(); //주문 완료 됐으니 장바구니 비우기
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }

    }

    //5번 . 주문 취소 눌렀을 시
    private void cancelOrder() {
        System.out.println("주문을 취소합니다.");
        cart.clear();
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
