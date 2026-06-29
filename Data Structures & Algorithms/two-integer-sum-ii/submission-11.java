class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }

        while(i<j)
        {
            int sum = numbers[i] + numbers[j];
            if(sum == target)
            {
                return new int[]{i+1,j+1};
            }
            else if(list.contains(target - numbers[i]))
                j--;

            else if(list.contains(target - numbers[j]))
                i++;

            else {
                i++;
                j--;
            }
        }

        return new int[2];
    }
}
