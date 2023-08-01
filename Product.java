import java.io.*;

public abstract class Product implements Taxable, Serializable,Comparable<Product> //pre existing interface 
{
	private String barcodeNumber;
	private String name;
	private int unitPrice;
	
	public Product(String barcodeNumber, String name,int unitPrice)
	{
		setBarcodeNumber(barcodeNumber);
		setName(name);
		setUnitPrice(unitPrice);
	}
	
	public abstract String getRecord();
	
	public abstract int CalculateTotalCost(int tax);
	
	public int CalculateTax(int price , int tax)
	{
		return(int)((price*tax)/100);
	}
	
	public void setBarcodeNumber(String barcodeNumber)
	{
		this.barcodeNumber = barcodeNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setUnitPrice(int unitPrice)
	{
		this.unitPrice = unitPrice;
	}
	
	public String getBarcodeNumber()
	{
		return this.barcodeNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getUnitprice()
	{
		return this.unitPrice;
	}
	
	
}	
