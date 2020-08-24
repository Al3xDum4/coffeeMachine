package machine;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class CoffeeMachine {
    public static int waterStock = 400;
    public static int milkStock = 540;
    public static int beansCoffee = 120;
    public static int cupsStock = 9;
    public static int receipts = 550;

    public enum CoffeeAssortment {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int waterNeeds;
        int milkNeeds;
        int beansNeeds;
        int price;

        CoffeeAssortment(int waterNeeds, int milkNeeds, int beansNeeds, int price) {
            this.waterNeeds = waterNeeds;
            this.milkNeeds = milkNeeds;
            this.beansNeeds = beansNeeds;
            this.price = price;
        }
    }

    public void printStockStatus(BufferedReader br) throws IOException {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterStock + " of water");
        System.out.println(milkStock + " of milk");
        System.out.println(beansCoffee + " of coffee beans");
        System.out.println(cupsStock + " of disposable cups");
        System.out.println(receipts + " of money");
        System.out.println();
        mainMenu(br);
    }

    public void makeCoffee(BufferedReader br) throws IOException {
        String back = "back";
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String userCoffeeChoice = br.readLine();
        switch (userCoffeeChoice) {
            case "1":
                if (CoffeeAssortment.ESPRESSO.waterNeeds <= waterStock
                        && CoffeeAssortment.ESPRESSO.milkNeeds <= milkStock
                        && CoffeeAssortment.ESPRESSO.beansNeeds <= beansCoffee
                        && cupsStock > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    waterStock = waterStock - CoffeeAssortment.ESPRESSO.waterNeeds;
                    milkStock = milkStock - CoffeeAssortment.ESPRESSO.milkNeeds;
                    beansCoffee = beansCoffee - CoffeeAssortment.ESPRESSO.beansNeeds;
                    cupsStock = cupsStock - 1;
                    receipts = receipts + CoffeeAssortment.ESPRESSO.price;
                    mainMenu(br);
                } else if (CoffeeAssortment.ESPRESSO.waterNeeds > waterStock) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.ESPRESSO.milkNeeds > milkStock) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.ESPRESSO.beansNeeds > beansCoffee) {
                    System.out.println("Sorry, not enough beans!");
                    System.out.println();
                    mainMenu(br);
                } else {
                    System.out.println("Sorry, not enough cups!");
                    System.out.println();
                    mainMenu(br);
                }
                break;
            case "2":
                if (CoffeeAssortment.LATTE.waterNeeds <= waterStock
                        && CoffeeAssortment.LATTE.milkNeeds <= milkStock
                        && CoffeeAssortment.LATTE.beansNeeds <= beansCoffee
                        && cupsStock > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    waterStock = waterStock - CoffeeAssortment.LATTE.waterNeeds;
                    milkStock = milkStock - CoffeeAssortment.LATTE.milkNeeds;
                    beansCoffee = beansCoffee - CoffeeAssortment.LATTE.beansNeeds;
                    cupsStock = cupsStock - 1;
                    receipts = receipts + CoffeeAssortment.LATTE.price;
                    mainMenu(br);
                } else if (CoffeeAssortment.LATTE.waterNeeds > waterStock) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.LATTE.milkNeeds > milkStock) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.LATTE.beansNeeds > beansCoffee) {
                    System.out.println("Sorry, not enough beans!");
                    System.out.println();
                    mainMenu(br);
                } else {
                    System.out.println("Sorry, not enough cups!");
                    System.out.println();
                    mainMenu(br);
                }
                break;
            case "3":
                if (CoffeeAssortment.CAPPUCCINO.waterNeeds <= waterStock
                        && CoffeeAssortment.CAPPUCCINO.milkNeeds <= milkStock
                        && CoffeeAssortment.CAPPUCCINO.beansNeeds <= beansCoffee
                        && cupsStock > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    waterStock = waterStock - CoffeeAssortment.CAPPUCCINO.waterNeeds;
                    milkStock = milkStock - CoffeeAssortment.CAPPUCCINO.milkNeeds;
                    beansCoffee = beansCoffee - CoffeeAssortment.CAPPUCCINO.beansNeeds;
                    cupsStock = cupsStock - 1;
                    receipts = receipts + CoffeeAssortment.CAPPUCCINO.price;
                    mainMenu(br);
                } else if (CoffeeAssortment.CAPPUCCINO.waterNeeds > waterStock) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.CAPPUCCINO.milkNeeds > milkStock) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                    mainMenu(br);
                } else if (CoffeeAssortment.CAPPUCCINO.beansNeeds > beansCoffee) {
                    System.out.println("Sorry, not enough beans!");
                    System.out.println();
                    mainMenu(br);
                } else {
                    System.out.println("Sorry, not enough cups!");
                    System.out.println();
                    mainMenu(br);
                }
                break;
            case "back":
                mainMenu(br);
                break;
            default:
                System.out.println("tap option between 1 - 3");
                mainMenu(br);
        }
    }

    public void fillStock(BufferedReader br) throws IOException {
        System.out.println("Write how many ml of water do you want to add: ");
        int userWaterFill = Integer.parseInt(br.readLine());
        waterStock = waterStock + userWaterFill;

        System.out.println("Write how many ml of milk do you want to add: ");
        int userMilkFill = Integer.parseInt(br.readLine());
        milkStock = milkStock + userMilkFill;

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int userBeansFill = Integer.parseInt(br.readLine());
        beansCoffee = beansCoffee + userBeansFill;

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int userCupsFill = Integer.parseInt(br.readLine());
        cupsStock = cupsStock + userCupsFill;

        mainMenu(br);

    }

    public void takeMoney(BufferedReader br) throws IOException {
        System.out.println("I gave you $ " + receipts);
        receipts = 0;
        mainMenu(br);
    }

    public void mainMenu(BufferedReader br) throws IOException {

        String menu = "";

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            menu = br.readLine();
            switch (menu) {
                case "buy":
                    this.makeCoffee(br);
                    break;
                case "fill":
                    this.fillStock(br);
                    break;
                case "take":
                    this.takeMoney(br);
                    break;
                case "remaining":
                    this.printStockStatus(br);
                    break;
                default:
                    System.out.println("!Choose from menu!");
                    System.out.println();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }while (true);
    }

    /*
     *method for back level
     */

//    int water = 200;
//    int milk = 50;
//    int beans = 15;

//    public void makeCoffee(Scanner sc) {
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int waterResources = sc.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        int milkResources = sc.nextInt();
//
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int beansResources = sc.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need: ");
//        int a = sc.nextInt();
//
//        int[] arr = new int[3];
//        arr[0] = waterResources / water;
//        arr[1] = milkResources / milk;
//        arr[2] = beansResources / beans;
//
//        Arrays.sort(arr);
//        int min = arr[0];
//
//        if (min == a) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (min < a && min != 0) {
//            System.out.println("No, I can make only " + (min) + " cup(s) of coffee");
//        } else if (min > a) {
//            System.out.println("Yes, I can make that amount of coffee (and even " + (min - a) + " more than that)");
//        } else if (min == 0 && a != 0) {
//            System.out.println("No, I can make only 0 cup(s) of coffee");
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.mainMenu(br);

    }
}
