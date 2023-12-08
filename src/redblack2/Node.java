package redblack2;

public class Node implements TreePrinter.PrintableNode{
    Integer data;
    Node left;
    Node right;
    Node parent;
    boolean color = true;
    public Node(Integer data,Node parent) {
        this.data = data;
        this.parent=parent;

        if(data != null){
            left = new Node(null,this);
            left.color = false;
            right = new Node(null,this);
            right.color = false;
        }
    }
    @Override
    public TreePrinter.PrintableNode getLeft() {
        return this.left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return this.right;
    }

    @Override
    public String getText() {
        return "["+data+"]" +"[" + color + "]";
    }

}
