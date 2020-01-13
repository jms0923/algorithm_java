package StringArray;

import java.util.*;

public class Mergelnterval {
    public static void main(String[] args) {
//        int[][] nums = {{1,4}, {5,6}};
        int[][] nums = {{1,4}, {0, 4}};
//        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        int[][] solved = SolutionArray(nums);
        System.out.println("------");
        for(int[] i:solved){
            for(int j:i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("-------");
        Interval int1 = new Interval(1,3);
        Interval int2 = new Interval(2,6);
        Interval int3 = new Interval(8,10);
        Interval int4 = new Interval(15,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(int1);
        intervals.add(int2);
        intervals.add(int3);
        intervals.add(int4);

        SolutionList solutionList = new SolutionList();
        List<Interval> merged = solutionList.merge(intervals);

        for (int i = 0; i<merged.size(); i++){
            System.out.println(merged.get(i).start + " " + merged.get(i).end);
        }
    }

    private static int[][] SolutionArray(int[][] intervals){
        int size = intervals.length;
        if (size <= 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> solved = new ArrayList<>();
        int[][] before = new int[][]{{intervals[0][0], intervals[0][1]}};
        int[][] current = new int[][]{{intervals[1][0], intervals[1][1]}};

        for(int i = 0; i<size-1; i++){
            current[0] = intervals[i+1];

            if (before[0][1] >= current[0][0]){
                before[0][1] = Math.max(before[0][1], current[0][1]);
            }
            else {
                solved.add(new int[]{before[0][0], before[0][1]});
                before[0] = current[0];
            }
        }
        solved.add(new int[]{before[0][0], before[0][1]});

        return solved.toArray(new int[solved.size()][1]);
    }
}

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class SolutionList {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1) return intervals;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> solved = new ArrayList<>();
        Interval before = intervals.get(0);
        Interval current;

        for(int i = 0; i<size-1; i++){
            current = intervals.get(i+1);

            if (before.end >= current.start){
                before.end = Math.max(before.end, current.end);
            }
            else {
                solved.add(before);
                before = current;
            }
        }
        solved.add(before);

        return solved;
    }
}