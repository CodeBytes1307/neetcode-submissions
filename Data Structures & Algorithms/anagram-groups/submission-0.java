class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        int len = strs.length;
        boolean[] visited = new boolean[len];

        for(int i = 0; i < len; i++)
        {
            if(visited[i])
                continue;

            char[] arr1 = strs[i].toCharArray();
            Arrays.sort(arr1);

            List<String> row = new ArrayList<>();

            for(int j = i; j < len; j++)
            {
                if(visited[j])
                    continue;

                char[] arr2 = strs[j].toCharArray();
                Arrays.sort(arr2);

                if(Arrays.equals(arr1, arr2))
                {
                    row.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(row);
        }

        return result;
    }
}