package com.xebia.yakshop.app;

import java.util.List;

import com.xebia.yakshop.bean.LabYak;
import com.xebia.yakshop.bean.YakYield;
import com.xebia.yakshop.service.YakService;
import com.xebia.yakshop.service.YakServiceImpl;
import com.xebia.yakshop.util.XMLReader;

public class YakShop {
	
	public static void main(String[] args) throws Exception {
		String dataFile = "src/main/resources/Inputherd.xml";
		int elaspedTime = 14;
			
		new YakShop().showReport(dataFile, elaspedTime);
	}
	
	private void showReport(String dataFile, int elaspedTime) throws Exception {
		//Get the yak List
		List<LabYak> yakList = XMLReader.readXML(dataFile);
		YakService service = new YakServiceImpl();
        for(LabYak yak : yakList){
            service.calculateAndSaveYieldForDay(yak, elaspedTime);
        }
        YakYield totalYakYield = service.getTotalYakYield(elaspedTime);
        show(elaspedTime,totalYakYield,yakList);
		
	}
	
	public static  void show(int forDays, YakYield yield, List<LabYak> yakList){
        System.out.println("T = "+forDays+"\n\n");

        System.out.println("In Stock:");
        System.out.println("\t\t"+yield.getMilk()+" liters of milk");
        System.out.println("\t\t"+yield.getSkin()+" skins of wool");
        System.out.println("Herd:\n\n");
        for(LabYak yak : yakList){
            System.out.println(yak.display(forDays));
        }
    }

}
