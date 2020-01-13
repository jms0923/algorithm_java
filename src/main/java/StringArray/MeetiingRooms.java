package StringArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//Definition of Interval:
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetiingRooms {

    public static void main(String[] args) {

        Interval in1 = new Interval(465,497);
        Interval in2 = new Interval(386,462);
        Interval in3 = new Interval(354,380);
        Interval in4 = new Interval(134,189);
        Interval in5 = new Interval(199,282);
        Interval in6 = new Interval(18,104);
        Interval in7 = new Interval(499,562);
        Interval in8 = new Interval(4,14);
        Interval in9 = new Interval(111,129);
        Interval in10 = new Interval(292,345);


        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        intervals.add(in5);
        intervals.add(in6);
        intervals.add(in7);
        intervals.add(in8);
        intervals.add(in9);
        intervals.add(in10);


//        Interval[] intervals = {in1, in2,in3};

        System.out.println(canAttendMeetings(intervals));
    }


    public static boolean canAttendMeetings(List<Interval> intervals) {
        /**
         * @param intervals: an array of meeting time intervals
         * @return: if a person could attend all meetings
         */
        // Write your code here
        if(intervals == null) return false;

        intervals.sort(Comp);

//        Arrays.sort(intervals, Comp);
        for(int i=0; i<intervals.size()-1; i++){
            if(intervals.get(i).end > intervals.get(i + 1).start){
                return false;
            }
        }

        return true;
    }

    static Comparator<Interval> Comp = new Comparator<Interval>(){

        @Override
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };

}
