import java.util.ArrayList;

public class DeptList
{
	private String name;
	private ArrayList<Employee> empList;

	public DeptList(){}

	public DeptList(String s)
	{
		this.name = s;
		this.empList = new ArrayList<Employee>();
	}

	public DeptList(String s, ArrayList<Employee> l)
	{
		this.name = s;
		this.empList = l;
	}

	public void setName(String s)
	{
		this.name = s;
	}

	public String getName()
	{
		return this.name;
	}

	public void setEmpList(ArrayList<Employee> l)
	{
		this.empList = l;
	}

	public ArrayList<Employee> getEmpList()
	{
		return this.empList;
	}

	public void addEmp(Employee e)
	{
		this.empList.add(e);
	}

	public void delEmp(Employee e)
	{
		this.empList.remove(e);
	}

	public Employee getEmp(Employee e)
	{
		return this.empList.get(this.empList.indexOf(e));
	}

	public Employee getEmp(int i)
	{
		if(!containsEmp(i))
			return null;

		for(Employee e : this.empList)
			if(e.getId() == i)
				return e;

		return null;
	}

	public boolean containsEmp(int i)
	{
		for(Employee e : this.empList)
			if(e.getId() == i)
				return true;

		return false;
	}

	public void deptInfo()
	{
		System.out.println("\nNAME: " + this.name + "\n# OF EMPLOYEE'S: " + size());
		for(Employee e : this.empList)
			System.out.println(e.toString());
	}

	public void clearDept()
	{
		this.empList.clear();
	}

	public int size()
	{
		return this.empList.size();
	}
}