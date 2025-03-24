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