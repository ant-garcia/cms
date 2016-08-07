import java.util.Date;

public class Employee
{
	private int id;
	private double timeOff;
	private double hrsWorked;
	private String title;
	private String dateStarted;
	private String dateEnded;
	private String lastPunchIn;
	private String lastPunchOut;
	private String department;

	public Employee(){}

	public Employee(int i, String s, String d, String dept)
	{
		this.id = i;
		this.title = s;
		this.dateStarted = d;
		this.dateEnded = "";
		this.lastPunchIn = "";
		this.lastPunchOut = "";
		this.department = dept;
	}

	public Employee(int i, double to, double hrs, String s, String ds,
				    String de, String lpi, String lpo, String dept)
	{
		this.id = i;
		this.timeOff = to;
		this.hrsWorked = hrs;
		this.title = s;
		this.dateStarted = ds;
		this.dateEnded = de;
		this.lastPunchIn = lpi;
		this.lastPunchOut = lpo;
		this.department = dept;
	}

	public void setId(int i)
	{
		this.id = i;
	}

	public int getId()
	{
		return this.id;
	}

	public void setTimeOff(double i)
	{
		this.timeOff = i;
	}

	public double getTimeOff()
	{
		return this.timeOff;
	}

	public void setHoursWorked(double i)
	{
		this.hrsWorked = i;
	}

	public double getHoursWorked()
	{
		return this.hrsWorked;
	}

	public void setTitle(String s)
	{
		this.title = s;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setDateStarted(String d)
	{
		this.dateStarted = d;
	}

	public String getDateStarted()
	{
		return this.dateStarted;
	}

	public void setDateEnded(String d)
	{
		this.dateEnded = d;
	}

	public String getDateEnded()
	{
		return this.dateEnded;
	}

	public void setLastPunchIn(String d)
	{
		this.lastPunchIn = d;
	}

	public String getLastPunchIn()
	{
		return this.lastPunchIn;
	}

	public void setLastPunchOut(String d)
	{
		this.lastPunchOut = d;
	}

	public String getLastPunchOut()
	{
		return this.lastPunchOut;
	}

	public void setDepartment(String s)
	{
		this.department = s;
	}

	public String getDepartment()
	{
		return this.department;
	}

	public String toString()
	{
		return "ID: " + this.id + "\nTITLE: " + this.title +
			   "\nDOE: " + this.dateStarted.toString() +
		       "\nDEPT: " + this.department +
		       "\nLAST PUNCH IN: " + this.lastPunchIn +
		       "\nLAST PUNCH OUT: " + this.lastPunchOut + 
		       "\nHOURS THIS WEEK: " + this.hrsWorked + 
		       "\nTIME-OFF HOURS: " + this.timeOff + "\n";
	}

	public String checkTimeOff()
	{
		return "ID: " + this.id + "\nHOURS OFF: " + this.timeOff + "\n";
	}
}