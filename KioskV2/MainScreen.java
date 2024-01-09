package KioskV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainScreen {

    List<Product> burger = new ArrayList<>();
    List<Product> frozenCustards = new ArrayList<>();
    List<Product> drinks = new ArrayList<>();
    List<Product> beer = new ArrayList<>();

    private Cart cart = new Cart();

    private Scanner sc = new Scanner(System.in);


    public void ShowMainScreen() {

        Product ShackBurger = new Product("ShackBurger", "토마토 양상,쉑소스 토핑된 치즈버거", 6900);
        Product SmokeShack = new Product("SmokeShack", "애플 우드 칩으로 훈연한 베이컨, 매콤한 체리 페에 쉑소스가 토핑된 치즈버거", 8900);
        Product ShroomBuger = new Product(" ShroomBuger", "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 튀겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리언 버거", 9400);

        burger.add(ShackBurger);
        burger.add(SmokeShack);
        burger.add(ShroomBuger);

        Product Shakes = new Product("Shakes", "바닐라 초콜릿,솔티드 카라멜, 블랙&화이트,스트로베리,피넛버터, 커피", 5900);
        Product ShakeOftheWeek = new Product("ShakeOftheWeek", "특별한 커스터드 플레이버", 6500);
        Product RedBeanShake = new Product("RedBeanShake", "신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시그널 쉐이크", 6500);
        frozenCustards.add(Shakes);
        frozenCustards.add(ShakeOftheWeek);
        frozenCustards.add(RedBeanShake);

        Product FiftyFifty = new Product("FiftyFifty", "레모네이드와 아이스티의 만남", 3500);
        Product AbitaRootBeer = new Product("AbitaRootBeer", "청량감있는 독특한 미국식 무알콜 탄산음료", 3300);
        Product BottledWater = new Product("BottledWater", "지리산 암반대수층으로 만든 프리미엄 생수", 1000);
        drinks.add(FiftyFifty);
        drinks.add(AbitaRootBeer);
        drinks.add(BottledWater);

        Product ShackMeisterAle = new Product("ShackMeisterAle", "뉴욕 브루클린 브루어리에서 특별히 제조한 맥주", 9800);
        Product MagpieBrewingCo = new Product("MagpieBrewingCo", "드래프트 페일 에일", 6800);
        beer.add(ShackMeisterAle);
        beer.add(ShackMeisterAle);


        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
                "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "\n" +
                "[ SHAKESHACK MENU ]\n" +
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                "2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                "3. kiosk.Drinks    | 매장에서 직접 만드는 음료\n" +
                "4. kiosk.Beer      | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                "\n" +
                "[ ORDER MENU ]\n" +
                "5. kiosk.Order     | 장바구니를 확인 후 주문합니다.\n" +
                "6. Cancel          | 진행중인 주문을 취소합니다.");
        System.out.println("선택: ");

        int select = sc.nextInt();

        switch (select) {
            case 1:
                ShowBurgerMenu();
            case 2:
                ShowFrozen();
            case 3:
                ShowDrinkMenu();
            case 4:
                ShowBeerMenu();
            case 5:
                ShowCart();
            case 6:
                CancelOrder();


        }


    }


    public void ShowBurgerMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
                "\n" +
                "[ Burgers MENU ]\n" +
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        System.out.println("선택 : ");

        int selectBurger = sc.nextInt();
        int burgerNumber = selectBurger-1;
        Product choiseBurger = burger.get(burgerNumber);
        System.out.println("\"" + choiseBurger.getName() + "|" + choiseBurger.getDescription() + "| " + "w" + (choiseBurger.getPrice()/1000) + "\"\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소");

        int select1 = sc.nextInt();
        while (true) {
            if (select1 == 1) {
                cart.addOrder(choiseBurger);
                System.out.println(choiseBurger.getName() + "가 카트에 추가되었습니다.");
                break;
            } else if (select1 == 2) {
                System.out.println("주문이 취소되었습니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        ShowMainScreen();
    }

    public void ShowFrozen() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
                "\n" +
                "[ FrozenCustard MENU ]\n" +
                "1. Shakes   | W 5.9 | 바닐라 초콜릿,솔티드 카라멜, 블랙&화이트,스트로베리,피넛버터, 커피\n" +
                "2. ShakeOftheWeek    | W 6.5 | 특별한 커스터드 플레이버\n" +
                "3. RedBeanShake | W 6.5 | 신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시그널 쉐이크");
        System.out.println("선택 : ");

        int selectFrozen = sc.nextInt();
        Product choiseFrozen = frozenCustards.get(selectFrozen - 1);
        System.out.println("\"" + choiseFrozen.getName() + "|" + choiseFrozen.getDescription() + "| " + "w" + choiseFrozen.getPrice() / 1000 + "\"\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소");

        int select2 = sc.nextInt();
        while (true) {
            if (select2 == 1) {
                cart.addOrder(choiseFrozen);
                System.out.println(choiseFrozen.getName() + "가 카트에 추가되었습니다.");
                break;
            } else if (select2 == 2) {
                System.out.println("주문이 취소되었습니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        ShowMainScreen();
    }

    public void ShowDrinkMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
                "\n" +
                "[ Drink MENU ]\n" +
                "1. FiftyFifty  | W 3.5 | 레모네이드와 아이스티의 만남\n" +
                "2. AbitaRootBeer   | W 3.3 | 청량감있는 독특한 미국식 무알콜 탄산음료\n" +
                "3. BottledWater | W 1.0 | 지리산 암반대수층으로 만든 프리미엄 생수");
        System.out.println("선택 : ");

        int selectDrink = sc.nextInt();
        Product choiseDrink = drinks.get(selectDrink - 1);
        System.out.println("\"" + choiseDrink.getName() + "|" + choiseDrink.getDescription() + "| " + "w" + choiseDrink.getPrice() / 1000 + "\"\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소");

        int select3 = sc.nextInt();
        while (true) {
            if (select3 == 1) {
                cart.addOrder(choiseDrink);
                System.out.println(choiseDrink.getName() + "가 카트에 추가되었습니다.");
                break;
            } else if (select3 == 2) {
                System.out.println("주문이 취소되었습니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        ShowMainScreen();
    }

    public void ShowBeerMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
                "\n" +
                "[ Beer MENU ]\n" +
                "1. ShackMeisterAle   | W 9.8 | 뉴욕 브루클린 브루어리에서 특별히 제조한 맥주\n" +
                "2. MagpieBrewingCo    | W 6.8 | 드래프트 페일 에일");
        System.out.println("선택 : ");

        int selectBeer = sc.nextInt();
        Product choiseBeer = beer.get(selectBeer - 1);
        System.out.println("\"" + choiseBeer.getName() + "|" + choiseBeer.getDescription() + "| " + "w" + choiseBeer.getPrice() / 1000 + "\"\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소");

        int selectA = sc.nextInt();
        while (true) {
            if (selectA == 1) {
                cart.addOrder(choiseBeer);
                System.out.println(choiseBeer.getName() + "가 카트에 추가되었습니다.");
                break;
            } else if (selectA == 2) {
                System.out.println("주문이 취소되었습니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        ShowMainScreen();
    }

    public void ShowCart() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[Orders]");
        List<Product> orderList = cart.getOrderList();
        for (Product order : orderList) {
            System.out.println(order.getName() + "  |   " + "w" + order.getPrice() / 1000 + "   |   " + order.getDescription());

        }
        System.out.println("[ Total ]");
        System.out.println("w " + (cart.calculateTotalPrice() / 1000) + "\n");
        System.out.println("1. 주문" + "2. 메뉴판");
        int SelcetC = sc.nextInt();

        while (true) {
            if (SelcetC == 1) {
                FnalOrder();
                break;
            } else if (SelcetC == 2) {
                System.out.println("메인 메뉴로 돌아갑니다");
                ShowMainScreen();

                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }

    }

    public void FnalOrder() {
        List<Product> orderList = cart.getOrderList();
        if (orderList.isEmpty()) {
            System.out.println("먼저 장바구니에 물건을 담아주십시오");
            ShowMainScreen();
        } else {
            System.out.println("주문이 완료되었습니다.");
            System.out.println("주문번호는 " + cart.getOrderNumber() + "입니다");
            System.out.println("3초 후 메인화면으로 돌아갑니다");
            cart.setOderNumber(cart.getOrderNumber() + 1);
            cart.clear();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            ShowMainScreen();
        }

    }

    public void CancelOrder() {
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1.확인    2.취소 ");
        int orderCancel = sc.nextInt();
        while (true) {
            if (orderCancel == 1) {
                System.out.println("진행하던 주문을 취소합니다");
                cart.clear();
                break;
            } else if (orderCancel == 2) {
                System.out.println("게속 주문하기 위해 메인화면으로 돌아갑니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        ShowMainScreen();
    }


}