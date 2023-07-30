import java.util.HashMap;
import java.util.LinkedList;



public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> listQueue = new LinkedList<>();
        listQueue.add(0);
        LinkedList<Integer> listMarket = new LinkedList<>();
        listMarket.add(0);
        HashMap<String, Integer> goods = new HashMap<>();
        goods.put("Meat", 25);
        goods.put("Fish", 25);
        goods.put("Cheese", 25);
        System.out.println(goods);
        Market marketClass = new Market(goods);
        marketClass.update(goods);
        marketClass.enterMarket(listMarket);
        marketClass.enteringQueue(listQueue);
        String order = marketClass.takeOrder(goods);
        marketClass.giveOrder(goods, order);
        marketClass.leavingQueue(listQueue);
        marketClass.leavingMarket(listMarket);
        marketClass.update(goods);
    }
}