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

    public void put(K key, V value){
        root = putRec(root, key, value);
    }
    private Node putRec(Node current, K key, V value){
        if(current == null) {
            size++;
            return new Node(key, value);
        }
    }
}
