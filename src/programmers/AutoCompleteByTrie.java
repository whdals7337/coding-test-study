package programmers;

// 프로그래머스 자동완성 문제 - Trie 를 이용한 풀이
class AutoCompleteByTrie {
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for(int i = 0; i < words.length; i++) {
            answer += trie.query(words[i]);
        }
        return answer;
    }
}

class Trie {
    boolean isLeafNode = true; // 리프노드 여부
    Trie[] subTrie = new Trie[26]; // 알파벳 26개 포함 하도록 길이 설정

    void insert(String key) {
        int index = 0;
        Trie trie;
        if(this.subTrie[charToNumber(key.charAt(index))] == null) {
            trie = this.subTrie[charToNumber(key.charAt(index))] = new Trie();
        }else {
            trie = this.subTrie[charToNumber(key.charAt(index))];
            // 등록된적 있는 노드 이기 때문에 노드를 하나 더 추가하면서 리프노드가 아니게 됨
            trie.isLeafNode = false;
        }
        index++;

        // 등록할 문자열을 순회하면서 하위 Trie를 생성 및 갱신
        while(index < key.length()) {
            int next = charToNumber(key.charAt(index));
            if(trie.subTrie[next] == null) {
                trie.subTrie[next] = new Trie();
            }else {
                trie.subTrie[next].isLeafNode = false;
            }
            trie = trie.subTrie[next];
            index++;
        }
    }
    int query(String key) {
        int sameCharCount = 1, index = 0;
        Trie trie = this.subTrie[charToNumber(key.charAt(index))];
        index++;
        while(index < key.length()) {
            int next = charToNumber(key.charAt(index));

            if(trie.isLeafNode) break;

            sameCharCount++;
            trie = trie.subTrie[next];
            index++;
        }
        return sameCharCount;
    }
    int charToNumber(char c) {
        return c - 'a';
    }
}