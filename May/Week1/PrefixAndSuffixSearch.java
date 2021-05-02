package May.Week1;

import java.util.*;

public class PrefixAndSuffixSearch {
    public static void main(String[] args){
        String[][] str = {{"bccbacbcba", "a"},
                            {"ab","abcaccbcaa"},
                            {"a","aa"},
                            {"cabaaba","abaaaa"},
                            {"cacc","accbbcbab"},
                            {"ccbcab","bac"},
                            {"bac","cba"},
                            {"ac","accabaccaa"},
                            {"bcbb","aa"},
                            {"ccbca","cbcababac"}};
        WordFilter obj = new WordFilter(new String[] {"cabaabaaaa",
                                                    "ccbcababac",
                                                    "bacaabccba",
                                                    "bcbbcbacaa",
                                                    "abcaccbcaa",
                                                    "accabaccaa",
                                                    "cabcbbbcca",
                                                    "ababccabcb",
                                                    "caccbbcbab",
                                                    "bccbacbcba"});
        
        for(String[] s : str){
            System.out.println(obj.f(s[0], s[1]));
        }
    }
}
// class WordFilter {
//     ArrayList<String> list = new ArrayList<>();
//     PriorityQueue<String> pq = new PriorityQueue<>();
//     public WordFilter(String[] words) {
//         for(String word : words){
//             list.add(word);
//         }
//     }
    
//     public int f(String prefix, String suffix) {
//         list.add(prefix);
//         Collections.sort(list);
//         int idx = list.lastIndexOf(prefix);
//         list.remove(idx);
//         while(true){
//             StringBuilder sb = new StringBuilder(list.get(idx));
//             String str = sb.reverse().toString();
//             if(str.startsWith(new StringBuilder(suffix).reverse().toString())) return idx;
//             else idx ++;
//         }
//     }
// }

// class WordFilter {
//     TrieNode trie;
//     public WordFilter(String[] words) {
//         trie = new TrieNode();
//         int wt = 0;
//         for (String word: words) {
//             TrieNode cur = trie;
//             cur.weight = wt;
//             int L = word.length();
//             char[] chars = word.toCharArray();
//             for (int i = 0; i < L; ++i) {

//                 TrieNode tmp = cur;
//                 for (int j = i; j < L; ++j) {
//                     int code = (chars[j] - '`') * 27;
//                     if (tmp.children.get(code) == null)
//                         tmp.children.put(code, new TrieNode());
//                     tmp = tmp.children.get(code);
//                     tmp.weight = wt;
//                 }

//                 tmp = cur;
//                 for (int k = L - 1 - i; k >= 0; --k) {
//                     int code = (chars[k] - '`');
//                     if (tmp.children.get(code) == null)
//                         tmp.children.put(code, new TrieNode());
//                     tmp = tmp.children.get(code);
//                     tmp.weight = wt;
//                 }

//                 int code = (chars[i] - '`') * 27 + (chars[L - 1 - i] - '`');
//                 if (cur.children.get(code) == null)
//                     cur.children.put(code, new TrieNode());
//                 cur = cur.children.get(code);
//                 cur.weight = wt;

//             }
//             wt++;
//         }
//     }

//     public int f(String prefix, String suffix) {
//         TrieNode cur = trie;
//         int i = 0, j = suffix.length() - 1;
//         while (i < prefix.length() || j >= 0) {
//             char c1 = i < prefix.length() ? prefix.charAt(i) : '`';
//             char c2 = j >= 0 ? suffix.charAt(j) : '`';
//             int code = (c1 - '`') * 27 + (c2 - '`');
//             cur = cur.children.get(code);
//             if (cur == null) return -1;
//             i++; j--;
//         }
//         return cur.weight;
//     }
// }

// class TrieNode {
//     Map<Integer, TrieNode> children;
//     int weight;
//     public TrieNode() {
//         children = new HashMap();
//         weight = 0;
//     }
// }

class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}

class TrieNode {
    TrieNode[] children;
    int weight;
    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}