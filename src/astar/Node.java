package astar;

public class Node {
    Integer nearDistance; // 인접 위치까지 거리
    Integer goalDistance; // 최종 목적지까지 거리
    Integer totalDistance;; // 인접 위치까지 거리 + 최종 목적지까지 거리

    // 배열의 좌표
    Integer x;
    Integer y;

    Node parents; // 부모 노드

    public Node(Integer x, Integer y, Node parents) {
        this.x = x;
        this.y = y;
        this.parents = parents;
    }
}
