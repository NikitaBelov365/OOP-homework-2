import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Market implements IQueueBehaviour {

    private HashMap<String, Integer> data;

    public Market(HashMap<String, Integer> goods) {
        this.data = goods;
    }


    public void enterMarket(LinkedList<Integer> list) {
        System.out.println("Welcome customer! Choose your destiny");
        int a = list.getLast() + 1;
        list.add(a);
    }

    @Override
    public void leavingMarket(LinkedList<Integer> list) {
        list.remove(1);
        System.out.println("Goodbye");
    }

    @Override
    public void update(HashMap<String, Integer> market) {
        System.out.println(market);
    }

    @Override
    public void enteringQueue(LinkedList<Integer> list) {
        int a = list.getLast() + 1;
        list.add(a);
    }

    @Override
    public void leavingQueue(LinkedList<Integer> list) {
        list.remove(1);
        System.out.println("Thanks for your purchase");
    }

    @Override
    public String takeOrder(HashMap<String, Integer> market) {
        System.out.println("What do you want?");
        try (Scanner scan = new Scanner(System.in)) {
            String order = scan.nextLine();
            if (market.containsKey(order)) {
                return order;
            } else {
                return null;
            }
        }
    }

    @Override
    public void giveOrder(HashMap<String, Integer> market, String order) {
        if (order.equals("null")) {
            System.out.println("Sorry, we don't have your order");
        } else {
            System.out.println("How many items do you need?");
            try (Scanner scan = new Scanner(System.in)) {
                String input = scan.nextLine();
                int amm = Integer.parseInt(input);

                if (amm > market.get(order)) {
                    System.out.println("We don't have that many");
                } else {
                    int x = market.get(order) - amm;
                    market.replace(order, x);
                    System.out.println("Here you are!");
                }
            }
        }
    }
}


