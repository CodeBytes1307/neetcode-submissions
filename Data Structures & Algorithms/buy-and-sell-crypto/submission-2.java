class Solution {
    public int maxProfit(int[] prices) {
        int maxpro=0;
        int l=0;
        int r=1;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                int pro=prices[r]-prices[l];
                maxpro=Math.max(pro,maxpro);
            }
            else{
                l=r;
            }
            r++;
        }
        return maxpro;
        
        
    }
}
