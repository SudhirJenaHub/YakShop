package com.xebia.yakshop.service;

import com.xebia.yakshop.bean.YakYield;

public interface YakStore {

     public YakYield getYieldForYak(int id, int elapsedTimeInDays);
     public YakYield getTotalYield(int elapsedTimeInDays);
     public void saveYieldForDay(int id,int elapsedTimeInDays,YakYield yield);
}
