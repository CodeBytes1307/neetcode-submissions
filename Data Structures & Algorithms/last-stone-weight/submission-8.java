class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones)
            pq.offer(num);

        while(pq.size() > 1)
        {
            int x = pq.poll();
            int y = pq.poll();

            if(x>y)
                pq.offer(x-y);
        }

        if(pq.peek() != null)
            return pq.peek();
        else
            return 0;
    }
}
