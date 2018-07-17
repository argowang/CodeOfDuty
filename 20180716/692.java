class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // count words
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        // use minheap store top k
        PriorityQueue<HashMap.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<HashMap.Entry<String, Integer>>(){
            @Override
            public int compare(HashMap.Entry<String, Integer> e1, HashMap.Entry<String, Integer> e2) {
                int res = e1.getValue().compareTo(e2.getValue());
                if ( res != 0) {
                    return res;
                } else {
                    return e2.getKey().compareTo(e1.getKey()); // alphabetical order
                }
            }
        });
        for (HashMap.Entry<String, Integer> entry : countMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()
                     || (entry.getValue() == minHeap.peek().getValue() && entry.getKey().compareTo(minHeap.peek().getKey()) < 0)) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // poll entry from heap and store in a String array
        List<String> result = new LinkedList<String>();
        while (minHeap.size() != 0) {
            result.add(0, minHeap.poll().getKey());
        }
        return result;
    }
}
