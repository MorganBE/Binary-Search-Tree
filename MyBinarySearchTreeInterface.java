public interface MyBinarySearchTreeInterface {
    void add(int data);
    int findMin();
    String inOrderTraversal();
    boolean delete(int value);

    int findMax();
    String preOrderTraversal();
    String postOrderTraversal();
    boolean find(int value);
}