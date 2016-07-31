import java.util.Date;

public class Employee
{
	private int id;
	private String status;
	private String dateStarted;
	private String dateEnded;
	private String lastPunchIn;
	private String lastPunchOut;
	private String department;

	public Employee(){}

	public Employee(int i, String s, String d, String dept)
	{
		this.id = i;
		this.status = s;
		this.dateStarted = d;
		this.dateEnded = "";
		this.lastPunchIn = "";
		this.lastPunchOut = "";
		this.department = dept;
	}

	public Employee(int i, String s, String ds, String de, String lpi, String lpo, String dept)
	{
		this.id = i;
		this.status = s;
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

	public void setStatus(String s)
	{
		this.status = s;
	}

	public String getStatus()
	{
		return this.status;
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
		return "ID: " + this.id + "\nSTATUS: " + this.status +
			   "\nDOE: " + this.dateStarted.toString() +
		       "\nDEPT: " + this.department +
		       "\nLAST PUNCH IN: " + this.lastPunchIn +
		       "\nLAST PUNCH OUT: " + this.lastPunchOut + "\n";
	}
}