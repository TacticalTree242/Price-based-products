public class WeightBasedProduct extends Product
{
	private int weight;
	
	public WeightBasedProduct(String barcodeNumber, String name,int unitPrice,int weight)
	{
		super(barcodeNumber,name,unitPrice);
		setWeight(weight);
	}
	
	public int compareTo(Product other)
	{
		String thisField = getBarcodeNumber().charAt(0)+ getName()+getWeight();
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
		int totalPrice = (getUnitprice()*getWeight())/1000;
		return totalPrice + CalculateTax(getUnitprice(),tax);
	}
	
	
	public  String getRecord()
	{
		return "Barcode "+getBarcodeNumber()+ " is "+ getName()+", unit Price "+getUnitprice()+"c/kg , weight "+getWeight()+" grams";
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;	
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public static void main(String args[])
	{
		WeightBasedProduct w1 = new WeightBasedProduct("245134867531","Bananas",4300,540);
		System.out.println(w1);
	}
}