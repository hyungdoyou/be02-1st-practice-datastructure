package astar;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class Astar {
    // map의 값 중 1을 출발지, 2를 목적지
    final Integer DEFAULT_COST = 10;     // 직선 거리
    final Integer DEFAULT_DIAGONAL = 14; // 대각선 거리

    Integer[][] map;
    Node start;  // 출발지
    Node goal;   // 도착지
    Node block;

    ArrayList<Node> openList = new ArrayList<Node>();     // 열린 리스트
    ArrayList<Node> closeList = new ArrayList<Node>();    // 닫힌 리스트

    ArrayList<Node> printList = new ArrayList<Node>();

    public Astar(Integer[][] map) {
        this.map = map;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                // 출발지 설정
                if (map[i][j] == 1) {
                    //System.out.println("x 좌표 : " + j + ", y 좌표 : " + i);
                    this.start = new Node(j, i, null);
                    this.start.nearDistance = 0;
                    this.start.goalDistance = 0;
                    this.start.totalDistance = 0;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    this.goal = new Node(j, i, null);
                }
            }
        }
    }

    // 길찾기 기능
    public void findPath(){
        openList.add(start); // 시작점 추가

        Integer minTotalDistance = 0;
        Node minNode = null;

        // 열린 목록이 비어있지 않으면 반복한다.
        while (!openList.isEmpty()) {
            // 열린 목록에서 totalDistance값이 가장 작은 노드를 하나 가져온다.
            if(openList.size() == 1) {
                addNearNode(start);
            }
            if(openList.size() >=2){
                minTotalDistance = openList.get(1).totalDistance;
                minNode = openList.get(1);
                for(int i=1; i<openList.size(); i++) {
                    if(openList.get(i).nearDistance < minTotalDistance) {
                        minTotalDistance = openList.get(i).totalDistance;
                        minNode = openList.get(i);
                    }
                }
                // 가져온 노드는 열린 목록에서 삭제한다.
                openList.remove(minNode);
                // 가져온 노드는 닫힌 목록에 넣어준다.
                closeList.add(minNode);

                // 만약 가져온 노드가 최종 목적지라면
                if(minNode.x == goal.x && minNode.y== goal.y) {
                    // 최종 경로 출력
                    for(int i=0; i< closeList.size(); i++) {
                        System.out.println(closeList.get(i).x +"   " +closeList.get(i).y);
                    }
                    printPath(minNode);
                    break;
                }
                // 그렇지 않으면
                else {
                    // 가져온 노드의 인접 노드 중 갈 수 있는 노드의 객체를 생성
                    addNearNode(minNode);
                }
            }

        }
    }
    // 최종 경로 출력 메서드
    public void printPath(Node node) {
        // 특정 노드를 하나 전달 받아서
        // 출력하고 부모 부모 부모 부모 --- 찾아가서 출발지부터 목적지까지 출력
        System.out.println("("+node.x+", "+node.y+")");
        while(true) {
            if (node.parents.x == start.x && node.parents.y == start.y) {
                System.out.println("("+node.parents.x+", "+node.parents.y+")");
                break;
            } else {
                System.out.println("("+node.parents.x+", "+node.parents.y+")");
            }
            node.parents = node.parents.parents;
        }
    }

    // 인접 노드 추가 메서드
    public void addNearNode(Node node) {
        // 인접 노드를 열린 목록에 추가하는데
        // 만약 열린 목록에 있다면 미추가
        // 그렇지 않으면 추가
        // 생성한 노드의 부모 노드를 현재 가져온 노드로 지정
        // 생성한 노드의 f,g,h 를 계산하여
        // 열린 목록에 추가
//        Node newNode1;
        // 처음 들어온 노드는 시작 노드
        // 들어온 노드의 인접 노드는 기본적으로 8개
//        Integer index = 0;
//        for(int i=-1; i<2; i++) {
//            for(int j=-1; j<2; j++) {
//                addList.add() = new Node(node.x+i, node.y+j, node);
//            }
//            index = index+1;
//        }
        Node newNode1 = new Node(node.x-1,node.y-1,node);
        // 만약 생성할 인접노드가 열린 리스트에 없고, 블록 리스트에도 없다면
        // 열린 리스트에 추가
        if(newNode1.x >=0 && newNode1.y >=0 && newNode1.x <10 && newNode1.y <10) {
            if(!openList.contains(newNode1) && this.map[newNode1.y][newNode1.x] != 3) {
                newNode1.nearDistance = 14+node.nearDistance;
                newNode1.goalDistance = 10*(Math.abs(goal.x - newNode1.x)+Math.abs(goal.y - newNode1.y));
                newNode1.totalDistance = newNode1.nearDistance + newNode1.goalDistance;
                openList.add(newNode1);
            }
        }

        Node newNode2 = new Node(node.x,node.y-1,node);
        if(newNode2.x >=0 && newNode2.y >=0 && newNode2.x<10 && newNode2.y<10){
            if(!openList.contains(newNode2) && this.map[newNode2.y][newNode2.x] != 3) {
                newNode2.nearDistance = 10+node.nearDistance;
                newNode2.goalDistance = 10*(Math.abs(goal.x - newNode2.x)+Math.abs(goal.y - newNode2.y));
                newNode2.totalDistance = newNode2.nearDistance + newNode2.goalDistance;
                openList.add(newNode2);
            }
        }

        Node newNode3 = new Node(node.x+1,node.y-1,node);
        if(newNode3.x >=0 && newNode3.y >=0 && newNode3.x<10 && newNode3.y<10){
            if(!openList.contains(newNode3) && this.map[newNode3.y][newNode3.x] != 3) {
                newNode3.nearDistance = 14+node.nearDistance;
                newNode3.goalDistance = 10*(Math.abs(goal.x - newNode3.x)+Math.abs(goal.y - newNode3.y));
                newNode3.totalDistance = newNode3.nearDistance + newNode3.goalDistance;
                openList.add(newNode3);
            }
        }

        Node newNode4 = new Node(node.x-1,node.y,node);
        if(newNode4.x >=0 && newNode4.y >=0 && newNode4.x<10 && newNode4.y<10){
            if(!openList.contains(newNode4) && this.map[newNode4.y][newNode4.x] != 3) {
                newNode4.nearDistance = 10+node.nearDistance;
                newNode4.goalDistance = 10*(Math.abs(goal.x - newNode4.x)+Math.abs(goal.y - newNode4.y));
                newNode4.totalDistance = newNode4.nearDistance + newNode4.goalDistance;
                openList.add(newNode4);
            }
        }

        Node newNode5 = new Node(node.x+1,node.y,node);
        if(newNode5.x >=0 && newNode5.y >=0 && newNode5.x<10 && newNode5.y<10){
            if(!openList.contains(newNode5) && this.map[newNode5.y][newNode5.x] != 3) {
                newNode5.nearDistance = 10+node.nearDistance;
                newNode5.goalDistance = 10*(Math.abs(goal.x - newNode5.x)+Math.abs(goal.y - newNode5.y));
                newNode5.totalDistance = newNode5.nearDistance + newNode5.goalDistance;
                openList.add(newNode5);
            }
        }

        Node newNode6 = new Node(node.x-1,node.y+1,node);
        if(newNode6.x >=0 && newNode6.y >=0 && newNode6.x<10 && newNode6.y<10){
            if(!openList.contains(newNode6) && this.map[newNode6.y][newNode6.x] != 3) {
                newNode6.nearDistance = 14+node.nearDistance;
                newNode6.goalDistance = 10*(Math.abs(goal.x - newNode6.x)+Math.abs(goal.y - newNode6.y));
                newNode6.totalDistance = newNode6.nearDistance + newNode6.goalDistance;
                openList.add(newNode6);
            }
        }

        Node newNode7 = new Node(node.x,node.y+1,node);
        if(newNode7.x >=0 && newNode7.y >=0 && newNode7.x<10 && newNode7.y<10){
            if(!openList.contains(newNode7) && this.map[newNode7.y][newNode7.x] != 3) {
                newNode7.nearDistance = 10+node.nearDistance;
                newNode7.goalDistance = 10*(Math.abs(goal.x - newNode7.x)+Math.abs(goal.y - newNode7.y));
                newNode7.totalDistance = newNode7.nearDistance + newNode7.goalDistance;
                openList.add(newNode7);
            }
        }

        Node newNode8 = new Node(node.x +1,node.x+1,node);
        if(newNode8.x >=0 && newNode8.y >=0 && newNode8.x<10 && newNode8.y<10){
            if(!openList.contains(newNode8) && this.map[newNode8.y][newNode8.x] != 3) {
                newNode8.nearDistance = 14+node.nearDistance;
                newNode8.goalDistance = 10*(Math.abs(goal.x - newNode8.x)+Math.abs(goal.y - newNode8.y));
                newNode8.totalDistance = newNode8.nearDistance + newNode8.goalDistance;
                openList.add(newNode8);
            }
        }
    }
}
