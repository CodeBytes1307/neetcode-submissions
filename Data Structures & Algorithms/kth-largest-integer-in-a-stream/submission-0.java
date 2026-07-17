class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        // If we don't yet have k elements,
        // simply add the new value.
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }

        // If val is larger than the smallest
        // among the top k elements, replace it.
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        // The root of the min heap is always
        // the kth largest element.
        return minHeap.peek();
    }
}