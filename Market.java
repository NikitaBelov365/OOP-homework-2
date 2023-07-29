import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Market implements IMarketBehavior, IQueueBehaviour {


    public void enterMarket(LinkedList<Integer> list) {
        System.out.println("Welcome customer! Choose your destiny");
        int a = list.getLast()+1;
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
        int a = list.getLast()+1;
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
        Scanner scan = new Scanner(System.in);
        String order = scan.nextLine();
        if (market.containsKey(order)) {
            return order;
        } else {
            return "null";
        }
    }

    @Override
    public void giveOrder(HashMap<String, Integer> market, String order) {
        if (order.equals("null")) {
            System.out.println("Sorry, we don't have your order");
        } else {
            System.out.println("How many items do you need?");
            Scanner scan = new Scanner(System.in);
            String inpu = scan.nextLine();
            int amm = Integer.parseInt(inpu);

            if (amm > market.get(order)) {
                System.out.println("We don't have that many");
            } else {
                int x = market.get(order) - amm;
                market.replace(order, x);
                System.out.println("Here you are!");
            }

            scan.close();
        }
    }
    }


