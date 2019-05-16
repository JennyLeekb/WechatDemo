package com.lkb.dc.search;

/**
 * @Description 二分查找
 * @Author lkb
 * @CreateDate: 2019/5/16
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] src = {1,4,5,7,9,10,16,19,26};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch(src,0, src.length - 1, 16);
        System.out.println(index);
    }



    public int binarySearch(int[] src, int left, int right, int x) {
        //出口
        if(left > right){
            return -1;
        }

        int middle = (left + right) / 2 ;
        if(src[middle] == x){
            return middle;
        }
        else if(src[middle] > x){
            //左边
            return binarySearch(src,left,middle,x);
        }
        else{
            //右边
            return  binarySearch(src,middle+1,right,x);
        }
    }


}
