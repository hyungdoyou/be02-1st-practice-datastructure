package dijkstra;

import java.util.*;
public class Dijkstra {
    // 다익스트라 알고리즘 구현하기
    int[] cost;
    int[] path;

    public void findShortestPath(List<List<Integer>> lists, Integer n, Integer startNum) {

        // 방문기록을 담을 배열
        boolean[] visited = new boolean[n]; // 노드 개수
        visited[startNum] = true;  // 처음 시작하는 곳은 방문으로 처리

        // 출발지부터 목적지 노드까지 갈때 총 거리를 담을 배열
        cost = new int[n];
        path = new int[n];

        Boolean flag = true;
        // 입력받은 시작점부터 리스트의 첫번째 원소가 시작점과 동일한 인덱스의 도착지를 적고, 그 거리를 적는다.
        while(flag) {
            flag = false;
            Integer index=0;
            Integer min = 20000;
            // 입력받은 배열의 사이즈만큼 반복
            for(int i=0; i<lists.size(); i++) {
                // 만약 start 번호와 입력받은 배열의 인덱스마다 들어있는 리스트의 0번째 값이 같다면
                if (startNum == lists.get(i).get(0)) {
                    // 목적지(리스트의 1번째 인덱스값) 까지의 거리 = 리스트의 2번째 값이다. (이걸 계속 더해줌)
                    if (cost[lists.get(i).get(1)] != 0 && cost[lists.get(i).get(0)] + lists.get(i).get(2) > cost[lists.get(i).get(1)]) {
                        continue;
                    } else {
                        cost[lists.get(i).get(1)] = cost[lists.get(i).get(0)] + lists.get(i).get(2);
                        path[lists.get(i).get(1)] = lists.get(i).get(0);
                    }
                }
            }
            // 해당 반복문이 끝난 뒤 cost[] 배열 중 가장 작은 값을 찾는다.
            for (int i = 0; i < cost.length; i++) {
                if(cost[i] == 0 || visited[i] == true) {
                    continue;
                } else if(min > cost[i]) {
                    min = cost[i];
                    index = i;
                }
            }
            startNum = index; // 출발지를 재조정할 변수
            visited[index] = true;   // 해당 노드는 방문한것으로 처리

            for (int i = 0; i < visited.length; i++) {
                if (visited[i] != true) {
                    flag = true;
                }
            }
        }
    }

    public void print() {
        Integer num=0;
        for(int i=0; i<this.cost.length; i++) {
            System.out.println(i+"번 노드로 가는 최단 거리 : " + cost[i]);
            num = i;
            System.out.print(i+"번 노드로 가는 최단 경로 : ");
            while (true) {
                System.out.print(path[num] + " ");
                num = path[num];
                if(num==0) {
                    break;
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
