public class Main {
    public static void main(String[] args){
        MyBinarySearchTree bst = new MyBinarySearchTree(10);
        bst.add(5);
        bst.add(1);
        bst.add(3);
        bst.add(8);
        bst.add(12);
        bst.add(15);
        bst.add(13);

        System.out.println(bst.inOrderTraversal()); // 1 3 5 8 10 12 13 15
        System.out.println(bst.findMax()); // 15
        System.out.println(bst.preOrderTraversal()); // 10 5 1 3 8 12 15 13
        System.out.println(bst.postOrderTraversal()); // 3 1 8 5 13 15 12 10
        System.out.println(bst.find(1)); //true
        System.out.println(bst.find(12)); //true
        System.out.println(bst.find(10)); //true
        System.out.println(bst.find(20)); //false
    }
}