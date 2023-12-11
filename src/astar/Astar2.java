package astar;

import java.util.ArrayList;

public class Astar2 {

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

    public Astar2(Integer[][] map) {
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

    public void findPath() {
        // 시작점을 '열린 목록'에 넣는다.
        openList.add(start);

        // 열린 목록이 비어 있지 않으면 반복, 리스트가 비어있는지 아닌지 확인은 리스트변수.isEmpty()
        while(!openList.isEmpty()) {
//            열린 목록에서 제일 처음 노드를 가져온다(가져온 노드는 목록에서 삭제)
            Node node = openList.get(0);
            openList.remove(0);
//            가져온 노드는 닫힌 목록에 넣어준다.
            closeList.add(node);
//            만약 가져온 노드가 최종 목적지면
            if(goal.x == node.x && goal.y == node.y) {
//                  최종 경로 출력
            }
//            그렇지 않으면
            else {
                // addAdjacentNodes 메소드 실행
                addAdjacentNodes(node);

            }
        }
    }

    public Boolean isDuplicate(Node adjacentNode) {
        // 열린 목록에 있는 노드를 하나씩 가져오면서 반복
        for(int i=0; i<openList.size(); i++) {
            // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
            //      중복
            if(!openList.isEmpty() && openList.get(i).x == adjacentNode.x && openList.get(i).y == adjacentNode.y) {
                return true;
            }
        }
        // 닫힌 목록에 있는 노드를 하나씩 가져오면서 반복
        for(int i=0; i<closeList.size(); i++) {
            // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
            //      중복
            if(!closeList.isEmpty() && closeList.get(i).x == adjacentNode.x && closeList.get(i).y == adjacentNode.y) {
                return true;
            }
        }
        // 중복 아님
        return false;
    }

    public void addAdjacentNodes(Node currentNode) {
        // 전달 받은 노드의 X,Y 좌표를 따로 저장
        Integer x = currentNode.x;
        Integer y = currentNode.y;
        // 왼위, 위, 오위, 왼, 오, 왼아, 아, 오아


        Node[] nearNode = new Node[8];
        for(int i=-1; i<2; i++) {
            for(int j=-1; j<2; j++) {
                nearNode[i].x = x;
                nearNode[i].y = y+j;

                if(nearNode[i].x >=0 && nearNode[i].y >=0 && nearNode[i].x<10 && nearNode[i].y<10 && this.map[nearNode[i].y][nearNode[i].x] != 3) {
                    if(nearNode[i].x == currentNode.x || nearNode[i].y == currentNode.y) {
                        nearNode[i].nearDistance = currentNode.nearDistance + DEFAULT_COST;
                        nearNode[i].goalDistance = 10*((Math.abs(goal.x - nearNode[i].x)) + (Math.abs(goal.y - nearNode[i].y)));
                        nearNode[i].totalDistance = nearNode[i].nearDistance + nearNode[i].goalDistance;
                    } else {
                        nearNode[i].nearDistance = currentNode.nearDistance + DEFAULT_DIAGONAL;
                        nearNode[i].goalDistance = 10*((Math.abs(goal.x - nearNode[i].x)) + (Math.abs(goal.y - nearNode[i].y)));
                        nearNode[i].totalDistance = nearNode[i].nearDistance + nearNode[i].goalDistance;
                    }
                }
                Boolean isDuplicate = isDuplicate(nearNode[i]);

                if(isDuplicate == false) {
                    openList.add(nearNode[i]);
                }
                //      F 값을 기준으로 정렬 오름차순 정렬
            }
            if(nearNode[i].x == x && nearNode[i].y == y) {
                continue;
            }
        }
        // 인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
        // FGH 계산해서 각각 변수에 저장

        // 새로운 노드 생성(전달해줄거 전달해서 생성)
        // isDuplicate 메소드 실행해서 결과를 저장

        // 만약에 isDuplicate 메소드 실행 결과가 거짓이면
        //      생성한 노드를 열린 목록에 넣는다

        //      F 값을 기준으로 정렬 오름차순 정렬

    }
}
