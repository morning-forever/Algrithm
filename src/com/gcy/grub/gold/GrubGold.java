package com.gcy.grub.gold;


import java.lang.reflect.Array;
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
 *PAXOS
 */
public class GrubGold {


    public static void main(String args[]) {
        /*if(testOr1() || testOr2()){
            System.out.println("hello");
        }*/



        // println(Math.pow(2,3));
        //testArrayExtends();

           // Method method = GrubGold.class.getDeclaredMethod("testOr1",null);

           // System.out.println(method.getName());

        /*Integer[][] hello = (Integer[][]) new Object[1][1];//Exception in thread "main" java.lang.ClassCastException: [[Ljava.lang.Object; cannot be cast to [[Ljava.lang.Integer;
        hello[0] = new Integer[]{0};


        System.out.println(hello[0][0]);


        Object obj = new Integer(1);
        Integer integer = (Integer) obj;
        System.out.println(integer);*/

       /* Object[] objects = new Integer[]{0};
        Integer[] integers = (Integer[]) objects;
        System.out.println(integers[0]);*/

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
        Integer[][] results = new Integer[1][1];

        results = permutationAndCombinationOfArray(arr);

        for(int i = 0 ; i < results.length ; i++){
            println(Arrays.toString(results[i]));
        }
        println(Arrays.toString(results));//Arrays.toString()方法只能打出一维数组。
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
        for(int i=0;i<goldOres.length;i++){

        }

        /**
         * 写一个算法，传一个数组，列出这个数组的所有排列组合情况。
         */
        return null;
    }
    /**
     *
     * @param ts
     * @param <T> 数组元素的类型。
     * @return
     */
    private static <T> T[][] permutationAndCombinationOfArray(T[] ts){

        T[][] results = (T[][])Array.newInstance(ts.getClass(),1);

        //不进行下面的初始化，在给results的第一个元素的第一个元素赋值的时候会包NullPointerException。
        results[0] = (T[]) Array.newInstance(ts.getClass().getComponentType(),1);

        results[0][0] = ts[0];
        int arrayLength = ts.length;

        results[0][0] = ts[0];

        if(arrayLength == 1 ){
            return results;
        }



        // 为什么从i=1开始？
        // 答：我要算出，用给定数组中的元素，进行组合，“所能产生的所有可能组合”，怎么算呢？
        // 分析：我先算出，用给定数组中的第一个元素，进行组合，“所能产生的所有可能组合”，这个很好算吧！其实就只有一种组合，那就是第一个元素。
        // 我得到用第一个元素进行组合所能产生的所有可能组合之后，我很容易得到用第一、二个元素进行组合所能产生的所有可能组合。可以这么想问题：
        // 我现在无非是加了一个可以拿来进行组合的元素——第二个元素，新加的这个元素在组合时，有两种选择，要么要，要么不要，
        // 如果不要，那就能产生加进来之前的那些所有可能组合。如果要，那就会产生一些新的组合，这些新的组合是，
        // 之前的那些所有组合中，每一个组合再加上加进来的这个元素所产生的所有新组合 + 这个元素自己所组成的组合。
        // 用数学语言来描述试试：
        // 假设我有一个数组A,数组中的元素是A[0],A[1],A[2],A[3],A[4],A[5],...,A[n],
        // 求：从数组A的元素——A[0]到A[n]中，选取任意个（>1个）元素组成新的数组B,列出所有可能的B，用二维数组BS表示。
        // 分析：先把问题简单化，假设数组A中只有一个元素A[0],那么所有可能的B只有一个，就是A[0]自己作为一个元素组成的数组。BS的是长度为1的二维数组。就是BS[0] = [A[0]] 。
        // 假设我现在再往数组A中再加一个元素A[1]，也就是说现在数组A有两个元素了，那么可以选取用来组成新的数组的元素多了一个A[1],
        // 这时，在组成新的数组B时，A[1]要么选取，要么不选取。如果选取，那么就会产生结果[A[0],A[1]] 和 [A[1]],如果不选取就会产生结果[A[0]],这正是数组A只有一个元素时所能产生的所有结果。
        // 算下去，会发现，每多加一个可选取的元素，就会新产生以前的结果+1种结果。
        // 我上面已经初始化好只用给定数组的第一个元素进行组合得到的结果，所以我要从第二个元素开始，将第二个加入到组合中。
        //而第二个元素的index是1.所以从i=1
        for(int i = 1; i < ts.length;i++){

            //Object[][] tempResultsNewElements = new Object[tempResults.length+1][];
            //换个方案
            //新添加的组合情况。
            T[][] tempResultsNewElements = Arrays.copyOf(results,results.length+1);

            //初始化新的元素（请注意：每一个元素是一个数组）
            //最后一个元素不在循环体中初始化，因为它不由之前的数组中的元素变化而得，它是一个新的数组,数组的元素只有一个那就是ts[i]
            for(int j = 0 ; j < tempResultsNewElements.length-1 ; j++){

                //每一个新的元素由之前的数组中的元素经过一定的变化得来——将以前的数组中的元素加一个元素，加的元素恰好是ts[i]
                tempResultsNewElements[j] = Arrays.copyOf(results[j],results[j].length+1);

                //加一个元素
                tempResultsNewElements[j][tempResultsNewElements[j].length-1] = ts[i];
            }

            T[] newElement = (T[])Array.newInstance(ts.getClass().getComponentType(),1);

            newElement[0] = ts[i];

            tempResultsNewElements[tempResultsNewElements.length-1] = newElement;
            //先记下上一个结果数组的长度。
            int lastTempResultsLength = results.length;

            //新的结果的长度为以前的数组的长度*2+1
            results = Arrays.copyOf(results,results.length*2+1);

            //将新的元素放进新的结果中
            System.arraycopy(tempResultsNewElements,0,results,lastTempResultsLength,tempResultsNewElements.length);
        }

        //这里的results已经指向了Arrays.copyOf() 返回的新数组，如果不返回，调用此方法的地方直接使用传入此方法的第二个参数，是得不到这个新的数组的。
        return results;

        //记：
        // 关于引用传递与值传递。java中，只有传入基本类型的数据是值传递，如果传入了一个数组或对象，是引用传递，没错！
        // 但是如果没有修改传过来的引用所指向的数组或对象（例如：没有使用arr[i][j] = XXX 或 没有使用obj.setXXX(XXX)），
        // 那么调用此方法的地方的那个原始引用所指向的对象是不会改变的。

        //关键的：其实调用方法的时候，不管是传入了基本类型还是数组或对象，都是传入了原来的值的一个副本，要么是值副本，要么是引用副本。
        //所以传入数组或对象时，其实内部是创建了一个新的引用，这个新的引用是传入方法时所使用的那个引用的副本，
        //新的引用和传入方法时所使用的引用指向的是同一个数组或对象。但是在方法的实现体内，有可能会将这个新的引用指向别的数组或对象。

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
