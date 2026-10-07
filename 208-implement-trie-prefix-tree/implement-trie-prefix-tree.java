class  Node{
    Node []links;
    boolean flg;
    public Node(){
        links=new Node[26];
        flg=false;
    }
    public boolean containKey(char ch){
         return (links[ch-'a']!=null);
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    void setend(){
        flg=true;
    }
    boolean getend(){
        return flg;
    }
}


class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setend();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        if(node.getend()){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
           if(!node.containKey(ch)){
                return false;
            }
            node =node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */