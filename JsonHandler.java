import java.util.Map;
import java.util.HashMap;
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

	public boolean createBackup(HashMap<String, ArrayList<Ticket>> m, String s)
	{
		try
		{
			FileWriter out = new FileWriter(s + ".json");
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			out.write(gson.toJson(m));
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

	public boolean createPayrollBackup(HashMap<String, Double> m, String s)
	{
		try
		{
			FileWriter out = new FileWriter(s + ".json");
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			out.write(gson.toJson(m));
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

	public HashMap<String, ArrayList<Ticket>> loadBackup()
	{
		JsonElement je = null;
		try
		{
			ArrayList<JsonObject> list = new ArrayList<JsonObject>();
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			JsonReader reader = new JsonReader(new FileReader("Tickets.json"));
			reader.setLenient(true);
			je = gson.fromJson(reader, JsonElement.class);	
			reader.close();
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file was not able to be loaded");
			return null;
		}
		return parseTicketJsonObject(je.getAsJsonObject());
	}

	public HashMap<String, Double> loadPayrollBackup()
	{
		JsonElement je = null;
		try
		{
			ArrayList<JsonObject> list = new ArrayList<JsonObject>();
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.serializeNulls().create();
			JsonReader reader = new JsonReader(new FileReader("Payroll.json"));
			reader.setLenient(true);
			je = gson.fromJson(reader, JsonElement.class);	
			reader.close();
		}catch(IOException ioe)
		{
			System.out.println("ERROR: Backup file was not able to be loaded");
			return null;
		}
		return parsePayrollJsonObject(je.getAsJsonObject());
	}

	public DeptList parseJsonObject(JsonObject jo)
	{
		DeptList dl = new DeptList(jo.get("name").getAsString());
		JsonArray ja = jo.getAsJsonArray("empList");
		for(int i = 0; i < ja.size(); i++)
			dl.addEmp(new Employee(ja.get(i).getAsJsonObject().get("id").getAsInt(),
								   ja.get(i).getAsJsonObject().get("timeOff").getAsDouble(),
								   ja.get(i).getAsJsonObject().get("hrsWorked").getAsDouble(),
								   ja.get(i).getAsJsonObject().get("title").getAsString(),
								   ja.get(i).getAsJsonObject().get("dateStarted").getAsString(),
								   ja.get(i).getAsJsonObject().get("dateEnded").getAsString(),
								   ja.get(i).getAsJsonObject().get("lastPunchIn").getAsString(),
								   ja.get(i).getAsJsonObject().get("lastPunchOut").getAsString(),
								   ja.get(i).getAsJsonObject().get("department").getAsString()));
		return dl;
	}

	public HashMap<String, ArrayList<Ticket>> parseTicketJsonObject(JsonObject jo)
	{
		HashMap<String, ArrayList<Ticket>> m = new HashMap<String, ArrayList<Ticket>>();
		for(Map.Entry<String, JsonElement> v : jo.entrySet())
		{
			ArrayList<Ticket> l = new ArrayList<Ticket>();
			for(JsonElement e : v.getValue().getAsJsonArray())
			{
				l.add(new Ticket(e.getAsJsonObject().get("id").getAsInt(),
								 e.getAsJsonObject().get("isOpen").getAsBoolean(),
				 				 e.getAsJsonObject().get("information").getAsString(), 
				 				 e.getAsJsonObject().get("department").getAsString(),
				 				 e.getAsJsonObject().get("timeCreated").getAsString()));
			}
			m.put(v.getKey(), l);
		}
		return m;
	}

	public HashMap<String, Double> parsePayrollJsonObject(JsonObject jo)
	{
		HashMap<String, Double> m = new HashMap<String, Double>();
		for(Map.Entry<String, JsonElement> v : jo.entrySet())
			m.put(v.getKey(), v.getValue().getAsDouble());
		return m;
	}
}