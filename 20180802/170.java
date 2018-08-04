class TwoSum {

    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key: map.keySet()) {
            if (value - key == key && map.get(key) > 1) {
                return true;
            } else if (value - key != key && map.containsKey(value-key)) {
                return true;
            }
        }
        return false;
    }
}
