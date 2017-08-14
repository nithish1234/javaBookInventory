package com.GetandSet;

public class TestGetAndSet {
public static void main(String[] args) {
	Items obj=new Items();
	obj.setItemId("12wer");
	obj.setItemName("toys");
	obj.setItemPrice(250);
  obj.setItemQuantatity(1);
  System.out.println(obj.toString());
}
}
