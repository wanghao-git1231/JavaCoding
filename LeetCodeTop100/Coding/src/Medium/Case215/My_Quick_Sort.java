package Medium.Case215;

//快排
public class My_Quick_Sort {
    public static void quickSort(int[] nums,int l,int r){
        int ll = l,rr = r;
        if(l >= r) return;
        int t = nums[l];
        while (l<r){
            while (l<r&&nums[r]>t) r--;
            if(l<r) {
                nums[l++] = nums[r];
            }

            while (l<r&&nums[l]<t) l++;
            if(l<r){
                nums[r--] = nums[l];

            }

        }
        nums[r] = t;

        for (int i = 0;i < nums.length;i++){
            System.out.print(nums[i]);
        }
        System.out.println();
        quickSort(nums,ll,l-1);
        quickSort(nums,l+1,rr);
    }
}
