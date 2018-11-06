package com.gcy.grub.gold;

/**
 * 题目：
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数量也不同。参与挖掘的工人总数是10。
 * 每座金矿要么全挖，要么不挖，不能派出一半的人挖取一半金矿。
 * 想要得到尽可能多的黄金，应该选择挖取那几座金矿进行挖掘。
 *
 *
 * 五座金矿——1：500金/5人，2：200金/3人，3：300金/4人，4:350金/3人，5:400金/5人
 *
 *
 */
public class GrubGold {


    public static void main(String args[]){
       /* if(testOr1() || testOr2()){
            System.out.println("hello");
        }*/

        println(Math.pow(2,3));
    }

    public static boolean testOr1(){
        System.out.println("*********testOr1*********");
        return true;
    }
    public static boolean testOr2(){
        System.out.println("*********testOr2*********");
        return true;
    }

    /**
     * 计算出应该选择哪几座金矿进行挖掘
     * @param goldOres 金矿情况
     * @param totalNumberOfWorker  工人总数
     * @return 最终应该选择的金矿
     */
    public static Result getMostGoldMethod(GoldOre[] goldOres,int totalNumberOfWorker){

        //0.如果没有金矿。
        if(goldOres == null || goldOres.length == 0 ){
            println("**********没有金矿，计算个屁！***************");
            return null;
        }


        //所有金矿所需的工人数
        int needTotalNumberOfWorker = 0;

        //所有金矿里面的黄金储量
        int amountOfGoldInAllGoldOre = 0;

        //所需工人数最少的金矿所需的工人数
        int minNeedNumberOfWorker = goldOres[0].getNeedNumberOfWorker();

        //所需工人数最多的金矿所需的工人数
        int maxNeedNumberOfWorker  = goldOres[0].getNeedNumberOfWorker();

        for (GoldOre goldOre : goldOres) {

            needTotalNumberOfWorker += goldOre.getGoldReserves();
            amountOfGoldInAllGoldOre += goldOre.getGoldReserves();
            int needNumberOfWorker =  goldOre.getNeedNumberOfWorker();

            if( needNumberOfWorker < minNeedNumberOfWorker ){
                minNeedNumberOfWorker = needNumberOfWorker;
            }

            if( needNumberOfWorker > maxNeedNumberOfWorker){
                maxNeedNumberOfWorker = needNumberOfWorker;
            }

        }

        //1.如果需要工人数最少的金矿所需的工人数 大于 给定的工人总数
        if(minNeedNumberOfWorker > totalNumberOfWorker){
            println("**********工人总数不够挖任何一座金矿****************");
            return null;
        }

        //2.如果所有金矿所需的人数小于等于工人总数
        if(needTotalNumberOfWorker <= totalNumberOfWorker){

            Result result = new Result(amountOfGoldInAllGoldOre,goldOres);
            return result;

        }

        //3.排除以上3种情况，如果给定的工人总数在能挖其中几座金矿，但又不足以挖出所有的金矿。
        //首先排除集结所有工人都不能挖的金矿。现在假设已经排除。

        /**
         * 算法：（1）.列出所有的情况，比较大小。
         *
         * 先选定一座要挖的。
         */
        /*GoldOre[] resultGoldOres = new GoldOre[1];
        resultGoldOres[0] = goldOres[0];*/
        for(int i=0;i<goldOres.length;i++){

        }

        /**
         * 写一个算法，传一个数组，列出这个数组的所有排列组合情况。
         *
         */



        return null;


    }

    /**
     * 数组排列组合。传入一个数组，返回这个数组的排列组合。数组元素要么选，要么不选。
     * @param objects
     * @return
     */
    private static Object[][] permutationAndCombinationOfArray(Object[] objects){

        int resultLength = (int)Math.pow(2,objects.length);

        Object[][]  result = new Object[resultLength][];

        for(int i = 0 ; i < result.length; i++){
            result[i] = objects;
        }

        for(int i= 0 ; i < objects.length ; i++ ){

        }



        return null;
    }
    private static void println(Object object){
        System.out.println(object);
    }
    /**
     * 计算结果类。
     */
    private static class Result{
        private int amountOfGold;//黄金量
        private GoldOre[] goldOres;//选择的金矿

        public Result() {
        }

        public Result(int amountOfGold, GoldOre[] goldOres) {
            this.amountOfGold = amountOfGold;
            this.goldOres = goldOres;
        }

        public int getAmountOfGold() {
            return amountOfGold;
        }

        public void setAmountOfGold(int amountOfGold) {
            this.amountOfGold = amountOfGold;
        }

        public GoldOre[] getGoldOres() {
            return goldOres;
        }

        public void setGoldOres(GoldOre[] goldOres) {
            this.goldOres = goldOres;
        }


    }



}
