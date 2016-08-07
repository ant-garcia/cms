import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeManager
{
	private int numOfEmployees;
	//private HashMap<String, ArrayList<Employee>> EmpList;
	private ArrayList<DeptList> dLists;
	private DeptList deptList;

	public EmployeeManager()
	{
		this.dLists = new ArrayList<DeptList>();
	}

	public EmployeeManager(DeptList l)
	{
		this.dLists = new ArrayList<DeptList>();
		this.deptList = l;
	}

	public EmployeeManager(ArrayList<DeptList> lists)
	{
		this.dLists = lists;
	}

	public boolean isEmpty()
	{
		return dLists.isEmpty();
	}

	public ArrayList<DeptList> getAllDepts()
	{
		return this.dLists;
	}

	public DeptList getDept()
	{
		return this.deptList;
	}

	public void createDept(String s)
	{
		this.deptList = new DeptList(s);
		this.dLists.add(this.deptList);
	}

	public boolean deleteDept(String s)
	{
		for(DeptList l : dLists)
			if(l.getName().equalsIgnoreCase(s))
			{
				l.clearDept();
				dLists.remove(l);
				return true;
			}

		return false;
	}

	public void assignDept(String s)
	{
		if(this.dLists.isEmpty())
		{
			createDept(s);
			return;
		}

		for(DeptList dl : dLists)
			if(dl.getName().equalsIgnoreCase(s))
			{
				this.deptList = dl;
				return;
			}

		System.out.println("ERROR: The department you are looking for does not exist!");
	}

	public Employee createEmp(int i, String s, String dept)
	{
		return new Employee(i, s, new Date().toString(), dept);
	}

	public void addEmp(Employee e)
	{
		for(DeptList l : dLists)
		{
			if(l.getName().equalsIgnoreCase(e.getDepartment()))
			{
				l.addEmp(e);
				return;
			}
		}

		System.out.println("Creating new Department for Employee");
		createDept(e.getDepartment());
		this.deptList.addEmp(e);
	}

	public void delEmp(Employee e)
	{
		for(DeptList l : dLists)
		{
			if(l.getName().equalsIgnoreCase(e.getDepartment()))
			{
				l.delEmp(e);
				return;
			}
		}
	}

	public void delEmp(int i)
	{
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				l.delEmp(l.getEmp(i));
	}

	public void updateEmpPunchIn(int i)
	{
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				l.getEmp(i).setLastPunchIn(new Date().toString());
	}

	public void updateEmpPunchOut(int i)
	{
		for(DeptList l : dLists)
			if(l.containsEmp(i))
			{
				l.getEmp(i).setLastPunchOut(new Date().toString());
				updateEmpHrsWorked(l.getEmp(i));
				updateEmpTimeOff(l.getEmp(i));
			}
	}

	private void updateEmpTimeOff(Employee e)
	{
		e.setTimeOff(e.getTimeOff() + (e.getHoursWorked() / 24));
	}

	private void updateEmpHrsWorked(Employee e)
	{
		try
		{
			Date ds = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(e.getLastPunchIn());
			Date de = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(e.getLastPunchOut());
			double diff = (de.getTime() - ds.getTime()) / (3600 * 1000);
			e.setHoursWorked(e.getHoursWorked() + diff);
		}catch (ParseException pe) 
		{
			System.out.println("ERROR: The dates were not able to be parsed!");
		}
	}

	public void checkAllDeptStatus()	
	{
		for(DeptList l : this.dLists)
			l.deptInfo();
	}

	public boolean containsId(int i)
	{
		for(DeptList l : dLists)
			if(l.containsEmp(i))
				return true;
		return false;
	}

	public int getNumofEmployees()
	{
		int num = 0;
		for(DeptList l : dLists)
			num += l.size();
		return num;
	}
}