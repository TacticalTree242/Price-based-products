public class ItemBasedProduct extends Product
{
	private String manufacturer;
	
	public ItemBasedProduct(String barcodeNumber, String name,int unitPrice,String manufacturer)
	{
		super(barcodeNumber,name,unitPrice);
		setManufacturer(manufacturer);
	}
	
	public int compareTo(Product other)
	{
		String thisField = getBarcodeNumber().charAt(0)+ getName();
		String otherField;
		
		if(other instanceof ItemBasedProduct)
		{
			otherField = other.getBarcodeNumber().charAt(0)+ other.getName();
		}
		else
		{
			otherField = other.getBarcodeNumber().charAt(0)+ other.getName()+ ((WeightBasedProduct)other).getWeight();
		}
		return thisField.compareTo(otherField);
	}
	
	public int CalculateTotalCost(int tax)
	{
		return getUnitprice()+CalculateTax(getUnitprice(),tax);
	}
	
	public  String getRecord()
	{
		return "Barcode "+getBarcodeNumber()+ " is "+ getName()+" from "+getManufacturer()+", unit Price "+getUnitprice()+"c";
	}
	
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;	
	}
	
	public String getManufacturer()
	{
		return this.manufacturer;
	}
	
	public static void main(String args[])
	{
		ItemBasedProduct i1 = new ItemBasedProduct("167832345047","Tuna",1500,"I&J");
		System.out.println(i1);
	}
}