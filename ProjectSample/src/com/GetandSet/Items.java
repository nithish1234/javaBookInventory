package com.GetandSet;

import java.io.Serializable;

public class Items implements Serializable {
private String itemName;
private String itemId;
private int itemPrice;
private int itemQuantatity;
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public int getItemPrice() {
	return itemPrice;
}
public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
}
public int getItemQuantatity() {
	return itemQuantatity;
}
public void setItemQuantatity(int itemQuantatity) {
	this.itemQuantatity = itemQuantatity;
}
@Override
public String toString() {
	return "Items [itemName=" + itemName + ", itemId=" + itemId + ", itemPrice=" + itemPrice + ", itemQuantatity="
			+ itemQuantatity + "]";
}

}
