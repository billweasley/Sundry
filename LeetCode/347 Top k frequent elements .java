class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if (map.get(num) == null) {
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pq.size() < k){
                pq.offer(entry);
            }else{
                if (pq.peek().getValue() < entry.getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }

        return result;

    }
}