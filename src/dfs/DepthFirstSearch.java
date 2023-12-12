package dfs;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
    public void search(ArrayList<ArrayList<Integer>> arrayList, Integer start) {
        Stack<Integer> stack = new Stack<>();

        Integer index = 0;
        stack.push(start);  // 시작점을 넣으면 시작점의 리스트로 이동
        ArrayList<Integer> visitNum = new ArrayList<>();

        System.out.print("탐색 순서 : " + start + " ");
        while (!stack.empty()) {
            int i = 0;

            while(i < arrayList.get(start).size() && index > -1) {
                Integer min = arrayList.get(start).get(i);
                if(i == arrayList.get(start).size()-1) {
                    if(!stack.contains(min) && !visitNum.contains(min)) {
                        stack.push(min);
                        index++;
                        System.out.print(min + " ");
                        start = min;
                        break;
                    } else {
                        visitNum.add(stack.pop());
                        index = index - 1;
                        if(index > -1) {
                            start = stack.get(index);
                        } else {
                            break;
                        }
                    }
                }
                if(!stack.contains(min) && !visitNum.contains(min)) {
                    stack.push(min);
                    start = min;
                    index++;
                    System.out.print(min + " ");
                    break;
                } else {
                    i = i+1;
                }
            }
        }










    }
}
