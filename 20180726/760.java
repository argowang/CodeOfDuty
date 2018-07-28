class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        if (A.length == 0) {
            return result;
        }
        
        HashMap<Integer, Integer> intToIndex = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            intToIndex.put(B[i], i);
        }
        
        for (int i = 0; i < A.length; i++) {
            result[i] = intToIndex.get(A[i]);
        }
        return result;
    }
}
