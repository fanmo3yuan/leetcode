package fanmo.leetcode.algorithms;

import java.util.Arrays;


public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] res = new int[n][2];
        boolean[] flag = new boolean[n];

        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0]));

        for (int i = 0; i < n; i++) {
            int height = people[i][0];
            int pos = people[i][1] + 1;
            for (int j = 0; j < n; j++) {
                if (!flag[j] || res[j][0] >= height) {
                    pos--;
                }
                if (pos == 0) {
                    res[j][0] = height;
                    res[j][1] = people[i][1];
                    flag[j] = true;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight qh = new QueueReconstructionByHeight();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        qh.reconstructQueue(people);
    }

}
