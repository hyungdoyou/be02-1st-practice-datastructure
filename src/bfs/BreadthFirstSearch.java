package bfs;

import java.util.*;

public class BreadthFirstSearch {
    // 너비 우선 탐색

    public void search(ArrayList<ArrayList<Integer>> arrayList, Integer start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start); // 시작점을 넣으면 시작점의 리스트로 이동
        ArrayList<Integer> visitNum = new ArrayList<>();
        visitNum.add(start);

        System.out.print("탐색 순서 : " + start + " ");
        while (!queue.isEmpty()) {
            int i = 0;

            while (i < arrayList.get(start).size()) {
                Integer num = arrayList.get(start).get(i);
                if (i == arrayList.get(start).size() - 1) {
                    if (!queue.contains(num) && !visitNum.contains(num)) {
                        queue.add(num);
                        visitNum.add(num);
                        System.out.print(num + " ");
                        queue.remove();
                        start = queue.peek();
                        break;
                    } else {
                        queue.remove();
                        start = queue.peek();
                        break;
                    }
                }
                if (!queue.contains(num) && !visitNum.contains(num)) {
                    queue.add(num);
                    visitNum.add(num);
                    System.out.print(num + " ");
                    break;
                } else {
                    i = i+1;
                }
            }
        }
    }
}
