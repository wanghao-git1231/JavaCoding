package Easy.Case461;

/****************************
 * LeetCode 461：汉明距离
 * 题目描述：
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 思路：
 *      思路1:模拟整数转二进制，比较对应为是否相同，注意一个结束后另一个还在继续
 *      思路2：先按位异或，其中一的个数即是不同的位置数目，除以2取余，每次向右移动一位，直至为0
 *      思路3：布赖恩·克尼根算法，按位异或的结果，与减一结果按位或直至0的次数，即是1的个数
 ****************************/

public class HammingDistance {
    public static void main(String[] args) {
        int i = hammingDistance3(1, 4);
        System.out.println(i);
    }

    //布赖恩·克尼根算法,按位异或的结果，与减一的值或，直至等于0，或的次数就是1的个数，极快
    public static int hammingDistance3(int x,int y){
        int xor = x^y;
        int res = 0;
        while (xor!=0){
            res++;
            xor = xor&(xor - 1);
        }

        return res;
    }
    //先位运算，先按位异或，在判断是否能被二整除，然后向右移动一位，直至为0
    public static int hammingDistance2(int x,int y){
        int xor = x^y;
        int res = 0;
        while (xor!=0){
            if(xor%2 == 1) res++;
            xor = xor>>1;
        }
        return res;
    }

    public static int hammingDistance1(int x, int y) {
        int res = 0;
        int a = 0,b = 0;
        while (x!=0||y!=0){
            a = x%2;
            b = y%2;

            if(a!=b) res++;

            if(x == 1) x = 0;
            else x /= 2;
            if(y == 1) y =0;
            else y /=2;
        }

        return res;
    }
}
