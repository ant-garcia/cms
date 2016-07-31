import java.util.Arrays;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

public class JsonHandler
{

	public boolean createBackup(ArrayList<DeptList> dLists, String s)
	{
		try
		{
			FileWriter out = new FileWriter(s + ".json");
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			out.write(gson.toJson(dLists));
			out.flush();
			System.out.println("JSON to File creation was a success!");
			out.close();	
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file creation failure");
			return false;
		}
		return true;
	}

	public boolean loadBackup(ArrayList<DeptList> dLists)
	{
		try
		{
			ArrayList<JsonObject> list = new ArrayList<JsonObject>();
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			JsonReader reader = new JsonReader(new FileReader("Depts.json"));
			reader.beginArray();
			reader.setLenient(true);
			while(reader.hasNext())
			{
				JsonElement je = gson.fromJson(reader, JsonElement.class);
				list.add(je.getAsJsonObject());
			}
			reader.close();
			for(JsonObject j : list)
			{
				dLists.add(parseJsonObject(j));
			}
			System.out.println("Success: Backup file was able to be loaded!");
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file was not able to be loaded");
			return false;
		}
		return true;
	}

	/*public boolean test(ArrayList<DeptList> dLists)
	{
		try
		{
			ArrayList<JsonObject> list = new ArrayList<JsonObject>();
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			JsonReader reader = new JsonReader(new FileReader("Depts.json"));
			reader.beginArray();
			reader.setLenient(true);
			while(reader.hasNext())
			{
				JsonElement je = gson.fromJson(reader, JsonElement.class);
				list.add(je.getAsJsonObject());
			}
			reader.close();
			for(JsonObject j : list)
			{
				dLists.add(parseJsonObject(j));
			}
			System.out.println("Success: Backup file was able to be loaded!");
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file was not able to be loaded");
			return false;
		}
		return true;
	}*/

	public DeptList parseJsonObject(JsonObject jo)
	{
		DeptList dl = new DeptList(jo.get("name").getAsString());
		JsonArray ja = jo.getAsJsonArray("empList");
		for(int i = 0; i < ja.size(); i++)
			dl.addEmp(new Employee(ja.get(i).getAsJsonObject().get("id").getAsInt(),
								   ja.get(i).getAsJsonObject().get("status").getAsString(),
								   ja.get(i).getAsJsonObject().get("dateStarted").getAsString(),
								   ja.get(i).getAsJsonObject().get("dateEnded").getAsString(),
								   ja.get(i).getAsJsonObject().get("lastPunchIn").getAsString(),
								   ja.get(i).getAsJsonObject().get("lastPunchOut").getAsString(),
								   ja.get(i).getAsJsonObject().get("department").getAsString()));
		return dl;
	}

	/*public JSONObject getAllJSONObjects(ArrayList<DeptList> dLists)
	{
		JSONObject company = new JSONObject();
		JSONObject dept = new JSONObject();
		company.put("list", "?!");
		for(DeptList l : dLists)
		{
			dept.put("Name", l.getName());
			dept.put("Employees", parseEmployeeList(l.getEmpList()));
		}
		company.put("Depts", dept);
		return company;
	}*/

	/*public JSONObject getJSONObject(DeptList l)
	{
		JSONObject obj = new JSONObject();
		obj.put("Name", l.getName());
		obj.put(l.getName() + " list", parseEmployeeList(l));
		return obj;
	}

	private JSONArray parseEmployeeList(DeptList l)
	{
		JSONArray list = new JSONArray();
		for(Employee e : l.getEmpList())
			list.add(parseEmployee(e));
		return list;
	}

	private JSONObject parseEmployee(Employee e)
	{
		JSONObject obj = new JSONObject();
		obj.put("Id", e.getId());
		obj.put("Status", e.getStatus());
		obj.put("Department", e.getDepartment());
		obj.put("DOE", e.getDateStarted());
		obj.put("DOT", e.getDateEnded());
		obj.put("LPI", e.getLastPunchIn());
		obj.put("LPO", e.getLastPunchOut());
		return obj;
	}

	public boolean createBackupFile(JSONObject obj, String s)
	{
		try
		{
			FileWriter out = new FileWriter(s + ".txt");
			out.write(obj.toJSONString());
			System.out.println("JSON to File creation was a success!");
			System.out.println("\nJSON OBJECT: " + obj);
			out.flush();
			out.close();	
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file creation failure");
			return false;
		}
		return true;
	}

	public DeptList loadJSONFile(DeptList l, String s)
	{
		JSONParser parser = new JSONParser();
		try
		{
			Object o = parser.parse(new FileReader("DeptList.txt"));
			JSONObject jo = (JSONObject) o;

			DeptList l = new DeptList(jo.getString("Name"));
			JSONArray list = (JSONArray) jo.get(jo.get("Name") + " list");
			//for(JSONArray ja : jo.getJSONArray(jo.getString("Name") + " list"))
			for(Object d : list)
			{
				l.addEmp(new Employee(d.get("Id"), d.get("Status"), d.get("Department"),
									  d.get("DOE"), d.get("DOT"), d.get("LPI"), d.get("LPO")));
			}
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file was not able to be loaded");
		}
	}*/

	/*public File createJSONFile(JSONObject objs[])
	{
		File f = null;
		FileWriter fw = null;
		try
		{
			f = new File("pages.json");
			fw = new FileWriter(f);
			for(JSONObject obj : objs)
				fw.write(obj.toJSONString());
			fw.flush();
			fw.close();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return f;
	}*/

}