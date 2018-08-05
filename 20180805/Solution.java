class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) return 0;
        String s = str.trim().split(" ")[0];
        // is number?
        String ss;
        if(s.charAt(0)=='-'|| s.charAt(0)=='+') {
            ss = s.substring(1,s.length());
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if(pattern.match(ss)){
           Long l = Long.parseLong(ss);
            if(l>Integer.MAX_VALUE) {
                return Math.power(2,31) -1;
            } else if(l < Integer.MIN_VALUE) {
                return -Math.power(2,31);
            }else if(){
                return Integer.parseInt(l);
            }
        }else {
            return 0;
        }


    }
}
