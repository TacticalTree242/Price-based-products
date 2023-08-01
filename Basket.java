import java.io.*;
import java.util.*;

//Exception class
public class Basket 
{
	public static final int MAX_PRODUCT = 25;
	
	static ObjectOutputStream output;
	
	//method to open file 
	public static void openFile()
	{
		try 
		{
			output = new ObjectOutputStream(new FileOutputStream("basket.ser")); //.ser = serialised file
		}
		catch(IOException ex)
		{
			System.out.println("Cannot open file "+ ex);
		}
	}
	
	//method to close file 
	public static void closeFile()
	{
		try 
		{
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("Cannot close file "+ ex);
		}
	}
	
	public static void main(String[] args)
	{
		Product aList[] = new Product[MAX_PRODUCT];
		
		String inLine;
		String barcode;
		char type;
		String name;
		String manufacturer;
		int unitPrice;
		int weight;
		int count = 0;
		
		try 
		{
			//create object of file you want to read
			Scanner input = new Scanner(new File("productdata.txt"));
			
			//Read file until the end
			while(input.hasNext())
			{
				inLine = input.nextLine();
				String[] fields = inLine.split("#"); // split on # director 
				
				barcode = fields[0];
				name = fields[1];
				type = barcode.charAt(0); // first character in barcode 
				
				
				// if product is itembased its first character of barcode = 1
				 if(type == '1')
				 {
					 manufacturer = fields[2];
					 unitPrice = Integer.parseInt(fields[3]);// convert string to integer
					 aList[count++] = new ItemBasedProduct(barcode,name,unitPrice,manufacturer);
				 }
				 
				 
				 
				 // if product is weightbased its first character of barcode = 2
				 else if(type == '2')
				 {
					 unitPrice = Integer.parseInt(fields[2]);// convert string to integer
					 weight = Integer.parseInt(fields[3]);
					 aList[count++] = new WeightBasedProduct(barcode,name,unitPrice,weight); 
				 }
				 
				 else
				 {
					 System.out.println("Illegal input "+inLine);
				 }
				
				
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Cannot find file "+ ex);
		}
		
		System.out.println("\nList of products");
		for(int i = 0 ; i<count ; i++)
		{
			System.out.println(aList[i].getRecord());
		}
		
		openFile();
		
		//serializing 
		try 
		{
			for(int i = 0; i < count ; i++)
			{
				output.writeObject(aList[i]);
			}
		}
		catch(IOException ex) //Check exception
		{
			System.out.println("Cannot write file "+ ex);
		}
		
		System.out.println("Items are serialized");
		
		
		closeFile();
		
		
	}
}