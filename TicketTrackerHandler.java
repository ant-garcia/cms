import java.util.Scanner;

public class TicketTrackerHandler
{
	private TicketTracker tt;

	public TicketTrackerHandler()
	{
		tt = new TicketTracker();
	}

	public void run(Scanner s)
	{
		int choice;
		int id;
		String dept = "";
		String info = "";
		boolean quit = false;
		System.out.println("Welcome to the Ticket System!");
		
		do
		{
			System.out.println("The time is " + tt.getCurrentTime());
			System.out.println("\nHere are your Options:\n0: Create Ticket\n" + 
							   "1: Delete Ticket\n2: Update Ticket\n3: Check Department Tickets\n" + 
							   "4: Check Open Tickets\n5: Check Closed Tickets\n6: Check Status\n" +
							   "-1: Quit\n");
			choice = s.nextInt();
			s.nextLine();
			switch(choice)
			{
				case 0:
					System.out.println("You have chosen to create a Ticket\n" +
									   "Please enter the following information\n" +
									   "What is the Ticket Id?");
					id = s.nextInt();
					s.nextLine();
					System.out.println("What is the department?");
					dept = s.nextLine();
					System.out.println("Please enter a detailed explaination for the ticket");
					info = s.nextLine();
					tt.addTicket(id, dept, info);
					break;
				case 1:
					System.out.println("You have chosen to delete a Ticket\n" +
									   "Please enter the following information\n" +
									   "What is the Ticket Id?");
					id = s.nextInt();
					tt.delTicket(id);
					break;
				case 2:
					System.out.println("You have chosen to an update existing ticket\n" + 
									   "Please enter the following information:\n" +
									   "What is the Ticket Id?");
					id = s.nextInt();
					tt.updateTicket(id);
					break;
				case 3:
					System.out.println("You have chosen to check the status of a department\n" +
									   "What is the name of the department?");
					dept = s.nextLine();
					tt.checkDeptTickets(dept);
					break;
				case 4:
					System.out.println("You have chosen to check the status of the open Tickets\n" + 
									   "List all or by a specific department\n0: All\n1: Department");
					choice = s.nextInt();
					s.nextLine();
					if(choice == 0) tt.allOpenTickets();	
					else
					{
						System.out.println("What department do you want?");
						dept = s.nextLine();
						tt.openDeptTickets(dept);
					}
					break;
				case 5:
					System.out.println("You have chosen to check the status of the closed Tickets\n" + 
									   "List all or by a specific department\n0: All\n1: Department");
					choice = s.nextInt();
					s.nextLine();
					if(choice == 0) tt.allClosedTickets();	
					else
					{
						System.out.println("What department do you want?");
						dept = s.nextLine();
						tt.closedDeptTickets(dept);
					}
					break;
				case 6:
					System.out.println("You have chosen to check the status");
					tt.status();
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
		//tt.saveToFile();
	}
}