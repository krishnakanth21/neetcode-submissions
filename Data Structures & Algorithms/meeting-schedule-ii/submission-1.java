class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        
        // Sort by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
        // Min heap to track end times of ongoing meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxRooms = 0;
        
        for (Interval meeting : intervals) {
            // Remove all meetings that have ended before current starts
            // (0,8) and (8,10) don't conflict, so use <= not <
            while (!heap.isEmpty() && heap.peek() <= meeting.start) {
                heap.poll();
            }
            
            // Add current meeting's end time
            heap.add(meeting.end);
            
            // Track the maximum number of simultaneous meetings
            maxRooms = Math.max(maxRooms, heap.size());
        }
        
        return maxRooms;
    }
}