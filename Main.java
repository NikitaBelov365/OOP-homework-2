import java.util.*;



public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> listQueue = new LinkedList<>();
        listQueue.add(0);
        LinkedList<Integer> listMarket = new LinkedList<>();
        listMarket.add(0);
        HashMap<String, Integer> goods = new HashMap<>();
        goods.put("Meat", 25);
        goods.put("Fish", 20);
        goods.put("Cheese", 15);
        Market marketClass = new Market(goods);
        marketClass.update(goods);
        marketClass.enterMarket(listMarket);
        marketClass.enteringQueue(listQueue);
        String order = marketClass.takeOrder(goods);
        marketClass.price(order);
        marketClass.giveOrder(goods, order);
        marketClass.leavingQueue(listQueue);
        marketClass.leavingMarket(listMarket);
        marketClass.closeScanner();
        marketClass.comparatorSort();

    }
}