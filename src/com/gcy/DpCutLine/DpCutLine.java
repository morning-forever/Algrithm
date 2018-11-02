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
        CutResult cutResult = cutLine(100);
        System.out.println(cutResult);
        System.out.println(cutResult.howToCutSummation());//2066242608
        System.out.println(cutResult.howToCutProduction());
        System.out.println(cutLine(1).getResultMax()*cutLine(59).getResultMax());
        System.out.println(cutLine(5).getResultMax()*cutLine(55).getResultMax());


    }


    public static CutResult cutLine(int n){

        Map<Integer,CutResult>  cutResultMap =  new HashMap<>();
        cutResultMap.put(1,new CutResult(new int[]{1},1));
        cutResultMap.put(2,new CutResult(new int[]{2},2));
        cutResultMap.put(3,new CutResult(new int[]{3},3));

        if(n>=4){


            for(int i = 4 ; i <= n ;i++){

                int tempMax = i;
                int[] tempHowToCut= new int[]{i};

                for(int j = 1; j <= cutResultMap.size() ; j++){

                    CutResult cutResultJ =  cutResultMap.get(j);
                    CutResult cutResultI_J = cutResultMap.get(i-j);

                   int  current =  cutResultJ.getResultMax()*cutResultI_J.getResultMax();

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
}
