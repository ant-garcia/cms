import java.util.Scanner;

public class CMS
{
	private TimeClockHandler tch;
	private TicketTrackerHandler tth;
	
	public CMS()
	{
		load();
	}

	public void load()
	{
		this.tch = new TimeClockHandler();
		this.tth = new TicketTrackerHandler();
	}

	public static void main(String[] args)
	{
		int choice;
		boolean option = false;
		Scanner in = new Scanner(System.in);
		CMS cms = new CMS();
		System.out.println("Welcome to the Central Management System\n" +
						   "What would you like to do?\n");
		do
		{
			System.out.println("0: Time Clock\n1: Payroll\n2: Ticket Support\n" + 
							   "3: Company/Customer Support\n-1: Quit");
			choice = in.nextInt();
			switch(choice)
			{
				case 0:
					System.out.println("You have chosen to access the time clock");
					cms.tch.run(new Scanner(System.in));
					break;
				case 1:
					System.out.println("You have chosen to access Payroll");
					break;
				case 2:
					System.out.println("You have chosen to access Ticket Support");
					cms.tth.run(new Scanner(System.in));
					break;
				case 3:
					System.out.println("You have chosen to access Company/Customer Support");
					break;
				case -1:
					System.out.println("GoodBye!");
					option = true;
					break;
				default:
					System.out.println("ERROR: Please choose a valid option!");
					break;
			}
		}while(!option);
	}
}