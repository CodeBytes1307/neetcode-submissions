class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        int maxFreq = 0;

        // Count frequencies and find the maximum frequency
        for (char ch : tasks) {
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
        }

        // Count how many tasks have the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq)
                maxCount++;
        }

        return Math.max(
            tasks.length,
            (maxFreq - 1) * (n + 1) + maxCount
        );
    }
}