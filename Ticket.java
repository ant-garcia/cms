public class Ticket
{
	private int id;
	private boolean isOpen;
	private String department;
	private String information;
	private String timeCreated;

	public Ticket(){}

	public Ticket(int i, boolean o, String info, String dept, String t)
	{
		this.id = i;
		this.isOpen = o;
		this.information = info;
		this.department = dept;
		this.timeCreated = t;
	}

	public Ticket(int i, String info, String dept, String t)
	{
		this.id = i;
		this.information = info;
		this.department = dept;
		this.isOpen = true;
		this.timeCreated = t;
	}

	

	public void setId(int i)
	{
		this.id = i;
	}

	public int getId()
	{
		return this.id;
	}

	public void setInfo(String i)
	{
		this.information = i;
	}

	public String getInfo()
	{
		return this.information;
	}

	public void setDept(String d)
	{
		this.department = d;
	}

	public String getDept()
	{
		return this.department;
	}

	public void setStatus(boolean s)
	{
		this.isOpen = s;
	}

	public boolean getStatus()
	{
		return this.isOpen;
	}

	public void setTimeCreated(String t)
	{
		this.timeCreated = t;
	}

	public String getTimeCreated()
	{
		return this.timeCreated;
	}

	public String toString()
	{
		return "ID: " + this.id + "\nOPEN: " + this.isOpen +
		       "\nDEPT: " + this.department +
		       "\nCREATED: " + this.timeCreated +
		       "\nINFO: " + this.information + "\n";
	}
}