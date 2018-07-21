package July0714;
import java.util.*;


/*
* 170: Two Sum III
*  Data Structure Design
*/

public class TwoSum {
    /** Initialize your data structure here. */
    public Map<Integer, Integer> hash;
    public List<Integer> list;

    public TwoSum() {
        hash = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if(hash.containsKey(num1)) {
                hash = new HashMap<Integer, Integer>();
                return true;
            } else {
                hash.put(num2, i);
            }
        }
        hash = new HashMap<Integer, Integer>();
        return false;
    }

    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */


    public static void main(String[] args) {
        System.out.println("solution of two sum !");
        TwoSum two = new TwoSum();
        two.add(10);
        two.add(1);
        two.add(4);
        two.add(3);

        Boolean test = two.find(5);
        System.out.println("Result:" + test);
    }
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
