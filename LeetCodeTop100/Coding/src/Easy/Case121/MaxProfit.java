package Easy.Case121;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[] b = {7,6,5,4,3,2,1};
        int i = maxProfit(b);
        System.out.println(i);
    }

    //使用变量存储最大值差，最小价格
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxP = 0,minP = prices[0];
        for (int i = 1;i < prices.length;i++){
            if(prices[i] - minP>maxP) maxP = prices[i] - minP;
            if(prices[i] < minP) minP = prices[i];
        }
        return maxP;
    }
}
