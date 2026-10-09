class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                }else{
                    ans++;
                }
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    ans++;
                }
            }
        }
        ans+=st.size()*2;
        return ans;
    }
}