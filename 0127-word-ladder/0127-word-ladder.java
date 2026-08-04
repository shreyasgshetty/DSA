class Pair{
    String word;
    int step;

    Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for(int i = 0 ; i < len; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int step = queue.peek().step;
            queue.poll();

            if(word.equals(endWord)) return step;

            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replaceArray = word.toCharArray();
                    replaceArray[i] = ch;
                    String replacedWord = new String(replaceArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        queue.offer(new Pair(replacedWord,step+1));
                    }
                }
            }
        }

        return 0;
    }
}