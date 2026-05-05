/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Edge case: empty list or single meeting
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }
        
        // Sort by start time
        // Collections.sort() for List (NOT Arrays.sort)
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        // OR: intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        // Check consecutive intervals for overlap
        // Overlap = current.end > next.start
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);  // .get() for List
            Interval curr = intervals.get(i);
            
            // If previous meeting ends AFTER current starts -> OVERLAP
            if (prev.end > curr.start) {
                return false;  // Cannot attend all meetings
            }
        }
        
        return true;  // No overlaps found
    }
}