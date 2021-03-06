package com.xebia.yakshop.service;

import com.xebia.yakshop.bean.LabYak;
import com.xebia.yakshop.bean.YakYield;

public class YakServiceImpl implements YakService {
    private YakStore yakStore;
    public  YakServiceImpl(){
        yakStore = new YakStoreImpl();
    }
    public YakYield getTotalYakYield(int elapsedTimeInDays) {
        return yakStore.getTotalYield(elapsedTimeInDays);
    }

    public YakYield getYakYieldForAYak(LabYak yak, int elapsedTimeInDays) {
        if(yakStore.getYieldForYak(yak.getId(),elapsedTimeInDays) == null){
            calculateAndSaveYieldForDay(yak,elapsedTimeInDays);
        }
        return yakStore.getYieldForYak(yak.getId(),elapsedTimeInDays);
    }



    public void calculateAndSaveYieldForDay(LabYak yak, int elapsedTimeInDays) {
        YakYield yield = yak.calculateYakYieldForDay(elapsedTimeInDays);
        yakStore.saveYieldForDay(yak.getId(),elapsedTimeInDays,yield);
    }

}
