package tree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.add(20);
        binarySearchTree.add(40);
        binarySearchTree.add(15);
        binarySearchTree.add(30);
        binarySearchTree.add(13);
        binarySearchTree.add(50);
        binarySearchTree.add(45);
        binarySearchTree.add(26);
        binarySearchTree.add(37);

        TreePrinter.print(binarySearchTree.root);
        //binarySearchTree.removeNo(26);

        System.out.println();

        //binarySearchTree.removeNo(26);
        //binarySearchTree.removeTwo(40);
        TreePrinter.print(binarySearchTree.root);
        //binarySearchTree.preOrder(binarySearchTree.root);
    }
}