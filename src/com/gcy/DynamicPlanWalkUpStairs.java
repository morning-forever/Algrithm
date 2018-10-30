package com.gcy;

/**
 * 动态规划走阶梯
 * 有一个高度为10个台阶的楼梯，从底往上走，每一步只能走1个台阶或2个台阶，要求用程序求出走到第10层共有多少种方式。
 *
 */
public class DynamicPlanWalkUpStairs {

    public static void main(String args[]){

        DynamicPlanWalkUpStairs dp = new DynamicPlanWalkUpStairs();

        dp.println("*********************f(10) ="+dp.f(10));
        dp.println("*********************f1(10)="+dp.f1(10));
        dp.println("*********************f2(10)="+dp.f2(10));
    }

    /**
     *
     * 首先：过程是怎么走的？然后假设只剩最后一步就走完了
     *
     *一、自顶向下思考问题，自底向上求解问题
     *
     * 1.假设只剩最后一步就走完了，那么现在的情况就只有两种：（1）已经走到第8个台阶。（2）已经走到第9个台阶。
     *
     * 2.所以，假设把走完n个台阶的所有方法定义为F(n),那么F(10) = F(9)+F(8)
     *
     * 3.同理F(9) = F(8) + F(7),F(8) = F(7)+F(6)...,F(3) = F(2)+F(1)
     *
     * 4.  F(2) = 2,F(1) = 1
     *
     * ==============================================
     *
     * @return
     *
     *
     */
    public  int f(int n){

        if( n == 1){
            return 1;
        }

        if( n == 2 ){
            return 2;
        }

        return f(n-1)+f(n-2);

    }


    /**
     * 减少时间复杂度，上面的方法存在重叠子问题，例如求F(3) 和 F(4)时都会执行F(2)
     * @param n
     * @return
     */
    public int  f1(int n ){

        if( n <= 0){
            return 0;
        }

        int[]  resultList = new int[n];

        resultList[0] = 1;
        resultList[1] = 2;
        for(int i = 2; i < n ; i++ ){
           resultList[i] = resultList[i-2] + resultList[i-1];
        }

       return   resultList[n-1];
    }

    /**
     * 减少空间复杂度，因为只需求得最终结果，中间的结果求出来、使用过之后就可以扔了。
     * @param n
     * @return
     */
    public int  f2(int n ){

        if(n <= 0){
            return 0;
        }

        if( n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

       int a = 1 ,b = 2;
       int temp = 0;

       for(int i = 3; i <= n ; i++ ){
           temp = a + b;
           a = b;
           b = temp;
       }

       return temp;
    }
    public void println(Object obj){
        System.out.println(obj);
    }

}
