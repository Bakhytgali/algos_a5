public class BST<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root = null;
    }
    public void put(K key, V value){
        root = putRec(root, key, value);
    }
    private Node putRec(Node current, K key, V value){
        if(current == null) {
            size++;
            return new Node(key, value);
        } else if(current.key.compareTo(key) > 0) {
            current.right = putRec(current.right, key, value);
        } else if(current.key.compareTo(key) < 0) {
            current.left = putRec(current.left, key, value);
        } else if(current.key.compareTo(key) == 0) {
            current.value = value;
        }
        return current;
    }
    public int getSize() {
        return size;
    }
    private Node deleteRec(Node current, K key){
        if(current == null){
            return null;
        } else if(current.key.compareTo(key) > 0){
            current.right = deleteRec(current.right, key);
        } else if(current.key.compareTo(key) < 0) {
            current.left = deleteRec(current.left, key);
        } else {
            if(current.right == null && current.left == null){
                return null;
            } else if(current.right == null) {
                deleteRec(current.left, key);
            } else if(current.left == null){
                deleteRec(current.right, key);
            } else {
                Node lessValue = lessValue(current.right);
                current.key = lessValue.key;
                current.value = lessValue.value;
                current.right = deleteRec(current.right, lessValue.key);
            }
        }
        return current;
    }
    public void delete(K key){
        root = deleteRec(root, key);
    }
    public Node lessValue(Node current){
        if(current.left == null){
            return current;
        } else {
            return lessValue(current.left);
        }
    }
    public Iterable<K> iterator(){
        return null;
    }
    public V get(K key) {
        Node res = getRec(root, key);
        if(res == null){
            return null;
        } else {
            return res.value;
        }
    }
    private Node getRec(Node current, K key){
        if(current == null) {
            return null;
        } else if (current.key.compareTo(key) > 0) {
            current.right = getRec(current.right, key);
        } else if(current.key.compareTo(key) < 0) {
            current.left = getRec(current.left, key);
        }
        return current;
    }
    private void inOrder(Node node){
        if(node !=null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    private boolean contains(Node current, K key, V value){ // Getting every root as current
                                                            // Key and value of elements that I'm checking
        if(current == null) { // If current node is null, the element can not be in bst
            return false;
        } else if(current.key.compareTo(key) > 0) { // if the key of the element is greater than
                                                    // current node's key, it goes to the right
            return contains(current.right, key, value);
        } else if(current.key.compareTo(key) < 0) { // if the key of the element if less than
                                                    // current node's key, than it goes to the left
            return contains(current.left, key, value);
        } else if(current.key == key && current.value == value) { // if current node has the same key and value
                                                                    // then check is completed with true result
            return true;
        } else { // every other option ends with the false result
            return false;
        }
    }
    public boolean contains(K key, V value){ // Getting key and value to check if bst contains the element
        return contains(root, key, value); // first node is root, so I'm returning it to my
                                            // recursive function with the value and key that I got
    }
}
