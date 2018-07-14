class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex == 0){
            res.add(1);
            return res;
        }
        else if (rowIndex == 1){
            res.add(1);
            res.add(1);
            return res;
        }
        else{
            res.add(1);
            res.add(1);
            for(int i = 2; i < rowIndex + 1; i++){
                List<Integer> new_res = new ArrayList<Integer>();
                new_res.add(1);
                for(int j = 1; j < i; j ++){
                    new_res.add(res.get(j-1) + res.get(j));
                }
                new_res.add(1);
                res.add(1);
                for(int j = 1; j < i; j++){
                    res.set(j, new_res.get(j));
                }
            }
            return res;
        }
        
        
    }
}
