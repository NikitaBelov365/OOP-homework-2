import java.util.HashMap;
import java.util.LinkedList;


public interface IMarketBehavior{
    void enterMarket(LinkedList<Integer> list);

    void leavingMarket (LinkedList<Integer> list);

    void update(HashMap<String, Integer> market);

}
