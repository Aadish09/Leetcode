class Solution {
    public List<Integer> getRow(int n) {
        List<List<Integer>> parent = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(1);

        if(n==0) return li;
                List<Integer> li1 = new ArrayList<>();

        li1.add(1);
        parent.add(li);
        List<Integer> li2 = new ArrayList<>();
        li2.add(1);
        li2.add(1);
        parent.add(li2);
                if(n==1) return li2;


        for(int i=2;i<=n;i++) {
            List<Integer> child = new ArrayList<>();
            child.add(1);
            for(int j=1;j<i;j++){
                child.add(parent.get(i-1).get(j-1) + parent.get(i-1).get(j));
            }
            child.add(1);
            parent.add(child);

        }
        return parent.get(n);
    }
}