package com.gcy.grub.gold;

/**
 * 金矿类
 */
public class GoldOre {

    private int needNumberOfWorker;
    private int goldReserves;

    public GoldOre() {
    }

    public GoldOre(int needNumberOfWorker, int goldReserves) {
        this.needNumberOfWorker = needNumberOfWorker;
        this.goldReserves = goldReserves;
    }

    public int getNeedNumberOfWorker() {
        return needNumberOfWorker;
    }

    public void setNeedNumberOfWorker(int needNumberOfWorker) {
        this.needNumberOfWorker = needNumberOfWorker;
    }

    public int getGoldReserves() {
        return goldReserves;
    }

    public void setGoldReserves(int goldReserves) {
        this.goldReserves = goldReserves;
    }
}
