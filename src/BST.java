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
            }
        }
    }
    public Node lessValue(Node current){
        if(current.left == null){
            return current;
        } else {
            return lessValue(current.left);
        }
    }
}
