package redblack;

public class Node implements TreePrinter.PrintableNode{
    Integer data;
    Integer color;  // 0 : 검정색 / 1 : 빨간색
    Node left;
    Node right;

    Node parent;

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
        return "["+data+"]";
    }

    public Node(Integer data, Node parent) {
        this.data = data;
        this.color = 1;   // 노드 추가 시마다 노드의 색깔은 빨강
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}
