package com.lkb.dp.problems.pack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 背包问题
 * @Author lkb
 * @CreateDate: 2019/6/3
 */
public class PackageProblem {


    public static void main(String[] args) {
        Goods[] goods = getGoods();
//        int maxValue = packDP(goods,3);
        int maxValue = pack(goods,3);
        System.out.println(maxValue);
    }


    /**
     * 功能描述: 假设你有一个重量为packWeight的背包，商场有的商品为goods，
     * 你需要挑选一些商品使得背包中装的东西的价值最高
     * 假设不可以重复选择商品
     * @author lkb
     * @date 2019/6/3
     * @param goods 商品的信息
     * @param packWeight 背包重量
     * @return java.util.List<com.lkb.dp.problems.pack.Goods>
     */
    public static int pack(Goods[] goods, int packWeight){
        int maxValue = 0;
        Map<Integer,List<Goods>> map = new HashMap<>();
        for(int i=0;i<goods.length;i++){
            int weight = packWeight - goods[i].getWeight();
            int value = goods[i].getValue();
            for(int j=0;j<goods.length;j++) {
                //只要背包的容量够，我们就应该尝试选择这个物品
                //后续再比较最大值
                if (weight - goods[j].getWeight() >= 0) {
                    value = goods[j].getValue() + value;
                    weight = weight - goods[j].getWeight();
                }
            }
            if(maxValue < value){
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * 功能描述: 假设你有一个重量为packWeight的背包，商场有的商品为goods，
     * 你需要挑选一些商品使得背包中装的东西的价值最高
     * 假设不可以重复选择商品
     * @author lkb
     * @date 2019/6/3
     * @param goods 商品的信息
     * @param packWeight 背包重量
     * @return java.util.List<com.lkb.dp.problems.pack.Goods>
     */
    public static int packDP(Goods[] goods, int packWeight){
        int[][] value = new int[goods.length + 1][packWeight + 1];

        //背包的容量为0
        for(int i=0;i<goods.length + 1;i++){
            value[i][0] = 0;
        }
        //没有商品
        for(int i=0;i<packWeight+1;i++){
            value[0][i] = 0;
        }

        for(int weight=1; weight<packWeight+1; weight++){
            for(int good=1; good<goods.length + 1; good++){
                //商品的重量大于背包的容量
                if(goods[good-1].getWeight() > weight){
                    value[good][weight] = value[good-1][weight];
                    continue;
                }
                if(weight - goods[good-1].getWeight() >= 0){
                    if((value[good][weight - goods[good-1].getWeight()] + goods[good-1].getValue()) > value[good-1][weight] ){
                        //选择当前物品的价值大于不选择当前物品的价值
                        value[good][weight] = value[good][weight - goods[good-1].getWeight()] + goods[good-1].getValue();
                    }else{
                        //选择当前物品的价值小于不选择当前物品的价值
                        value[good][weight] =  value[good-1][weight];
                    }
                }
            }
        }
        return value[goods.length][packWeight];
    }


    private static Goods[] getGoods(){
        Goods good1 = new Goods();
        good1.setId(1);
        good1.setName("音响");
        good1.setValue(3000);
        good1.setWeight(3);

        Goods good2 = new Goods();
        good2.setId(2);
        good2.setName("PC");
        good2.setValue(4000);
        good2.setWeight(2);

        Goods good3 = new Goods();
        good3.setId(3);
        good3.setName("吉他");
        good3.setValue(1500);
        good3.setWeight(2);

        Goods good4 = new Goods();
        good4.setId(4);
        good4.setName("iPod");
        good4.setValue(1400);
        good4.setWeight(1);

        Goods[] goods= {good1,good2,good3,good4};
        return goods;
    }


}
