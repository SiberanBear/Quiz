package Quiz;
import java.io.*;
import java.util.*;

public class Question 
{
	private String line;
	private BufferedReader reader;
	List<String> qwest = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
    
	
	
	public Question(String selectTheme) throws FileException 
	{
		Map<String, String> d = new HashMap<String, String>();
		d.put("1.txt", "1.матмех");
		d.put("2.txt", "2.география");
		Object [] s = d.keySet().toArray();
		String theme = null;
		if (d.get("1.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[1];
		else if (d.get("2.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[0];
		File filename1 = new File(theme);
		try {
			FileReader fr = new FileReader(filename1);
	        this.reader = new BufferedReader(fr);
		} catch (IOException e) {
			throw new FileException(e, e.getMessage());
		}
	}
		
	public List<String> getQwest()
	{
		return this.qwest;
	}
	
	public Map<String, Integer> getDict() throws FileException
	{	
		int count = 0;
		String lastQuest = null;
		int lastAnswer = 0;
		while(true) 
		{
			try 
			{
				this.line = this.reader.readLine();
			}
			catch (IOException e) 
			{
				throw new FileException(e, e.getMessage());
			}   
			if (this.line == null)
				break;
			if (this.line.length() == 1)
			{
				lastAnswer = Integer.parseInt(this.line);
				count++;
			}
        	else 
        	{	
        		this.qwest.add(this.line);
        		lastQuest = this.line;
        		count++;
        	}
			if (count % 2 == 0)
				this.dict.put(lastQuest, lastAnswer);
			
		}
		return dict;
	}
}
