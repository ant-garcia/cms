import java.util.Scanner;

public class TimeClockHandler
{
	TimeClock tc;

	public TimeClockHandler()
	{
	 	tc = new TimeClock();
	}

	public void run(Scanner s)
	{
		int choice;
		int id;
		String dept = "";
		String title = "";
		boolean quit = false;
		System.out.println("Welcome to the Time Clock!");
		
		do
		{
			System.out.println("The time is " + tc.getCurrentTime());
			System.out.println("\nHere are your Options:\n0: punch-in\n1: punch-out\n" + 
							   "2: Add Employee\n3: Delete Employee\n4: Add Department\n" + 
							   "5: Delete Department\n6: Check Status\n-1: Quit\n");
			choice = s.nextInt();
			s.nextLine();
			switch(choice)
			{
				case 0:
					System.out.println("Please enter a valid Id to Punch In");
					choice = s.nextInt();
					tc.punchIn(choice);
					break;
				case 1:
					System.out.println("Please enter a valid Id Punch Out");
					choice = s.nextInt();
					tc.punchOut(choice);
					break;
				case 2:
					System.out.println("You have chosen to add a new Employee\n" + 
									   "Please enter the following information:\n" +
									   "What is the Employee's Id?");
					id = s.nextInt();
					s.nextLine();
					System.out.println("What is the Employee's title?");
					title = s.nextLine();
					System.out.println("What is the Employee's department?");
					dept = s.nextLine();
					tc.addEmp(id, status, dept);
					break;
				case 3:
					System.out.println("You have chosen to remove a Employee\n" + 
									   "What is the Employee's Id to be removed?");
					id = s.nextInt();
					tc.delEmp(id);
					break;
				case 4:
					System.out.println("You have chosen to add a new Department\n" +
									   "What is the name of the new Department?");
					dept = s.nextLine();
					tc.addDept(dept);
					break;
				case 5:
					System.out.println("You have chosen to remove a Department\n" +
									   "What is the name of the Department?");
					dept = s.nextLine();
					tc.delDept(dept);
					break;
				case 6:
					System.out.println("You have chosen to check the status ");
					tc.status();
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
		tc.saveToFile();
	}
}