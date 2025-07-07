package chapter07;

import java.util.Scanner;

public class Testorder {
    Scanner scan = new Scanner(System.in);
    String[] drinkNames = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
    int[] drinkPrices = {2800, 3500, 4000};
    TestDrinkOrder[] drinkMenuList = new TestDrinkOrder[3];  // 주문할 메뉴
    TestDrinkOrder[] orderItemList = new TestDrinkOrder[3];
    int orderCount = 0;
    int amount = 0;  
    int change = 0;  

   
    public void createDrinkMenu() {
        for(int i = 0; i < drinkNames.length; i++) {
            TestDrinkOrder menu = new TestDrinkOrder();
            menu.no = i + 1;
            menu.name = drinkNames[i];
            menu.price = drinkPrices[i];
            drinkMenuList[i] = menu;
        }
    }


    public void showDrinkMenu() {
        System.out.println("******************************************");
        for(TestDrinkOrder menu : drinkMenuList) {
            System.out.print(menu.no + ". ");
            System.out.print(menu.name + "\t");
            System.out.print(menu.price + "\n");
        }
        System.out.println("******************************************");
        selectDrinkMenu();
    }

    public void selectDrinkMenu() {
        System.out.print("주문메뉴(숫자)> ");

        if(scan.hasNextInt()) {
            drinkMenuCheck(scan.nextInt());
        } else {
            System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!");
            scan.next();
            selectDrinkMenu();
        }
    }

    public void drinkMenuCheck(int drinkMenu) {
        if(drinkMenu >= 1 && drinkMenu <= 3) {
            order(drinkMenu);
        } else {
            System.out.println("=> 메뉴 준비중~");
            showDrinkMenu();
        }
    }

    public void orderList() {
        if(orderCount == 0) {
            System.out.println(" => 주문내역 존재X, 음료를 주문해주세요");
            showMainMenu();
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("\t음료 주문 내역");
            System.out.println("-----------------------------------------");
            System.out.println("번호\t메뉴명\t가격\t수량");
            System.out.println("-----------------------------------------");
            for(TestDrinkOrder orderItem : orderItemList) {
                if(orderItem != null) {
                    System.out.print(orderItem.no + "\t");
                    System.out.print(orderItem.name + "\t");
                    System.out.print(orderItem.price + "\t");
                    System.out.print(orderItem.qty + "\n");
                }
            }
            System.out.println("-----------------------------------------");
            showMainMenu();
        }
    }

    public int searchOrderItemIdx(int drinkMenu) {
        int idx = -1;
        for(int i = 0; i < orderCount; i++) {
            if(orderItemList[i] != null && orderItemList[i].no == drinkMenu) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public void order(int drinkMenu) {
        System.out.println(drinkMenu + " 주문!!");
        for(TestDrinkOrder menu : drinkMenuList) {
            if(menu.no == drinkMenu) {
                int idx = searchOrderItemIdx(drinkMenu);
                if(idx == -1) {
                    TestDrinkOrder orderItem = new TestDrinkOrder();
                    orderItem.no = menu.no;
                    orderItem.name = menu.name;
                    orderItem.price = menu.price;
                    orderItem.qty = 1;
                    orderItemList[orderCount] = orderItem;
                    orderCount++;
                } else {
                    orderItemList[idx].qty += 1;
                }
                break;
            }
        }
        System.out.println("=> 주문 완료!!");
        showMainMenu();
    }

    public void orderItemListInit() {
        for(int i = 0; i < orderCount; i++) {
            orderItemList[i] = null;
        }
        orderCount = 0;
    }

    public int totalPayment() {
        int sum = 0;
        for(TestDrinkOrder orderItem : orderItemList) {
            if(orderItem != null) {
                sum += orderItem.price * orderItem.qty;
            }
        }
        return sum;
    }

    public void payment() {
        if(orderCount == 0) {
            System.out.println(" => 주문내역 존재X, 음료를 주문해주세요");
            showMainMenu();
        } else {
            int total = totalPayment();
            System.out.println("=> 결제 예정 금액 : " + total);
            System.out.print("결제할 금액 입력(숫자)> ");
            if(scan.hasNextInt()) {
                amount += scan.nextInt();
                System.out.println("=> 총 입력 금액 : " + amount);
                if(amount >= total) {
                    change = amount - total;
                    System.out.println("=> 결제 완료!! 잔돈 : " + change);
                    orderItemListInit();
                    amount = 0;
                    change = 0;
                } else {
                    System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요");
                    payment();
                    return;
                }
            } else {
                System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
                scan.next();
                payment();
                return;
            }
            showMainMenu();
        }
    }

    public void showMainMenu() {
        System.out.println("******************************************");
        System.out.println("\t Welcome to Drink Mart!!!");
        System.out.println("******************************************");
        System.out.println("\t 1. 음료 주문");
        System.out.println("\t 2. 주문 내역");
        System.out.println("\t 3. 결제");
        System.out.println("\t 9. 프로그램 종료");
        System.out.println("******************************************");
        selectMainMenu();
    }

    public void selectMainMenu() {
        System.out.print("메인메뉴(숫자)> ");
        if(scan.hasNextInt()) {
            int sel = scan.nextInt();
            mainMenuCheck(sel);
        } else {
            System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!");
            scan.next();
            selectMainMenu();
        }
    }

    public void mainMenuCheck(int mainMenu) {
        switch(mainMenu) {
            case 1: showDrinkMenu(); break;
            case 2: orderList(); break;
            case 3: payment(); break;
            case 9:
                System.out.println("=> 프로그램 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("=> 메뉴 준비중~");
                showMainMenu();
                break;
        }
    }
}
