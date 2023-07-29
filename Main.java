import java.util.HashMap;
import java.util.LinkedList;



public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> listQueue = new LinkedList<>();
        listQueue.add(0);
        LinkedList<Integer> listMarket = new LinkedList<>();
        listMarket.add(0);
        HashMap<String, Integer> market = new HashMap<>();
        market.put("Meat", 25);
        market.put("Fish", 25);
        market.put("Cheese", 25);
        System.out.println(market);
        Market marketClass = new Market();
        marketClass.update(market);
        marketClass.enterMarket(listMarket);
        marketClass.enteringQueue(listQueue);
        String order = marketClass.takeOrder(market);
        marketClass.giveOrder(market, order);
        marketClass.leavingQueue(listQueue);
        marketClass.leavingMarket(listMarket);
        marketClass.update(market);
    }
}