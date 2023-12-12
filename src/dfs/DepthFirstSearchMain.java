package dfs;

import java.util.ArrayList;

public class DepthFirstSearchMain {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        // ArrayList<Integer> arrayList1 = Arrays.asList(1,3,4);
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(3);
        arrayList1.add(4);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(0);
        arrayList2.add(2);

        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(1);
        arrayList3.add(3);

        ArrayList<Integer> arrayList4 = new ArrayList<>();
        arrayList4.add(0);
        arrayList4.add(2);
        arrayList4.add(4);

        ArrayList<Integer> arrayList5 = new ArrayList<>();
        arrayList5.add(0);
        arrayList5.add(3);

        arrayList.add(arrayList1);
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        arrayList.add(arrayList4);
        arrayList.add(arrayList5);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search(arrayList, 0);

    }
}
