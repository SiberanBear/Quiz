package Quiz;
import java.io.*;
import java.util.*;

public class Question 
{
	private String line;
	private BufferedReader reader;
	List<String> qwest = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
    Map<String, String> dictTheme = new HashMap<String, String>();
		
	public Question() {
		this.dictTheme.put("1.txt", "1.матмех");
		this.dictTheme.put("2.txt", "2.география");
	}
	
	public void readFile(String selectTheme) throws FileException {
		Object [] s = this.dictTheme.keySet().toArray();
		String theme = null;
		if (this.dictTheme.get("1.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[1];
		else if (this.dictTheme.get("2.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[0];
		else
			throw new FileException("Данная тематика не найдена");
		File filename = new File(theme);
		try {
			FileReader fr = new FileReader(filename);
	        this.reader = new BufferedReader(fr);
		} 
		catch (IOException e) {
			throw new FileException(e, e.getMessage());
		}	
	}
	public List<String> getQwest(){
		return this.qwest;
	}
	
	public Map<String, Integer> getDict() throws FileException
	{	
		int count = 0;
		String lastQuest = null;
		int lastAnswer = 0;
		while(true) {
			try{
				this.line = this.reader.readLine();
			}
			catch (IOException e) {
				throw new FileException(e, e.getMessage());
			}   
			if (this.line == null)
				break;
			if (this.line.length() == 1)
				lastAnswer = Integer.parseInt(this.line);
        	else {	
        		this.qwest.add(this.line);
        		lastQuest = this.line;
        	}
			count++;
			if (count % 2 == 0)
				this.dict.put(lastQuest, lastAnswer);
		}
		return dict;
	}
}
