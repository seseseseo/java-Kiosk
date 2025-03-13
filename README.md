# 🍔 Java Kiosk System
<p align="center">
  <img src="https://www.urbanbrush.net/web/wp-content/uploads/edd/2022/10/urbanbrush-20221019132138346764.jpg" alt="Logo" width="300" height="300">
</p>

## 📌 프로젝트 소개

자바 기반의 키오스크 프로그램으로, 사용자가 **음식을 주문하고 장바구니에 추가할 수 있는 기능**을 제공합니다.  
사용자는 **메뉴를 선택하고, 장바구니에 담고, 최종 주문을 확정**할 수 있습니다.

---

## 🚀 주요 기능
1. **메뉴 선택** - Burgers, Drinks, Desserts 카테고리에서 원하는 메뉴를 선택할 수 있습니다.  
2. **장바구니 기능** - 선택한 메뉴를 장바구니에 담을 수 있습니다.  
3. **주문 확인** - 장바구니에 담긴 상품을 확인하고 주문할 수 있습니다.  
4. **주문 취소** - 진행 중인 주문을 취소할 수 있습니다.  
5. **예외 처리** - 잘못된 입력(숫자가 아닌 값 등)에 대한 예외 처리가 포함되어 있습니다.  

---

## 🛠 프로젝트 구조
```
📂 java-kiosk
 ┣ 📂 src/example/kiosk
 ┃ ┣ 📜 Main.java          # 프로그램 실행 메인 클래스
 ┃ ┣ 📜 Kiosk.java         # 키오스크 핵심 로직 (메뉴 선택, 주문, 장바구니 관리)
 ┃ ┣ 📜 Menu.java          # 카테고리별 메뉴 관리 클래스
 ┃ ┣ 📜 MenuItem.java      # 개별 메뉴 아이템 클래스
 ┣ 📜 README.md            # 프로젝트 설명 문서
 ┗ 📜 .gitignore           # Git 관리에서 제외할 파일 목록

```

## 🏗 개발 환경
- 언어: Java 11+
- 빌드 도구: 없음 (단순 Java 프로젝트)
- 실행 환경: 터미널 또는 IntelliJ, Eclipse 등의 IDE

---
  
## 🎮 실행 예시
```
[ MAIN MENU ]
1. Burgers Menu
2. Drink Menu
3. Dessert Menu
0. 종료          | 종료
메뉴를 선택하세요: 1

[ Burgers Menu ]
1. ShackBurger     | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack      | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger    | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger       | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로 가기

메뉴를 선택하세요: 2

선택한 메뉴는 SmokeShack      | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

위 메뉴를 장바구니에 추가하시겠습니까? 
1. 확인      | 2.취소  
1
SmokeShack이 장바구니에 추가되었습니다.
[ MAIN MENU ]
1. Burgers Menu
2. Drink Menu
3. Dessert Menu
0. 종료          | 종료

[ ORDER MENU ]
4.  Orders    | 장바구니 확인 후 주문합니다. 
5. Cancel     | 진행중인 주문을 취소합니다
메뉴를 선택하세요: 3

[ Dessert Menu ]
1. Bread           | W 4.0 | 갓 구운 빵
2. Sandwich        | W 5.0 | 따끈한 샌드위치
0. 뒤로 가기

메뉴를 선택하세요: 2

선택한 메뉴는 Sandwich        | W 5.0 | 따끈한 샌드위치

위 메뉴를 장바구니에 추가하시겠습니까? 
1. 확인      | 2.취소  
1
Sandwich이 장바구니에 추가되었습니다.
[ MAIN MENU ]
1. Burgers Menu
2. Drink Menu
3. Dessert Menu
0. 종료          | 종료

[ ORDER MENU ]
4.  Orders    | 장바구니 확인 후 주문합니다. 
5. Cancel     | 진행중인 주문을 취소합니다
메뉴를 선택하세요: 4

아래와 같이 주문 하시겠습니까?

[ Orders ]
SmokeShack      | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
Sandwich        | W 5.0 | 따끈한 샌드위치

[ Total ]
W 13.9
1. 주문            2. 메뉴판
1
주문이 완료되었습니다. 주문 금액은 W 13.9입니다.
```
