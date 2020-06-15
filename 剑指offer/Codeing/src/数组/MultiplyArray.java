package 数组;

/***************************
 * 剑指offer:构建乘积数组
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 思路：
 *      1.双重循环
 *      2.B[i]=A[0]A[1]....A[i-1]A[i+1]....A[n-1]。看成A[0]A[1].....A[i-1]和A[i+1].....A[n-2]A[n-1]两部分的乘积
 **************************/

public class MultiplyArray {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] multiply = multiply(a);
        for (int i = 0; i < multiply.length; i++) {
            System.out.println(multiply[i]);
        }
    }

    //两部分乘积
    public static int[] multiply(int[] A) {
        if(A == null) return new int[0];
        int[] B = new int[A.length];
        int res = 1;

        //A[0]A[1].....A[i-1]
        for (int i = 0; i < B.length; i++) {
            B[i] = res;
            res *= A[i];
        }
        res = 1;
        //A[i+1].....A[n-2]A[n-1]
        for(int i = A.length-1;i>=0;i--){
            B[i] *= res;
            res *= A[i];
        }
        return B;
    }

    //双重循环版
    public static int[] multiply2(int[] A) {
        if(A == null) return new int[0];
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        for(int i = 0;i<A.length;i++){
            for (int j = 0; j < B.length; j++) {
                if(j == i) continue;
                B[j] *= A[i];
            }
        }
        return B;
    }

}
