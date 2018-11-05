package com.gcy.DpCutLine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目:
 * 给定一根长为n的绳子，要求切割成m段。请问如何切割才能使得每一段的乘积是最大值
 */
public class DpCutLine {

    public static void main(String args[]){
        //Map<Integer,CutResult> map = cutLineReturnAllProcess(100);
        CutResult cutResult = cutLine(60);
        System.out.println(cutResult);
        System.out.println(cutResult.howToCutSummation());//2066242608
        System.out.println(cutResult.howToCutProduction());
       /* System.out.println(cutLine(1).getResultMax()*cutLine(59).getResultMax());
        System.out.println(cutLine(5).getResultMax()*cutLine(55).getResultMax());*/
        //2147483648-1 int 的最大值，
       /*System.out.println(map.get(55).getResultMax()*map.get(5).getResultMax());
       System.out.println(map.get(59));*/

        /**
         *
         */


    }


    public static CutResult cutLine(int n){

        Map<Integer,CutResult>  cutResultMap =  new HashMap<>();
        cutResultMap.put(1,new CutResult(new int[]{1},1));
        cutResultMap.put(2,new CutResult(new int[]{2},2));
        cutResultMap.put(3,new CutResult(new int[]{3},3));

        if(n>=4){


            for(int i = 4 ; i <= n ;i++){

                long tempMax = i;
                int[] tempHowToCut= new int[]{i};

                for(int j = 1; j <= cutResultMap.size() ; j++){

                    CutResult cutResultJ =  cutResultMap.get(j);
                    CutResult cutResultI_J = cutResultMap.get(i-j);

                    long  current =  cutResultJ.getResultMax()*cutResultI_J.getResultMax();

                    //注意，如果这里current 定义成 int 类型，
                    // 那当乘积的结果大于int类型的最大值时，将会产生结果值溢出，current的值将会是负数。
                    // long其实也会产生同样的情况。
                   if(current > tempMax){
                       int[] howToCutJ = cutResultJ.getHowToCut();
                       int[] howToCutI_J = cutResultI_J.getHowToCut();

                       tempMax = current;
                       tempHowToCut = howToCutJ;
                       tempHowToCut =  Arrays.copyOf(tempHowToCut,tempHowToCut.length+howToCutI_J.length);
                       System.arraycopy(howToCutI_J,0,tempHowToCut,howToCutJ.length,howToCutI_J.length);
                   }
                }
                CutResult cutResult = new CutResult(tempHowToCut,tempMax);
                cutResultMap.put(i, cutResult);
                System.out.println(i+":"+cutResult);
            }

        }
        return cutResultMap.get(n);
    }

   /* public static Map<Integer,CutResult> cutLineReturnAllProcess(int n){

        Map<Integer,CutResult>  cutResultMap =  new HashMap<>();
        cutResultMap.put(1,new CutResult(new int[]{1},1));
        cutResultMap.put(2,new CutResult(new int[]{2},2));
        cutResultMap.put(3,new CutResult(new int[]{3},3));

        if(n>=4){


            for(int i = 4 ; i <= n ;i++){

                long tempMax = i;
                int[] tempHowToCut= new int[]{i};

                for(int j = 1; j <= cutResultMap.size() ; j++){

                    CutResult cutResultJ =  cutResultMap.get(j);
                    CutResult cutResultI_J = cutResultMap.get(i-j);

                    long  current =  cutResultJ.getResultMax()*cutResultI_J.getResultMax();

                    if(current > tempMax){
                        int[] howToCutJ = cutResultJ.getHowToCut();
                        int[] howToCutI_J = cutResultI_J.getHowToCut();

                        tempMax = current;
                        tempHowToCut = howToCutJ;
                        tempHowToCut =  Arrays.copyOf(tempHowToCut,tempHowToCut.length+howToCutI_J.length);
                        System.arraycopy(howToCutI_J,0,tempHowToCut,howToCutJ.length,howToCutI_J.length);
                    }
                }
                CutResult cutResult = new CutResult(tempHowToCut,tempMax);
                cutResultMap.put(i, cutResult);

            }

        }
      return cutResultMap;
    }*/
}
