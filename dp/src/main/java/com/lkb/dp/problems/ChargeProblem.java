package com.lkb.dp.problems;

import java.util.Arrays;

/**
 * @Description 硬币找零问题
 * 假设只有 1角，2角，5角，1元的硬币，
 * 在超市结账时，如果需要找零钱，收银员希望将最少的硬币数找给顾客。那么，给定需要找的零钱数目，如何求得最少的硬币数呢？
 * @Author lkb
 * @CreateDate: 2019/6/1
 */
public class ChargeProblem {

    public static void main(String[] args) {
        int[] coinsValues = {1,2,5,10};
        Arrays.sort(coinsValues);
        int n = 6;
        int minCoinsNumber = charge(coinsValues, n);
        System.out.println(minCoinsNumber);
    }


    /**
     * 功能描述: 硬币找零问题
     * @author lkb
     * @date 2019/6/1
     * @param
     * @return int
     */
    public static int charge(int[] coinKind, int money){
        //这个数组保存最优解
        //例如  value[2][5] 表示 使用 coinKind[0] coinKind[1] coinKind[2] 找零 money = 5 的最优解
        int[][] value = new int[coinKind.length+1][money+1];

        //边界条件1：如果硬币类型为0，则永远找不到合适的硬币找零 、
        // 这里设置为最大值是因为我们后续比较使用
        for(int i=0; i<=money; i++){
            value[0][i] = Integer.MAX_VALUE;
        }
        //边界条件2：如果钱为0，则永远找不到合适的硬币找零
        for(int i=0; i<=coinKind.length; i++){
            value[i][0] = 0;
        }

        for(int mon=1; mon<=money; mon++){
            for(int kind=1; kind<=coinKind.length; kind++){
                //边界条件2：如果硬币金额大于钱，则最优解是 上一步的最优解
                if(coinKind[kind-1] > mon){
                    value[kind][mon] = value[kind-1][mon];
                    continue;
                }

                //当前最优解分为两种情况，需要在下面两种情况选择一种解最小的情况
                //一个是使用了当前类型的硬币，value[kind][mon - coinKind[kind-1]] + 1
                // 一个是没有使用当前类型的硬币, value[kind-1][mon]
                if((value[kind][mon - coinKind[kind-1]] + 1) < value[kind-1][mon]){
                    value[kind][mon] = value[kind][mon - coinKind[kind-1]] + 1;
                }else{
                    value[kind][mon] = value[kind-1][mon];
                }
            }
        }

        return value[coinKind.length][money];
    }


}
