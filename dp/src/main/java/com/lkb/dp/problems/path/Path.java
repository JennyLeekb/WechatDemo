package com.lkb.dp.problems.path;

/**
 * @Description 最短路径
 * @Author lkb
 * @CreateDate: 2019/6/17
 */
public class Path {


    private static final int MAX = 1000;

    public static void main(String[] args) {
        int[][] graph = {
                {MAX, 25, 10, 60},
                {MAX,MAX,MAX,20},
                {MAX,MAX,MAX,20},
                {MAX,MAX,MAX,MAX}
        };

        int[] cost = path(graph);
        for(int i=0; i<cost.length; i++){
            System.out.print(cost[i] + " ");
        }
        System.out.println();
    }


    public static int[] path(int [][]graph){
        int n = graph[0].length;
        int[] path = new int[n];

        //初始化 path 数组
        for(int i=0; i<n; i++){
            if(i == 0){
                path[i] = MAX;
                continue;
            }
            path[i] = graph[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                //比较经过中转 i 和 不经过中转点 i 的大小
                if(path[i]+graph[i][j] < path[j]){
                    path[j] = path[i]+graph[i][j];
                }
            }
        }
        return path;
    }


}
