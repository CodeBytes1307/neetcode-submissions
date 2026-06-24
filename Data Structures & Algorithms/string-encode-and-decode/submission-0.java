class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++)
        {
            int len = strs.get(i).length();
            sb.append(len);
            sb.append("#");
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

    List<String> result = new ArrayList<>();

    int i = 0;

    while(i < str.length()) {

        int len = 0;

        // read length
        while(str.charAt(i) != '#') {
            len = len * 10 + (str.charAt(i) - '0');
            i++;
        }

        // skip #
        i++;

        // extract string of length len
        String word = str.substring(i, i + len);

        result.add(word);

        i = i + len;
    }
        return result;
    }
}
