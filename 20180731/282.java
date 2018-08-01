class Solution {
    private int target;
    private String num;
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num == "") {
            return result;
        }
        this.target = target;
        this.num = num;
        dfs(result, "", 0, 0, 0);
        return result;
        
    }
    
    public void dfs(List<String> result, String path, int pos, long eval, long multiplier) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path);
                return;
            }
        }
        
        for (int i = pos; i < num.length(); i++) {
            // invalid long number i.e. 03
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            
            long currNum = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                dfs(result, path + currNum, i+1, currNum, currNum);
            } else {
                dfs(result, path + "+" + currNum, i+1, eval + currNum, currNum);
                dfs(result, path + "-" + currNum, i+1, eval - currNum, -currNum);
                dfs(result, path + "*" + currNum, i+1, eval - multiplier + multiplier * currNum, multiplier * currNum);
            }
        }
    }
}
