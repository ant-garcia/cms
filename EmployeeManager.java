import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

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
		/*if(!e.getDepartment().equalsIgnoreCase(deptList.getName()))
		{
			System.out.println("ERROR: This employee does not work in this department!");
			return;
		}
		System.out.println("ID: " + e.getId());
		this.deptList.addEmp(e);*/
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

		/*if(!e.getDepartment().equalsIgnoreCase(deptList.getName()))
		{
			System.out.println("ERROR: This employee does not work in this department!");
			return;
		}

		this.deptList.delEmp(e);*/
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
				l.getEmp(i).setLastPunchOut(new Date().toString());
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