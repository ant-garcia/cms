import java.util.Scanner;

public class PaymentHandler
{
	private PaymentManager pm;

	public PaymentHandler()
	{
		pm = new PaymentManager();
	}

	public void run(Scanner s)
	{
		int id;
		int choice;
		double wage;
		String dept = "";
		boolean quit = false;
		System.out.println("Welcome to the Payment System!");
		
		do
		{
			System.out.println("The time is " + pm.getCurrentTime());
			System.out.println("\nHere are your Options:\n0: Withdrawl Pay\n" + 
							   "1: Add Title\n2: Delete Title\n3: Update Title Wage\n" + 
							   "4: Check Employee Time\n5: Check Employees' Statuses\n" +
							   "6: Check All Wages\n-1: Quit\n");
			choice = s.nextInt();
			s.nextLine();
			switch(choice)
			{
				case 0:
					System.out.println("You have chosen to Withdrawl Payment\n" +
									   "Please enter the following information\n" +
									   "What is the Employee's Id?");
					id = s.nextInt();
					System.out.println("Amount Due in $: " + pm.calcPay(id));
					break;
				case 1:
					System.out.println("You have chosen to add a Title\n" +
									   "Please enter the following information\n" +
									   "What is the Title's name?");
					dept = s.nextLine();
					System.out.println("What is the wage?");
					id = s.nextInt();
					pm.addTitle(dept, id);
					break;
				case 2:
					System.out.println("You have chosen to delete a Title\n" +
									   "Please enter the following information\n" +
									   "What is the Title's name?");
					dept = s.nextLine();
					pm.delTitle(dept);
					break;
				case 3:
					System.out.println("You have chosen to update a Title Wage\n" +
									   "What is the name of the Title?");
					dept = s.nextLine();
					System.out.println("What is the new Wage of the Title?");
					id = s.nextInt();
					pm.updateWage(dept, id);
					break;
				case 4:
					System.out.println("You have chosen to check the time-off of an Employee\n" +
									   "What is the id of the Employee?");
					id = s.nextInt();
					pm.checkEmpTime(id);
					break;
				case 5:
					System.out.println("You have chosen to check the time-off of all Employees\n");
					pm.checkAllEmpTime();
					break;
				case 6:
					System.out.println("You have chosen to check all title and wages\n");
					pm.checkWages();
					break;
				case -1:
					System.out.println("GoodBye!");
					quit = true;
					break;
				default:
					System.out.println("ERROR: Please choose a valid option!");
					break;
			}
		}while(!quit);
		pm.saveToFile();
	}
}