class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        for(int i = 0; i < len; i++)
        {
            for(int j = i; j < len; j++)
            {
                if(temperatures[j]>temperatures[i])
                {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }
}
