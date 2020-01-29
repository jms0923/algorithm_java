package StringArray;

import java.util.*;

public class MeetingRooms2 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

       Interval int1 = new Interval(0, 30);
       Interval int2 = new Interval(5, 10);
       Interval int3 = new Interval(15, 20);

       intervals.add(int1);
       intervals.add(int2);
       intervals.add(int3);

       System.out.println(minMeetingRooms(intervals));
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    private static int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1) return size;

        intervals.sort((o1, o2) -> o1.start - o2.start);

        Queue<Interval> heap = new PriorityQueue<Interval>((o1, o2) -> o1.end - o2.end);
        heap.offer(intervals.get(0));

        Interval tempInterval = null;
        for(int i = 1; i < size; i++){
            tempInterval = heap.poll();
            if (tempInterval.end < intervals.get(i).start){
                tempInterval.end = intervals.get(i).end;
            }
            else {
                heap.offer(intervals.get(i));
            }
            heap.offer(tempInterval);
        }
        return heap.size();
    }
}
