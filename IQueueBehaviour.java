import java.util.HashMap;
import java.util.LinkedList;

public interface IQueueBehaviour {

    void enteringQueue(LinkedList<Integer> list);
    void leavingQueue(LinkedList<Integer> list);
    String takeOrder(HashMap<String, Integer> market);
    void giveOrder(HashMap<String, Integer> market, String order);


}
