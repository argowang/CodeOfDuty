class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Python version 100% beats??
        // if (cost.length < 3){
        //     Arrays.sort(cost);
        //     return cost[0];
        // }
        //  List<Integer> res = new ArrayList<>();
        // for (int i : cost) {
        //     res.add(i);
        // }
        // res.add(0);
        // res.toArray();
        // for(int i = 2; i < res.size(); i ++){
        //     int value = res.get(i);
        //     res.set(i, value + Math.min(res.get(i - 1), res.get(i - 2)));
        // }
        // return res.get(res.size() - 1);
        if(cost.length < 3){
            Arrays.sort(cost);
            return cost[0];
        }
        int[] res = new int[cost.length + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i < res.length; i ++){
            res[i] = Math.min(res[i - 1] + cost[i - 1], res[i - 2] + cost [i - 2]);
        }
        return res[res.length - 1];
    }
}
