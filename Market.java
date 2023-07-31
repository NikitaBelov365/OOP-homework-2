import java.util.*;


public class Market implements IQueueBehaviour, IShowingPriceFunctional {

    private final Scanner scanner;
    private HashMap<String, Integer> data;

    public Market(HashMap<String, Integer> goods) {
        this.data = goods;
        this.scanner = new Scanner(System.in);
    }


    public int getVolume() {
        int result = 0;
        for (int value : data.values()) {
            result += value;
        }
        return result;
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
        String order = scanner.nextLine();
        if (market.containsKey(order)) {
            return order;
        } else {
            return null;
        }
    }


    @Override
    public void giveOrder(HashMap<String, Integer> market, String order) {
        if (order.equals("null")) {
            System.out.println("Sorry, we don't have your order");
        } else {
            System.out.println("How many items do you need?");
            String input = scanner.nextLine(); // Используйте тот же Scanner для ввода
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

    @Override
    public void price(String order) {
        Random rnd = new Random();
        int price = rnd.nextInt(5, 15);
        System.out.println(order + " = " + price + " RUB");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void comparatorSort() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(data.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}


