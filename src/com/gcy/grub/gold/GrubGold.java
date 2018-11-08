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
        /*GoldOre[] resultGoldOres = new GoldOre[1];
        resultGoldOres[0] = goldOres[0];*/
        for(int i=0;i<goldOres.length;i++){

        }

        /**
         * 写一个算法，传一个数组，列出这个数组的所有排列组合情况。
         */
        return null;


    }

    /**
     * 数组组合。传入一个数组，返回这个数组的所有组合情况组合。数组元素要么选，要么不选。
     *
     * 这道题目的真正题意是：
     * 给定一个数组，要求用这个数组中的元素进行组合，返回所有的组合情况。
     * 说明：每一种组合可以使用这个数组中的1个或多个元素，但不能使用这个数组中包含的元素以外的任何对象或值。
     *
     * 这个方法没有使用泛型。下面举个例子来说明没有使用泛型坏处：
     * 当我传入一个Integer[]时，只能用Object[][] 类型的引用来接收结果值。如果使用Integer[][]，然后在方法调用后进行强制转换,运行的时候就会报错：
     * Exception in thread "main" java.lang.ClassCastException: [[Ljava.lang.Object; cannot be cast to [[Ljava.lang.Integer; Object 数组不能强制转换成其他数组。
     *      * 但是为什么在泛型方法里可以T[][] tempResults = (T[][])new Object[1][1];? 暂且不管，后续追究。
     *
     * 其实，使用泛型的好处根本不存在，最后还是会报
     * Exception in thread "main" java.lang.ClassCastException: [[Ljava.lang.Object; cannot be cast to [[Ljava.lang.Integer; Object 这个异常。
     *
     *最后总结：
     * 你可以将指向Integer对象的Object类型的引用强转成Integer类型的引用，但是你不能将指向Integer数组的Object数组类型的引用强转成Integer数组类型的引用。---错了，妈的。
     *
     * 是编译期后，泛型就被擦除了。我在方法的实现里面建的就是Object类型的数组，当然不能转成Integer类型的数组了。
     * @param objects 给定的数组
     * @return 所有组合的情况。一定是一个二维数组，外层数组的长度表示会出现多少种情况，外层数组的每一个元素表示可能出现的每一种组合情况。
     */
    private static Object[][] permutationAndCombinationOfArrayWithoutGeneric(Object[] objects){

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
                tempResultsNewElements[j] = Arrays.copyOf(tempResults[j],tempResults[j].length+1);

                //初始化新元素的最后一个元素
                tempResultsNewElements[j][tempResults[j].length] = objects[i];
            }

            tempResultsNewElements[tempResultsNewElements.length-1] = new Object[]{objects[i]};

            //先记下上一个结果数组的长度。
            int lastTempResultsLength = tempResults.length;

            //新的结果的长度为以前的数组的长度*2+1
            tempResults = Arrays.copyOf(tempResults,tempResults.length*2+1);

            //将新的元素放进新的结果中
            System.arraycopy(tempResultsNewElements,0,tempResults,lastTempResultsLength,tempResultsNewElements.length);


        }
        return tempResults;
    }


    /**
     *
     * @param ts
     * @param results  结果。必须有且只有一个元素，元素中有且只有一个元素。
     * @param <T> 数组元素的类型。
     * @return
     */
    private static <T> T[][] permutationAndCombinationOfArray(T[] ts,T[][] results){

       //T[][] hh = (T[][]) Array.newInstance(results.getClass().getComponentType(), 3); 这里有一个比较重要的。
        if(results.length != 1){
            println("传进来的结果必须只有一个元素");
            return null;
        }else if(results[0].length != 1){
            println("传进来的结果元素中必须只有一个元素");
            return null;
        }


        int arrayLength = ts.length;

        results[0][0] = ts[0];

        if(arrayLength == 1 ){
            return results;
        }



        //为什么从i=1开始？答：我要算出长度为objects.length的数组所有可能的组合，怎么算呢？
        //我只要得到长度为1的数组所有可能的组合，就能得到长度为2的数组所有可能的组合
        //只要得到长度为2的数组所有可能的组合，就能得到长度为3的数组所有可能的组合
        //...
        for(int i = 1; i < ts.length;i++){

            //Object[][] tempResultsNewElements = new Object[tempResults.length+1][];
            //换个方案
            T[][] tempResultsNewElements = Arrays.copyOf(results,results.length+1);

            //初始化新的元素（请注意：每一个元素是一个数组）
            //最后一个元素不在循环体中初始化，因为它不由之前的数组中的元素变化而得，它是一个新的数组,数组的元素只有一个那就是objects[i]
            for(int j = 0 ; j < tempResultsNewElements.length-1 ; j++){

                //每一个新的元素由之前的数组中的元素经过一定的变化得来——将以前的数组中的元素加一个元素，加的元素恰好是objects[i]
                //换方案，这里可以不用上面那种写法，可以用Arrays.copyOf来扩展数组。
                tempResultsNewElements[j] = Arrays.copyOf(results[j],results[j].length+1);

                //初始化新元素的最后一个元素
                tempResultsNewElements[j][results[j].length] = ts[i];
            }

           // tempResultsNewElements[tempResultsNewElements.length-1] =(T[]) new Object[]{ts[i]};

              T[] newElement = Arrays.copyOf(results[0],1);
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


    /**
     *
     * @param ts
     * @param <T> 数组元素的类型。
     * @return
     */
    private static <T> T[][] permutationAndCombinationOfArray(T[] ts){

        //T[][] hh = (T[][]) Array.newInstance(results.getClass().getComponentType(), 3); 这里有一个比较重要的。
        T[][] results = (T[][])Array.newInstance(ts.getClass(),1);
        results[0] = (T[]) Array.newInstance(ts.getClass().getComponentType(),1);

        //results[0] = (T[])Array.newInstance(ts.getClass().getComponentType(),1);
        results[0][0] = ts[0];
        int arrayLength = ts.length;

        results[0][0] = ts[0];

        if(arrayLength == 1 ){
            return results;
        }



        //为什么从i=1开始？答：我要算出长度为objects.length的数组所有可能的组合，怎么算呢？
        //我只要得到长度为1的数组所有可能的组合，就能得到长度为2的数组所有可能的组合
        //只要得到长度为2的数组所有可能的组合，就能得到长度为3的数组所有可能的组合
        //...
        for(int i = 1; i < ts.length;i++){

            //Object[][] tempResultsNewElements = new Object[tempResults.length+1][];
            //换个方案
            T[][] tempResultsNewElements = Arrays.copyOf(results,results.length+1);

            //初始化新的元素（请注意：每一个元素是一个数组）
            //最后一个元素不在循环体中初始化，因为它不由之前的数组中的元素变化而得，它是一个新的数组,数组的元素只有一个那就是objects[i]
            for(int j = 0 ; j < tempResultsNewElements.length-1 ; j++){

                //每一个新的元素由之前的数组中的元素经过一定的变化得来——将以前的数组中的元素加一个元素，加的元素恰好是objects[i]
                //换方案，这里可以不用上面那种写法，可以用Arrays.copyOf来扩展数组。
                tempResultsNewElements[j] = Arrays.copyOf(results[j],results[j].length+1);

                //初始化新元素的最后一个元素
                tempResultsNewElements[j][results[j].length] = ts[i];
            }

            // tempResultsNewElements[tempResultsNewElements.length-1] =(T[]) new Object[]{ts[i]};

            T[] newElement = Arrays.copyOf(results[0],1);
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
