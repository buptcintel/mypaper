package com.bupt.xrf.util;

import java.util.Comparator;

import com.bupt.xrf.entity.Warehouse;

public class Sortwhbycostdesc implements Comparator<Warehouse> {

	@Override
	public int compare(Warehouse o1, Warehouse o2) {
		if(o1.getUnitcost() < o2.getUnitcost())
			return 1;
		else if(o1.getUnitcost() > o2.getUnitcost())
			return -1;
		else	
			return 0;
	}

}
