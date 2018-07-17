class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 0) {
          return result;
        }
        StringBuilder current = new StringBuilder();
        int left = 0;
        int right = 0;
        helper(result, current, left, right, n);
        return result;
    }
    private void helper(List<String> result, StringBuilder current, int left, int right, int n) {
        if (left == n && right == n) {
          result.add(current.toString());
          return;
        }
        if (left != n) {
          current.append('(');
          helper(result, current, left+1, right, n);
          current.deleteCharAt(current.length() - 1);
        }
        if (right < left) {
          current.append(')');
          helper(result, current, left, right + 1, n);
          current.deleteCharAt(current.length() - 1);
        }
    }
}
