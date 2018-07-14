class Solution {
    public int maxDistToClosest(int[] seats) {
        int count=0;
        int max=Integer.MIN_VALUE;
        int start=0;
        int flag=0;
        for(int i=0; i<seats.length; i++) {
            if(seats[i]==0) {
                count++;
                if(flag==0) start++;
            }
            else{
                flag=1;
                max=Math.max(max,count);
                count=0;
            }
        }
        max=(max%2==0)?max/2:max/2+1;
        return Math.max(start, Math.max(max, count));
    }
}
