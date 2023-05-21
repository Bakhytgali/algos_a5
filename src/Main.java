public class Main {
    public static void main(String[] args) {
        BST<Integer, String> searchTree = new BST<>();
        searchTree.put(5, "Luffy");
        searchTree.put(1, "Shanks");
        searchTree.put(3, "Mihawk");
        System.out.println(searchTree.getSize());
        System.out.println(searchTree.get(5));
        searchTree.delete(3);
        System.out.println(searchTree.get(3));
    }
}