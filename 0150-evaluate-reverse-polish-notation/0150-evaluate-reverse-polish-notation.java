class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(isOperator(tokens[i])) {
                if(!st.isEmpty()){
                    int x = st.pop();
                    int y = st.pop();
                    int res=0;
                    switch(tokens[i]) {
                        case "*" :
                            res = x*y;
                            break;
                        case "-" :
                            res = y-x;
                            break;
                        case "+" :
                            res = y+x;
                            break;
                        case "/":
                            res = y/x;
                            break;
                    
                    }
                    st.push(res);
                }
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        if(!st.empty())
            return st.pop();
        return 0;
    }
    
    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
}