package 代码的完整性;

/************************
 * 剑指offer:调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 ***********************/


public class ReOrderArray {
    public static void main(String[] args) {
        int[] a = {1,5,6,8,3,7,2,9};
        reOrder(a);
    }

    public static void reOrder(int [] array) {
        int indexOfOdd = -1,indexOfEven = -1;//奇数，偶数位置
        int len = array.length;
        for(int i = 0;i< len;){
            if(array[i]%2 == 1 && indexOfOdd < indexOfEven){//有奇数在偶数后面，应将该奇数向前移动
                indexOfOdd = i;
            }
            if(array[i]%2 == 0&& indexOfEven == -1){ //找到第一个偶数的位置
                indexOfEven = i;
            }
            //将奇数挪到偶数前
            if(indexOfEven != -1 &&indexOfOdd != -1){
                int temp  = 0,index = indexOfOdd;
                temp = array[index];
                while (indexOfEven != index){
                    array[index] = array[--index];
                }
                array[index] = temp;
                indexOfEven = index+1; //刷新第一个偶数位置
                i = indexOfOdd;
                indexOfOdd = -1;
            }
            i++;
        }

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

    /*
    不让用栈
    public static void reOrder2(int [] array) {
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for(int i = 0;i < array.length;i++){
            if(array[i]%2 == 1){ //奇数
                odd.push(array[i]);
            }else {
                even.push(array[i]);
            }
        }
        int i = array.length-1;
        while (!even.empty()){
            array[i--] = even.peek();
            even.pop();
        }
        while (!odd.empty()){
            array[i--] = odd.peek();
            odd.pop();
        }
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

    }*/
}
