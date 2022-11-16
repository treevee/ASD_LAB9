class tree{
    tree(){
        root=null;
        size=0;
    }
    //Створюємо клас вузла, який міститиме не лише значення, а й ключ. Сортування у дереві буде відбуватися за ключом.
    class node{
        node(String key, String value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
        public String key;
        public String value;
        public node left;
        public node right;
    }
    private node root;
    private int size;
    public void insert(String key,String value){
        root=DoInsert(root,key,value);
        size++;
    }
    public void inorder(){
        printInorder(root);
    }
    public String find(String key){
        return search(root,key);
    }
    private node DoInsert(node node_, String key, String value){

        if(node_==null){
            return new node(key,value);
        }
        int compare = node_.key.compareTo(key);
        if(compare>0){
            node_.left=DoInsert(node_.left,key,value);
        }
        else if(compare<0){
            node_.right=DoInsert(node_.right,key,value);
        }
        return node_;
    }
    private void printInorder(node node_){
        if(node_==null){
            return;
        }
        printInorder(node_.left);
        System.out.print("<"+node_.key+", "+node_.value+"> ");
        printInorder(node_.right);
    }
    private String search(node node_, String key){
        while(node_!=null){
            int compare = node_.key.compareTo(key);
            if(compare==0){
                return node_.value;
            }
            if(compare>0){
                node_=node_.left;
            }
            else if(compare<0){
                node_=node_.right;
            }
        }
        return "Not Found";
    }

}
