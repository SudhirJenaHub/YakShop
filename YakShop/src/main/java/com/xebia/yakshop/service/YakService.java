package com.xebia.yakshop.service;

import com.xebia.yakshop.bean.LabYak;
import com.xebia.yakshop.bean.YakYield;

public interface YakService {

    public YakYield getTotalYakYield(int elapsedTimeInDays);
    public YakYield getYakYieldForAYak(LabYak yak, int elapsedTimeInDays);
    public void calculateAndSaveYieldForDay(LabYak yak,int elapsedTimeInDays);

}
