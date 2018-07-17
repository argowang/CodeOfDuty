class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // count nums
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // store in heap
        PriorityQueue<HashMap.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<HashMap.Entry<Integer, Integer>>(){
            @Override
            public int compare(HashMap.Entry<Integer, Integer> e1, HashMap.Entry<Integer, Integer> e2) {
                int res = e1.getValue().compareTo(e2.getValue());
                if ( res != 0) {
                    return res;
                } else {
                    return e2.getKey().compareTo(e1.getKey()); // alphabetical order
                }
            }
        });
        for (HashMap.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        List<Integer> result = new LinkedList<>();
        while (minHeap.size()!= 0) {
            result.add(0, minHeap.poll().getKey());
        }
        return result;
    }
}
