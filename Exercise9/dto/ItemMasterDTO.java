package Exercise9.dto;

import java.io.Serializable;
import java.util.Objects;
public class ItemMasterDTO implements Serializable,Comparable<ItemMasterDTO>{
	private int itemNumber;
	private String itemName;
	private int itemPrice;
	private String unit;
	public ItemMasterDTO() {
		
	}
	
	@Override
	public String toString() {
		return "ItemMasterDTO [itemno=" + itemNumber + ", itemname=" + itemName + ", itemprice=" + itemPrice + ", unit="
				+ unit + "]";
	}
	public ItemMasterDTO(int itemno, String itemname, int itemprice, String unit) {
		this.itemNumber = itemno;
		this.itemName = itemname;
		this.itemPrice = itemprice;
		this.unit = unit;
	}
	public int getItemno() {
		return itemNumber;
	}
	public void setItemno(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemname() {
		return itemName;
	}
	public void setItemname(String itemName) {
		this.itemName = itemName;
	}
	public int getItemprice() {
		return itemPrice;
	}
	public void setItemprice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public int compareTo(ItemMasterDTO obj) {
		return itemName.compareTo(obj.itemName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemName, itemNumber, itemPrice, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMasterDTO other = (ItemMasterDTO) obj;
		return Objects.equals(itemName, other.itemName) && itemNumber == other.itemNumber && itemPrice == other.itemPrice
				&& Objects.equals(unit, other.unit);
	}
	
	
}