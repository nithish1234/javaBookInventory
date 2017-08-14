package com.InterFaceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.GetandSet.Items;

public class ItemFeatures {
	Map<String, List<Items>> mapValue=new HashMap<>();
	List<String> avalibleItems=new ArrayList<>();
	List<Items> sampleItems=new ArrayList<>();
	public void getName() {
		Items Item1 =new Items("toys","123abc",250,12);
	}
	
}
