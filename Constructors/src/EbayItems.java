import java.util.ArrayList;
import java.util.Scanner;
import java.text.*;

public class EbayItems
	{
		static 	ArrayList <Ebay> ebayAL = new ArrayList<Ebay>();
		static 	ArrayList <Ebay> sellerAL = new ArrayList<Ebay>();
		static Scanner userInput = new Scanner(System.in);
		static 	double credit = 1000;
		static DecimalFormat df = new DecimalFormat("#####.##");


		public static void main(String[] args)
			{
			doAddItem();
			System.out.println("Hello and welcome to Ebay.");
			System.out.println();
			doPrintList();
			doSale();
			doSellerItem();
			doPrintList();
			doSearchItem();
			doBuyItem();
			doPrintList();
			doRedo();
			doSpecialOffer();
			doPrintList();
			}
		
		public static void doAddItem()
			{
			ebayAL.add(new Ebay("Computer", 400.00, 7, "Simms St."));
			ebayAL.add(new Ebay("Piano", 120.78, 4, "Wilson Rd."));
			ebayAL.add(new Ebay("#2 Pencil", .25, 10, "Mullen High School"));
			ebayAL.add(new Ebay("Record Player", 115.50, 9/10, "Lafayette St in Denver, CO." ));
			ebayAL.add(new Ebay("iPhone 6+", 130, 10, "Helms Ct."));
			ebayAL.add(new Ebay("Backpack", 30, 6, "County Line Rd."));
			}
		
		public static void doPrintList()
			{
			System.out.println("Here are the items currently in stock:");
			System.out.printf("%-15s", "Item");
			System.out.printf("%-15s", "Price");
			System.out.printf("%-15s", "Quality");
			System.out.printf("%-15s", "Location");
			System.out.println();
			
			for(Ebay e: ebayAL)
				{
					System.out.printf("%-15s", e.getItem());
					System.out.printf("$%-15.2f", e.getPrice());
					System.out.printf("%-15d", e.getQuality());
					System.out.printf("%-15s", e.getLocation());
					System.out.println();				
				}
			System.out.println();
			System.out.println("You have a credit of " + " $" + df.format(credit));
			System.out.println();
			}
		
		public static void doSale()
			{
			for(int i = 0; i < ebayAL.size(); i++)
				{
				ebayAL.get(i).setPrice(ebayAL.get(i).getPrice() * .9);
				}
			System.out.println("10% SALE FOR ALL ITEMS!! The new prices are:");
			for(Ebay p : ebayAL)
				{
				System.out.println(p.getItem() + " for $" + df.format(p.getPrice()));
				}
			}
		
		public static void doSellerItem()
			{
			System.out.println();
			System.out.println("Would you like to sell an item on Ebay?");
			String answer = userInput.nextLine();
			if(answer.equalsIgnoreCase("yes"))
				{
				System.out.println("What is the name of the item that you are selling?");
				String item = userInput.nextLine();
				System.out.println("What is the price that you are hoping to sell such item? Please refrain from inserting the '$' ");
				double price = userInput.nextDouble();
				System.out.println("What would you say the quality of your item is out of 10?");
				int quality = userInput.nextInt();
				Scanner userInput2 = new Scanner(System.in);
				System.out.println("What street will you be shipping this item from?");
				String location = userInput2.nextLine();
				
				ebayAL.add(new Ebay(item, price, quality, location));
				credit = credit + price;

				}

			else
				{
				System.out.println("Alright. Happy Shopping!");
				}
			System.out.println();

			}
			
		public static void doSearchItem()
			{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Would you like to search for an item in our inventory?");
			String answer = userInput.nextLine();
			if(answer.equalsIgnoreCase("yes"))
				{
				System.out.println("Alright, please input the name of an item you would like to search.");
				String item = userInput.nextLine();
				int select = -1;
				for(int i = 0; i < ebayAL.size(); i ++)
					{
					if(item.equalsIgnoreCase(ebayAL.get(i).getItem()))
						{
						select = i;
						}
					}
				if(select == -1)
					{
					System.out.println("Im sorry, but we do not have that item in our inventory at the moment.");
					}
				else
					{
					System.out.println("Here is what I found regarding your search.");
					System.out.println(ebayAL.get(select).getItem() + " for $" + df.format(ebayAL.get(select).getPrice()) + " at a quality rating of " + ebayAL.get(select).getQuality() + "/10 "+ " located at " + ebayAL.get(select).getLocation());
					System.out.println();
					}
				}
			else
				{
				System.out.println("Alright, Happy Shopping!");
				System.out.println();
				}

			}
		
		public static void doBuyItem()
			{
			Scanner userInput3 = new Scanner(System.in);
			System.out.println("Would you like to buy an item today?");
			String answer = userInput3.nextLine();
			if(answer.equalsIgnoreCase("yes"))
				{
				Scanner userInput4 = new Scanner(System.in);
				System.out.println("What would you like to buy?");
				String item = userInput4.nextLine();
				int select = -1;
				for(int i = 0; i < ebayAL.size(); i ++)
					{
					if(item.equalsIgnoreCase(ebayAL.get(i).getItem()))
						{
						select = i;
						}
					}
				if(select == -1)
					{
					System.out.println("Im sorry, but we do not have that item in our inventory at the moment.");
					System.out.println();
					}
				else
					{
					System.out.println("Thank you for shopping at Ebay!");
					System.out.println();
					credit = credit - ebayAL.get(select).getPrice();
					ebayAL.remove(select);
					
					}
				}
			else
				{
				System.out.println("Alright, Happy Shopping!");
				System.out.println();
				}

				
			}
		
		public static void doRedo()
		{
		Scanner userInput5 = new Scanner(System.in);
		System.out.println("Would you like to Buy, Sell or Search any item? Please answer yes or no.");
		String answer = userInput5.nextLine();

		if(answer.equalsIgnoreCase("yes"))
			{
			System.out.println("Which would you like to do?");
			Scanner userInput6 = new Scanner(System.in);
			String answer2 = userInput5.nextLine();
			if(answer2.equalsIgnoreCase("Buy"))
				{
				doBuyItem();
				doPrintList();
				}
			if(answer2.equalsIgnoreCase("Sell"))
				{
				doSellerItem();
				doPrintList();
				}
			if(answer2.equalsIgnoreCase("Search"))
				{
				doSearchItem();
				doPrintList();
				}
			}
		else
			{
			System.out.println("Alright, Happy Shopping!");
			System.out.println();
			doPrintList();
			}
		}
		
		public static void doSpecialOffer()
		{
		Scanner userInput7 = new Scanner(System.in);
		System.out.println("NEW SPECIAL OFFER: If you buy one item, you can get one half off.");
		System.out.println("Would you like to participate?");
		String answer = userInput7.nextLine();
		Scanner userInput8 = new Scanner(System.in);
		Scanner userInput9 = new Scanner(System.in);

		if(answer.equalsIgnoreCase("yes"))
			{
			System.out.println("What is the first item you would like to buy?");
			String itemOne = userInput8.nextLine();
			System.out.println("What is the second item you would like to buy for half off?");
			String itemTwo = userInput9.nextLine();
			int select = -1;
			
			for(int i = 0; i < ebayAL.size(); i ++)
				{
				if(itemOne.equalsIgnoreCase(ebayAL.get(i).getItem()))
					{
					select = i;
					}
				}
			if(select == -1)
				{
				System.out.println("Im sorry, but we do not have that item in our inventory at the moment.");
				System.out.println();
				}
			else
				{
				credit = credit - ebayAL.get(select).getPrice();
				ebayAL.remove(select);
				}
			int select2 = -1;
			
			for(int i = 0; i < ebayAL.size(); i ++)
				{
				if(itemTwo.equalsIgnoreCase(ebayAL.get(i).getItem()))
					{
					select2 = i;
					}
				}
			if(select2 == -1)
				{
				System.out.println("Im sorry, but we do not have that item in our inventory at the moment.");
				System.out.println();
				}
			else
				{
				System.out.println("Thank you for shopping at Ebay!");
				System.out.println();
				credit = credit - ebayAL.get(select2).getPrice()/2;
				ebayAL.remove(select2);
				
				}
			}
		
		else
			{
			System.out.println("Alright, happy shopping!");
			System.out.println();
			}
		}
	}
		
		
		
		

	
