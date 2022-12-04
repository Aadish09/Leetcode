public class Freq {
    int freq;
    char c;
    Freq(int freq, char c) {
        this.c = c;
        this.freq = freq;
    }
}

class FreqComparator implements Comparator<Freq>{
       public int compare(Freq s1, Freq s2) {
            if(s1.freq>s2.freq) return -1;
           if(s1.freq == s2.freq) return 0;
           return 1;
       }
 }
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i=0;i<s.length();i++) {
            Character t = s.charAt(i);
            if(map.get(t)==null) {
                map.put(t, 1);
            } else {
                map.replace(t, map.get(t)+1);
            }
        }
        PriorityQueue<Freq> pq = new  PriorityQueue<Freq>(new FreqComparator());
        for(Character c : map.keySet()) {
            Freq freq = new Freq(map.get(c), c);
            pq.add(freq);
        }
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Freq freq = pq.poll();
            for(int i=0;i<freq.freq;i++){
                res.append(freq.c);
            }
        }
        return res.toString();
    }
}