import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int opt=0;
		
		ArrayList<ShoesUser> shoeusers = new ArrayList<ShoesUser>();
		
		Scanner scan = new Scanner(System.in);
		
		do {
			for(int i=0;i<10;i++)
			{
				System.out.println("");
			}
			System.out.println("1. View Shoes");
			System.out.println("2. Add Shoe");
			System.out.println("3. Delete Shoe");
			System.out.println("4. Exit");
			try {
				opt=scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
				
			}
			
			if(opt==1) //VIEW
			{
				if(shoeusers.size()==0)
				{
					System.out.println("No shoes available...");
					scan.nextLine();
					scan.nextLine();
					continue;
				}
				else
				{
					for(int i=0;i<shoeusers.size();i++)
					{
						System.out.printf((i+1)+" "+shoeusers.get(i).ShoeName+"-"+shoeusers.get(i).ShoeID+"\n");
						System.out.println("=========================================");
						System.out.println("Category: "+shoeusers.get(i).ShoeCategory);
						System.out.println("Release date: "+shoeusers.get(i).ShoeDate);
						System.out.println("Price: "+shoeusers.get(i).ShoePrice);
						System.out.println("");
					}
					System.out.println("Press enter to continue...");
					scan.nextLine();
					scan.nextLine();
				}
			}
			else if(opt==2)//ADD
			{
				String MainName = null;
				String MainCategory = null;
				String MainDate = null;
				Integer MainPrice = null;
				String MainID = null;
				
				
				scan.nextLine();

				do { //NAME
					try {
						System.out.println("Input Shoe's name, must ends with (shoe)");
						MainName = scan.nextLine();
					} catch (Exception e) {
						// TODO: handle exception
						scan.nextLine();
					}
				}while(ShoesUser.ShoenameValidation(MainName, shoeusers)==false);
				
				do {
					try {
						System.out.println("Input Shoe Category, which must between (Sneaker, Running, or Boot) (case sensitive)");
						MainCategory=scan.nextLine();
					} catch (Exception e) {
						// TODO: handle exception
						scan.nextLine();
					}
				}while(ShoesUser.ShoeCatValidation(MainCategory, shoeusers)==false);
				
				do {
					try {
						System.out.println("Input Shoe's release date[dd-mm-yyyy]: ");
						MainDate=scan.nextLine();
					} catch (Exception e) {
						// TODO: handle exception
						scan.nextLine();
					}
					
				}while(ShoesUser.ShoeDateValidation(MainDate, shoeusers)==false);
				
				do {
					
					try {
						System.out.println("Input Shoe Price, more than or equals to 5000");
						MainPrice=scan.nextInt();
					} catch (Exception e) {
						// TODO: handle exception
						scan.nextLine();
					}
					
				}while((MainPrice>=5000) == false);
				
				
				//GenerateID
				int ID=rand.nextInt(1000);
				MainID="SH"+ID;
				ShoesUser shoeMain = new ShoesUser(MainName, MainCategory, MainDate,MainPrice,MainID);
				shoeusers.add(shoeMain);
			}
			else if(opt==3) //DELETE
			{
				
				if(shoeusers.size()==0)
				{
					System.out.println("No shoes available...");
					scan.nextLine();
					scan.nextLine();
					continue;
				}
				else
				{
					int numdelete=0;
					for(int i=0;i<shoeusers.size();i++)
					{
						System.out.printf((i+1)+" "+shoeusers.get(i).ShoeName+"-"+shoeusers.get(i).ShoeID+"\n");
						System.out.println("=========================================");
						System.out.println("Category: "+shoeusers.get(i).ShoeCategory);
						System.out.println("Release date: "+shoeusers.get(i).ShoeDate);
						System.out.println("Price: "+shoeusers.get(i).ShoePrice);
						System.out.println("");
					}
					scan.nextLine();

					do {
						try {
							System.out.println("Choose shoe number to be deleted! [1.."+shoeusers.size()+"]:");
							numdelete=scan.nextInt();
							
						} catch (Exception e) {
							// TODO: handle exception
							scan.nextLine();
						}
					}while(numdelete>shoeusers.size()||numdelete<0);
					
					for(int i=0;i<shoeusers.size();i++)
					{
						if(i==numdelete-1)
						{
							shoeusers.remove(i);
							System.out.println("Shoe removed!");
							scan.nextLine();
						}
					}
					
					
				}
			}
			else if(opt==4)
			{
				System.out.println("Thank you for using this application!");
				scan.nextLine();
			}
	
		}while(opt!=4);
	}

	

}
