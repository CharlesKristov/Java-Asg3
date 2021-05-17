import java.util.ArrayList;
import java.util.Date;


public class ShoesUser {
	String ShoeName;
	String ShoeCategory;
	String ShoeDate;
	Integer ShoePrice;
	String ShoeID;
	
	public ShoesUser(String shoeName, String shoeCategory, String shoeDate, Integer shoePrice, String shoeID) {
		super();
		this.ShoeName = shoeName;
		this.ShoeCategory = shoeCategory;
		this.ShoeDate = shoeDate;
		this.ShoePrice = shoePrice;
		this.ShoeID = shoeID;
	}

	
	public static boolean ShoenameValidation(String mainName, ArrayList<ShoesUser> shoeusers) {
	
		if(mainName.contains("shoe"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean ShoeCatValidation(String MainCategory, ArrayList<ShoesUser> shoeusers) {
		
		if(MainCategory.contains("Sneaker")||MainCategory.contains("Running")||MainCategory.contains("Boot"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
public static boolean ShoeDateValidation(String MainDate, ArrayList<ShoesUser> shoeusers) {
		if(MainDate.length()!=10)
		{
			return false;
		}
		String strdd=null;
		String strmm=null;
		String stryyyy=null;
		
		strdd=MainDate.substring(0,2);
		strmm=MainDate.substring(3, 5);
		stryyyy=MainDate.substring(6);
		
		Integer dd=Integer.valueOf(strdd);
		Integer mm=Integer.valueOf(strmm);
		Integer yyyy=Integer.valueOf(stryyyy);
		
//		System.out.println(dd+" "+mm+" "+yyyy);
		if(dd < 0 || dd > 31 || mm < 0 || mm > 12 || yyyy < 1900 || yyyy > 2021)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	
}


