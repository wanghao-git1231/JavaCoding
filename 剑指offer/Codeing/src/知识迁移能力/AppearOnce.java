package 知识迁移能力;

import java.util.ArrayList;

/*********************************
 *剑指offer:数组中值出现一次的数字
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路:
 *      使用ArrayList，不断移除重复的，最后剩下的就是没有重复的
 ********************************/


public class AppearOnce {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,4,6};
        int res1[] = new int[1];
        int res2[] = new int[1];
        FindNumsAppearOnce(nums,res1,res2);
        System.out.println(res1[0]+" "+res2[0]);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 0||array.length == 1) return;
        if(array.length == 2&&array[0]==array[1]) return;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i<array.length;i++){
                arrayList.add(array[i]);
        }

        int index = 0;//从第一个开始比价后面后没有重复
        boolean isRepeat = false; //标记当前index位置是否重复
        //
        while (arrayList.size()!=2){

            int temp = arrayList.get(index);
            for (int i = index+1; i < arrayList.size(); ) {
                //如果相同则移除并标记当前值为重复
                if(arrayList.get(i) == temp){
                    arrayList.remove(i);//由于删除的当前位，所以i不需要加
                    isRepeat = true;
                }else {
                    //当前位置不与index重复，指向下一个
                    i++;
                }

            }

            //如果重复删除当前值
            if(isRepeat == true){
                arrayList.remove(index);
                isRepeat = false;
                if(arrayList.size() == 2) break;
            }else {
                //当前位置不是重复，判断下一个是否重复
                if(index == 1) break;
                index++;

            }


        }

        num1[0]=arrayList.get(0);
        num2[0] = arrayList.get(1);

    }

}
