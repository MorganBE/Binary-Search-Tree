public class MyBinarySearchTree implements MyBinarySearchTreeInterface{
    Node root;

    public MyBinarySearchTree(int data){
        root = new Node(data);
    }

    @Override
    public void add(int data){
        root = addRecursive(data, root);
    }

    @Override
    public int findMin(){
        Node smallest = findMinRecursive(root);
        return smallest.data;
    }
    @Override
    public int findMax(){
        Node largest = findMaxRecursive(root);
        return largest.data;
    }

    @Override
    public String inOrderTraversal(){
        return inOrderTraversalRecursive(root);
    }

    @Override
    public boolean delete(int value){
        Node deleted = deleteRecursive(value, root);
        if(deleted == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String preOrderTraversal() {
        return preOrderTraversal(root);
    }

    @Override
    public String postOrderTraversal() {
        return postOrderTraversal(root);
    }

    @Override
    public boolean find(int value) {
        return findRecursive(root, value);
    }

    private Node addRecursive(int data, Node current){
        if(current == null){
            current = new Node(data);
        } else {
            if(current.data > data){
                current.left = addRecursive(data, current.left);
            } else if (current.data < data){
                current.right = addRecursive(data, current.right);
            }
        }

        return current;
    }

    private Node findMinRecursive(Node current){
        if(current.left == null){
            return current;
        }else{
            return findMinRecursive(current.left);
        }
    }
    private Node findMaxRecursive(Node current){
        if(current.right == null){
            return current;
        }else{
            return findMaxRecursive(current.right);
        }
    }

    private String inOrderTraversalRecursive(Node current){
        if(current == null){
            return "";
        }else{
            return inOrderTraversalRecursive(current.left) + " " + current.data + inOrderTraversalRecursive(current.right);
        }
    }
    private String preOrderTraversal(Node current){
        if(current == null){
            return "";
        }else{
            return current.data + " " +preOrderTraversal(current.left) +  preOrderTraversal(current.right);
        }
    }
    private String postOrderTraversal(Node current){
        if(current == null){
            return "";
        }else{
            return postOrderTraversal(current.left)  +  postOrderTraversal(current.right) + current.data + " ";
        }
    }
    private boolean findRecursive(Node current, int value){
        if(current == null){
            return false;
        }
        if(value == current.data){
            return true;
        }
        if(value < current.data){
            return findRecursive(current.left, value);
        }else{
            return  findRecursive(current.right, value);
        }
    }




    private Node deleteRecursive(int i, Node current){
        if(current == null){
            return current;
        }
        if(i < current.data){
            current.left = deleteRecursive(i, current.left);
        }else if (i > current.data){
            current.right = deleteRecursive(i, current.right);
        }else{
            if(current.left == null){
                return current.right;
            }else if (current.right == null){
                return current.left;
            }else {
                Node successor = findMinRecursive(current.right);
                current.data = successor.data;
                current.right = deleteRecursive(successor.data, current.right);
            }
        }

        return current;
    }

    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}