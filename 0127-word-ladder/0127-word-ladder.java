class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        Queue<String>  q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String s : wordList) {
            set.add(s);
        }
        
        q.add(beginWord);
        q.add(null);
        int count = 0;
        while(!q.isEmpty()){
            String temp = q.poll();
            if(temp == null) {                
                if(!q.isEmpty()) {
                    count ++;
                    q.add(null);
                    continue;
                }                       
                else return 0;
            }
            if(temp.equals(endWord)) return count+1;
            else {
                for(int i=0;i<temp.length();i++) {
                    for(char c = 'a';c <='z';c++) {
                        String res = temp.substring(0,i) + c + temp.substring(i+1, temp.length());
                        if(set.contains(res) && 
                           !res.equals(temp)){
                            set.remove(res);
                            System.out.println(res);
                            q.add(res); 
                        }
                    }
                }
                
            }
        }
        return count;
        
    }
}