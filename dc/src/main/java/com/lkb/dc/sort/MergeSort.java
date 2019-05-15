package com.lkb.dc.sort;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @Author lkb
 * @CreateDate: 2019/5/15
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] src = {4,7,6,1,2,3,5,8};
        MergeSort sort = new MergeSort();
        sort.mergeSort(src);
        System.out.println(Arrays.toString(src));
    }


    public void mergeSort(int[] src){
        int left = 0;
        int right = src.length-1;
        mergeSort(src, left, right);
    }


    private void mergeSort(int[] src, int left, int right){
        int[] tmp = new int[right+1];
        if(left < right) {
            //先分
            int middle = (right + left) / 2;
            mergeSort(src, left, middle);
            mergeSort(src, middle + 1, right);
            //后治
            merge(src, left, middle, right, tmp);
        }
    }

    private void merge(int[] src, int left, int middle, int right, int[] temp){
        //left-middle   middle+1-right  这两段是有序的
        int i = left;
        int j = middle+1;
        //des数组的下标
        int k = 0;
        while(i<=middle && j<=right){
            if(src[i] <= src[j]){
                temp[k++] = src[i++];
            }else{
                temp[k++] = src[j++];
            }
        }

        //左半部分还有剩余
        while(i<=middle){
            temp[k++] = src[i++];
        }

        //右半部分还有剩余
        while(j<=right){
            temp[k++] = src[j++];
        }

        k=0;
        //将整理好的数据返回给原数组
        for(int t=left; t<=right;){
            src[t++] = temp[k++];
        }
    }

}
