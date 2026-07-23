class Node {
    Node[] children;
    boolean eow;

    Node() {
        children = new Node[26];
        eow = false;
    }
}

class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node curr) {

        // Reached the end of the word
        if (index == word.length()) {
            return curr.eow;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            int idx = ch - 'a';

            if (curr.children[idx] == null)
                return false;

            return searchHelper(word, index + 1, curr.children[idx]);
        }

        // Wildcard '.'
        for (int i = 0; i < 26; i++) {

            if (curr.children[i] != null) {

                if (searchHelper(word, index + 1, curr.children[i]))
                    return true;
            }
        }

        return false;
    }
}