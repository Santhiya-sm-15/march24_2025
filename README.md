# march24_2025
The problem that i solved today in leetcode

1.You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

Code:
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int[] prev=meetings[0];
        List<int[]> l=new ArrayList<>();
        for(int i=1;i<meetings.length;i++)
        {
            if(prev[1]>=meetings[i][0])
                prev[1]=Math.max(prev[1],meetings[i][1]);
            else
            {
                l.add(prev);
                prev=meetings[i];
            }
        }
        l.add(prev);
        int p=0,cnt=0;
        for(int i=0;i<l.size();i++)
        {
            cnt+=l.get(i)[0]-p-1;
            p=l.get(i)[1];
        }
        cnt+=days-l.get(l.size()-1)[1];
        return cnt;
    }
}
