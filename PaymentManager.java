import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

public class PaymentManager
{
	private JsonHandler jh;
	private ArrayList<DeptList> dLists;
	private HashMap<String, Double> wages;
	//private HashMap<String, Integer> salary;

	public PaymentManager()
	{
		this.jh = new JsonHandler();
		this.dLists = new ArrayList<DeptList>();
		this.wages = new HashMap<String, Double>();
		//this.salary = new HashMap<String, Integer>();
		loadFromFile();
	}

	private void loadFromFile()
	{
		jh.loadBackup(this.dLists);
		this.wages.putAll(jh.loadPayrollBackup());
	}

	public void saveToFile()
	{
		jh.createPayrollBackup(this.wages, "Payroll");
	}

	public String getCurrentTime()
	{
		return new Date().toString();
	}

	public void addTitle(String s, double i)
	{
		this.wages.put(s, i);
	}

	public void delTitle(String s)
	{
		this.wages.remove(s);
	}

	public void updateWage(String s, double i)
	{
		this.wages.put(s, i);
	}

	public double getWage(String s)
	{
		return wages.get(s);
	}

	public double getEmpHours(int i)
	{
		double hrs = 0;
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				hrs = l.getEmp(i).getHoursWorked();
		return hrs;
	}

	private void setEmpHours(int i)
	{
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				l.getEmp(i).setHoursWorked(0);
	}

	public double calcPay(int i)
	{
		double pay = getWage(getEmpTitle(i)) * getEmpHours(i);
		setEmpHours(i);
		return pay;
	}

	public String getEmpTitle(int i)
	{
		String title = "";
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				title = l.getEmp(i).getTitle();	
		return title;
	}

	public void checkEmpTime(int i)
	{
		if(dLists.isEmpty())
		{
			System.out.println("ERROR: The department is empty!");
			return;
		}

		for(DeptList l : dLists)
			if(l.containsEmp(i))
				System.out.println(l.getEmp(i).checkTimeOff());	
	}

	public void checkAllEmpTime()
	{
		if(dLists.isEmpty())
		{
			System.out.println("ERROR: The department is empty!");
			return;
		}

		for(DeptList l : dLists)
		{
			System.out.println("\nNAME: " + l.getName() + "\n# OF EMPLOYEE'S: " + l.size());
			for(Employee e : l.getEmpList())
				System.out.println(e.checkTimeOff());
		}			
	}

	public void checkWages()
	{
		for(String s : this.wages.keySet())
			System.out.println("TITLE: " + s + " WAGE: " + this.wages.get(s));
	}
}