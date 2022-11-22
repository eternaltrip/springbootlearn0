package com.yj.demo02;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo02ApplicationTests {

    @Test
    void contextLoads() {
    }



    public static void main(String[] args) {
        int[] arr = {10,7,2,4,9,62,33,45,21,3,6,11,16,55};
        quickSort(arr, 0, arr.length-1);

    }

 public static void quickSort(int[] arr,int low,int high){
     for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] +",");
     }
     System.out.println();

             int i,j,temp,t;
             if(low>high){
                 return;
                 }
             i=low;
             j=high;
             //temp就是基准位
             temp = arr[low];

             while (i<j) {
                 //先看右边，依次往左递减
                 while (temp<=arr[j]&&i<j) {
                     j--;
                    }
                 //再看左边，依次往右递增
                 while (temp>=arr[i]&&i<j) {
                     i++;
                     }
                 //如果满⾜条件则交换
                 if (i<j) {
                     t = arr[j];
                     arr[j] = arr[i];
                     arr[i] = t;
                     }

                 }
             //最后将基准为与i和j相等位置的数字交换
             arr[low] = arr[i];
             arr[i] = temp;
             //递归调⽤左半数组
             quickSort(arr, low, j-1);
             //递归调⽤右半数组
             quickSort(arr, j+1, high);
 }

}
