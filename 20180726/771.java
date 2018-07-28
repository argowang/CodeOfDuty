class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (Character c: J.toCharArray()) {
            set.add(c);
        }
        
        for (Character c: S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        
        return count;
    }
}
