import java.util.Date;
import java.util.ArrayList;

public class TimeClock
{
	EmployeeManager em;
	JsonHandler jh;

	public TimeClock()
	{
		em = new EmployeeManager();
		jh = new JsonHandler();
		loadFromFile(em.getAllDepts());
	}

	private void loadFromFile(ArrayList<DeptList> l)
	{
		jh.loadBackup(em.getAllDepts());
	}

	public void saveToFile()
	{
		jh.createBackup(em.getAllDepts(), "Depts");
	}

	public String getCurrentTime()
	{
		return new Date().toString();
	}

	public ArrayList<String> getDepartmentNames()
	{	
		ArrayList<String> names = new ArrayList<String>();

		if(em.isEmpty())
			System.out.println("ERROR: This list is empty!");
		else
		{
			for(DeptList l : em.getAllDepts())
			names.add(l.getName());
		}

		return names;
	}

	public void punchIn(int i)
	{
		if(em.containsId(i))
		{
			System.out.println("Success!");
			em.updateEmpPunchIn(i);
		}
		else
			System.out.println("ERROR: This specfic id is not found!");	
	}

	public void punchOut(int i)
	{
		if(em.containsId(i))
		{
			System.out.println("Success!");
			em.updateEmpPunchOut(i);
		}
		else
			System.out.println("ERROR: This specfic id is not found!");		
	}

	public void addEmp(int i, String s, String dept)
	{
		em.addEmp(em.createEmp(i, s, dept));
	}

	public void delEmp(int i)
	{
		em.delEmp(i);
	}

	public void addDept(String s)
	{
		em.createDept(s);
	}

	public void delDept(String s)
	{
		em.deleteDept(s);
	}

	public void status()
	{
		System.out.println("\nTOTAL # EMPLOYED: " + em.getNumofEmployees());
		em.checkAllDeptStatus();
		System.out.println();
	}
}