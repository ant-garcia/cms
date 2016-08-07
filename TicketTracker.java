import java.util.Date;

public class TicketTracker
{
	private TicketManager tm;
	private JsonHandler jh;

	public TicketTracker()
	{
		tm = new TicketManager();
		jh = new JsonHandler();
		loadFromFile();
	}

	private void loadFromFile()
	{
		tm.setAllTickets(jh.loadBackup());
	}

	public void saveToFile()
	{
		jh.createBackup(tm.getAllTickets(), "Tickets");
	}

	public String getCurrentTime()
	{
		return new Date().toString();
	}

	public int size()
	{
		return tm.getNumOfTickets();
	}

	public void addTicket(int i, String d, String info)
	{
		tm.addTicket(i, d, info, getCurrentTime());
	}

	public void delTicket(int i)
	{
		tm.delTicket(i);
	}

	public void updateTicket(int i)
	{
		tm.updateTicket(i);
	}

	public void status()
	{
		System.out.println("\nTOTAL # TICKETS: " + tm.getNumOfTickets());
		tm.getAllTicketInfo();
		System.out.println();
	}

	public void allOpenTickets()
	{
		tm.getAllOpenTickets();
	}

	public void allClosedTickets()
	{
		tm.getAllClosedTickets();
	}

	public void openDeptTickets(String d)
	{
		tm.getOpenDeptTickets(d);
	}

	public void closedDeptTickets(String d)
	{
		tm.getClosedDeptTickets(d);
	}

	public void checkDeptTickets(String d)
	{
		tm.getDeptTicketsInfo(d);
	}
}