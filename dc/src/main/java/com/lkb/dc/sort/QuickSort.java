package com.lkb.dc.sort;


import java.util.Arrays;

/**
 * @Description 快速排序
 * @Author lkb
 * @CreateDate: 2019/5/15
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] src = {4,7,6,1,2,3,5,8};
        QuickSort sort = new QuickSort();
        sort.quickSort(src);
        System.out.println(Arrays.toString(src));
    }


    public void quickSort(int[] src){
        quickSort(0,src.length-1,src);
    }


    private void quickSort(int left, int right, int[] src){
        //返回条件
        if((right -left) <= 1){
            return;
        }

        //基准值
        int cursor = src[left];
        int i = left;
        int j = right;
        while(i<j){
            //右边的数都要比基准数大
            while(i<j && src[j] > cursor){
                j--;
            }

            if(i<j){
                src[i++] = src[j];
            }

            //左边的数都要比基准数小
            while(i<j && src[i] < cursor){
                i++;
            }

            if(i<j){
              src[j--] = src[i];
            }
        }

        src[i] = cursor;
        quickSort(left, i-1, src);
        quickSort(i+1, right, src);
    }

}



