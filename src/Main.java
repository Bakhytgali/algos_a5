public class Main {
    public static void main(String[] args) {
        BST<Integer, String> searchTree = new BST<>();
        searchTree.put(8, "Shanks");
        searchTree.put(3, "Luffy");
        searchTree.put(21, "Ace");
        searchTree.put(2, "Zoro");
        searchTree.put(10, "Sanji");
        System.out.println(searchTree.contains(2, "Zoro"));
        System.out.println(searchTree.contains(3, "Luffy"));
        System.out.println(searchTree.contains(5, "Akainu"));
    }
}