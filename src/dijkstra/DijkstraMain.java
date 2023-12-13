package dijkstra;

import java.util.*;

public class DijkstraMain {
    public static void main(String[] args) {
        List<Integer> arrayList0 = Arrays.asList(0,1,8);
        List<Integer> arrayList1 = Arrays.asList(0,3,7);
        List<Integer> arrayList2 = Arrays.asList(0,4,2);
        List<Integer> arrayList3 = Arrays.asList(1,5,1);
        List<Integer> arrayList5 = Arrays.asList(3,5,8);
        List<Integer> arrayList6 = Arrays.asList(3,7,9);
        List<Integer> arrayList7 = Arrays.asList(4,6,2);
        List<Integer> arrayList8 = Arrays.asList(5,7,4);
        List<Integer> arrayList4 = Arrays.asList(6,2,7);
        List<Integer> arrayList9 = Arrays.asList(6,7,5);

        List<List<Integer>> totalArrayList = new ArrayList<>();
        totalArrayList.add(arrayList0);
        totalArrayList.add(arrayList1);
        totalArrayList.add(arrayList2);
        totalArrayList.add(arrayList3);
        totalArrayList.add(arrayList4);
        totalArrayList.add(arrayList5);
        totalArrayList.add(arrayList6);
        totalArrayList.add(arrayList7);
        totalArrayList.add(arrayList8);
        totalArrayList.add(arrayList9);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.findShortestPath(totalArrayList, 8, 0);

        dijkstra.print();
    }
}
