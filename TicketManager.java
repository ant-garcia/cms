import java.util.HashMap;
import java.util.ArrayList;

public class TicketManager
{
	private int count;
	private HashMap<String, ArrayList<Ticket>> tMap;

	public TicketManager()
	{
		this.tMap = new HashMap<String, ArrayList<Ticket>>();
	}

	public TicketManager(HashMap<String, ArrayList<Ticket>> m)
	{
		this.tMap = m;
	}

	public boolean isEmpty()
	{
		return this.tMap.isEmpty();
	}

	public HashMap<String, ArrayList<Ticket>> getAllTickets()
	{
		return this.tMap;
	}

	public void setAllTickets(HashMap<String, ArrayList<Ticket>> m)
	{
		this.tMap = m;
	}

	private boolean containsDept(String d)
	{
		return this.tMap.containsKey(d);
	}

	public ArrayList<Ticket> getDeptTickets(String n)
	{
		return this.tMap.get(n);
	}

	public boolean addTicket(int i, String d, String info, String t)
	{
		if(!containsDept(d))
			this.tMap.put(d, new ArrayList<Ticket>());
		return this.tMap.get(d).add(new Ticket(i, info, d, t));
	}

	public void delTicket(int i)
	{
		for(ArrayList<Ticket> l : this.tMap.values())
			for(Ticket t : l)
				if(t.getId() == i)
					l.remove(t);
	}

	public void updateTicket(int i)
	{
		for(ArrayList<Ticket> l : this.tMap.values())
			for(Ticket t : l)
				if(t.getId() == i)
					t.setStatus(!t.getStatus());
	}

	public int getNumOfTickets()
	{
		int num = 0;
		for(ArrayList<Ticket> l : this.tMap.values())
			num += l.size();
		return num;
	}

	public int getNumOfOpenTickets()
	{
		int num = 0;
		for(ArrayList<Ticket> l : this.tMap.values())
			for(Ticket t : l)
				if(t.getStatus())
					num++;
		return num;	
	}

	public int getNumOfClosedTickets()
	{
		int num = 0;
		for(ArrayList<Ticket> l : this.tMap.values())
			for(Ticket t : l)
				if(!t.getStatus())
					num++;
		return num;	
	}


	public void getAllTicketInfo()
	{
		for(ArrayList<Ticket> l : this.tMap.values())
		{
			System.out.println("\nNAME: " + l.get(0).getDept() + "\n# OF TICKETS: " + l.size());
			for(Ticket t : l)
				System.out.println(t.toString());
		}
	}

	public void getAllOpenTickets()
	{
		for(ArrayList<Ticket> l : this.tMap.values())
		{
			//if(hasOpenTickets(l.get(0).getDept()))
			//{
				System.out.println("\nNAME: " + l.get(0).getDept() + "\n# OF TICKETS: " + getNumOfOpenDeptTickets(l));
				for(Ticket t : l)
					if(t.getStatus())
						System.out.println(t.toString());	
			//}
		}	
	}

	public void getAllClosedTickets()
	{
		for(ArrayList<Ticket> l : this.tMap.values())
		{
			//if(!hasOpenTickets(l.get(0).getDept()))
			//{
			//	System.out.println("\nNAME: " + l.get(0).getDept() + "\n# OF TICKETS: " + getNumOfClosedDeptTickets(l));
				for(Ticket t : l)
					if(!t.getStatus())
						System.out.println(t.toString());	
			//}
		}	
	}

	public void getDeptTicketsInfo(String n)
	{
		if(!containsDept(n))
		{
			System.out.println("ERROR: The department you have entered does not exist!");
			return;
		}
		for(Ticket t : this.tMap.get(n))
			System.out.println(t.toString());
	}

	public boolean hasOpenTickets(String n)
	{
		for(Ticket t : this.tMap.get(n))
			if(t.getStatus())
				return true;
		return false;
	}

	public void getOpenDeptTickets(String n)
	{
		if(!containsDept(n) || !hasOpenTickets(n))
		{
			System.out.println("ERROR: The department you have entered" + 
			 				   "does not exist/have open tickets!");
			return;
		}
		for(Ticket t : this.tMap.get(n))
			if(t.getStatus())
				System.out.println(t.toString());
	}

	public void getClosedDeptTickets(String n)
	{
		if(!containsDept(n) || hasOpenTickets(n))
		{
			System.out.println("ERROR: The department you have entered" + 
			 				   "does not exist/have closed tickets!");
			return;
		}
		for(Ticket t : this.tMap.get(n))
			if(!t.getStatus())
				System.out.println(t.toString());
	}

	private int getNumOfOpenDeptTickets(ArrayList<Ticket> l)
	{
		int num = 0;
		for(Ticket t : l)
			if(t.getStatus())
				num++;
		return num;
	}

	private int getNumOfClosedDeptTickets(ArrayList<Ticket> l)
	{
		int num = 0;
		for(Ticket t : l)
			if(!t.getStatus())
				num++;
		return num;
	}
}