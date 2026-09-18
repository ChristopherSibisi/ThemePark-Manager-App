import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class ThemeparkManangerApp
{
	
	public static void main(String [] args)
	{
		String[] rideNames = {"Anaconda","Golden Loop","Water Slide","Log Hose","Tower Terror"};
		double[] ticketPrice = {50.50,47.00,55.50,42.00,75.99};
		int[] ticketSold = new int[rideNames.length];
		double[] revenues = new double[rideNames.length];
		
		Scanner kb = new Scanner(System.in);
		
		populateTicketSold(ticketSold);
		calculateRevenues(ticketSold , ticketPrice , revenues);
		
		System.out.print("Enter the ride you want to search: ");
		String searchRide = kb.nextLine();
		
		int index = searchRide(rideNames , searchRide);
	
        if (index != -1) {
            System.out.println("Ride found: " + rideNames[index]);
            System.out.println("Ticket Price: " + ticketPrice[index]);
        } else {
            System.out.println("Ride not found.");
        }
		
		sortByTicketPrice(rideNames, ticketSold, ticketPrice, revenues);
		displayRidesInformation(rideNames, ticketSold, ticketPrice, revenues);
		
		
	}
	public static void populateTicketSold(int[] ticketSold)
	{
		Random rand = new Random();
		for(int i = 0 ; i < ticketSold.length ; i++){
			ticketSold[i] = rand.nextInt((150 - 1)+1)+1;
		}
		
	}
	public static void calculateRevenues(int[] ticketSold , double[] ticketPrice , double[] revenues)
	{
		
		for(int i = 0 ; i < revenues.length ; i++){
			
			revenues[i] = ticketSold[i] * ticketPrice[i];
		}
		
	}
	public static int searchRide(String[] rideNames , String searchRide)
	{
		int index = -1;
		
		for(int i = 0 ; i < rideNames.length ; i++){
			if(rideNames[i].equals(searchRide)){
				index = i;
				break;
			}
			
		}
		return index;
		
	}public static void sortByTicketPrice(String[] rideNames, int[] ticketSold, double[] ticketPrice, double[] revenues)
	{
		for(int X = 0 ; X < ticketPrice.length -1 ; X++){
			for(int i = 0 ; i < ticketPrice.length -X-1 ; i++){
				if(ticketPrice[i] > ticketPrice[i+1]){
					
					double tempPrice = ticketPrice[i];
					ticketPrice[i] = ticketPrice[i+1];
					ticketPrice[i+1] = tempPrice;
					
					String tempNames = rideNames[i];
					rideNames[i] = rideNames[i+1];
					rideNames[i+1] = tempNames;
					
					int tempSold = ticketSold[i];
					ticketSold[i] = ticketSold[i+1];
					ticketSold[i+1] = tempSold;
					
					double tempRevenues = revenues[i];
					revenues[i] = revenues[i+1];
					revenues[i+1] = tempRevenues;
						
				}
				
		    }
		}
		
		
	}public static void displayRidesInformation(String[] rideNames, int[] ticketSold, double[] ticketPrice, double[] revenues)
	{
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Rides : ");
		
		System.out.println("Ride Names\tTicket Sold\tTicket Price\tRevenues");
		
		for(int i = 0 ; i < rideNames.length ; i++){
			
		System.out.println(rideNames[i]+"\t\t"+ticketSold[i]+"\t\t"+df.format(ticketPrice[i])+"\t\t"+df.format(revenues[i]));
				
		}
		
	}

}