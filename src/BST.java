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
        root = getRec(root, key);
    }
    private Node getRec(Node current, K key){
        if(current == null) {
            return null;
        } else if (current.key.compareTo(key) > 0) {
            current.right = getRec(current.right, key);
        }
    }
}
