package com.gcy.DpCutLine;

import java.util.Arrays;

/**
 * 切割结果实体类
 */
public class CutResult {

    private int[] howToCut;

    private long resultMax;

    public CutResult() {
    }

    public CutResult(int[] howToCut, long resultMax) {
        this.howToCut = howToCut;
        this.resultMax = resultMax;
    }

    public int[] getHowToCut() {
        return howToCut;
    }

    public void setHowToCut(int[] howToCut) {
        this.howToCut = howToCut;
    }

    public long getResultMax() {
        return resultMax;
    }

    public void setResultMax(long resultMax) {
        this.resultMax = resultMax;
    }

    /**
     * 怎样切割求和。——反过来求和，以验证切割的准确性。
     * @return
     */
    public long howToCutSummation(){

        int sum = 0;
        for(int i : this.howToCut){
            sum += i;
        }
        return sum;
    }

    public long howToCutProduction(){
        int production = 1;
        for(int i : this.howToCut){
            production *= i;
        }
        return production;
    }
    @Override
    public String toString() {
        return "CutResult{" +
                "howToCut=" + Arrays.toString(howToCut) +
                ", resultMax=" + resultMax +
                '}';
    }
}
