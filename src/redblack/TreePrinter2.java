package redblack;

class TreePrinter2 {
    // 이진 트리를 출력하는 메서드
    static void print(Node root, int level) {
        if (root != null) {
            print(root.right, level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("    ");
            System.out.println(root.data + " (" + (root.color == 0 ? "B" : "R") + ")");
            print(root.left, level + 1);
        }
    }
}