class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int level = 0; level < numRows; level ++){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < level + 1; i ++){
                tmp.add(1);
            }
            res.add(tmp);
        }
        for(int level = 1; level < numRows; level ++){
            for(int i = 1; i < level; i ++){
                res.get(level).set(i,  res.get(level - 1).get(i - 1) + res.get(level - 1).get(i));
            }
        }
        return res;
    }
}
