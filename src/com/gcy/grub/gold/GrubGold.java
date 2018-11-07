package com.gcy.grub.gold;

import java.util.Arrays;

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

        // println(Math.pow(2,3));
        //testArrayExtends();
        testPermutationAndCombinationOfArray();
    }

    public static boolean testOr1(){
        System.out.println("*********testOr1*********");
        return true;
    }
    public static boolean testOr2(){
        System.out.println("*********testOr2*********");
        return true;
    }

    public static void testArrayExtends(){
        int[] arr = new int[]{1,2,3,4};
        int[] arrAfterExtend = Arrays.copyOf(arr,arr.length+2);
        println(Arrays.toString(arr));
        println(Arrays.toString(arrAfterExtend));
    }

    public static void testPermutationAndCombinationOfArray(){
        Integer[] arr = new Integer[]{1,2,3,4};
        Object[][] resultOfPermutationAndCombination = permutationAndCombinationOfArray(arr);
        for(int i = 0; i < resultOfPermutationAndCombination.length;i++){
            for(int j = 0 ;j < resultOfPermutationAndCombination[i].length;j++){
                System.out.print(resultOfPermutationAndCombination[i][j]+",");
            }
            System.out.println();
        }
        println(Arrays.toString(resultOfPermutationAndCombination));
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


        int arrayLength = objects.length;


        if(arrayLength == 1 ){
            Object[][] results = new Object[1][1];
            results[0] = objects;
            return results;
        }

        Object[][] tempResults = new Object[1][1];
        tempResults[0] = new Object[]{1};

        for(int i = 1; i < objects.length;i++){


            //Object[][] tempResultsNewElements = new Object[tempResults.length+1][];
            //换个方案
            Object[][] tempResultsNewElements = Arrays.copyOf(tempResults,tempResults.length+1);

            //初始化新的元素（请注意：每一个元素是一个数组）
            //最后一个元素不在循环体中初始化，因为它不由之前的数组中的元素变化而得，它是一个新的数组,数组的元素只有一个那就是objects[i]
            for(int j = 0 ; j < tempResultsNewElements.length-1 ; j++){

                //每一个新的元素由之前的数组中的元素经过一定的变化得来——将以前的数组中的元素加一个元素，加的元素恰好是objects[i]

                //由上一句话：每一个新的元素的长度在以前的基础上+1
                /*//（这里必须新建一个Object数组，因为如果）被换方案
                tempResultsNewElements[j] = new Object[tempResults[j].length+1];
                //将之前的数组中的元素复制到新的数组中（深复制）
                System.arraycopy(tempResults[j],0,tempResultsNewElements[j],0,tempResults[j].length);*/

                //换方案，这里可以不用上面那种写法，可以用Arrays.copyOf来扩展数组。
                tempResultsNewElements[j] = Arrays.copyOf(tempResults[j],tempResults[j].length+1);

                //初始化新元素的最后一个元素
                tempResultsNewElements[j][tempResults[j].length] = objects[i];
            }

            tempResultsNewElements[tempResultsNewElements.length-1] = new Object[]{objects[i]};

            //先记下上一个结果数组的长度。
            int lastTempResultsLength = tempResults.length;

            //新的结果的长度为以前的数组的长度*2+1
            tempResults = Arrays.copyOf(tempResults,tempResults.length*2+1);

            System.arraycopy(tempResultsNewElements,0,tempResults,lastTempResultsLength,tempResultsNewElements.length);


        }





      return tempResults;
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
