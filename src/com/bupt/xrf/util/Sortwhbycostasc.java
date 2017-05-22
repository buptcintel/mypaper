package com.bupt.xrf.util;

import java.util.Comparator;

import com.bupt.xrf.entity.Warehouse;

public class Sortwhbycostasc implements Comparator<Warehouse> {

	@Override
	public int compare(Warehouse o1, Warehouse o2) {
		if(o1.getTotalunitcost() > o2.getTotalunitcost())
			return 1;
		else if(o1.getTotalunitcost() < o2.getTotalunitcost())
			return -1;
		else	
			return 0;
	}

}
