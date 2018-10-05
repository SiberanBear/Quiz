package Quiz;
import java.io.*;
import java.util.*;

public class Question 
{
	private String line;
	private String line1;
	private BufferedReader reader;
	private BufferedReader buf;
	List<String> qwest = new ArrayList<>();
	List<String> goodAnswer = new ArrayList<>(); 
	List<String> badAnswer = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
    Map<String, String> dictTheme = new HashMap<String, String>();
		
	public Question() 
	{
		this.dictTheme.put("1.txt", "1.матмех");
		this.dictTheme.put("2.txt", "2.география");
	}
	public void readFile(String selectTheme) throws FileException
	{
		Object [] s = this.dictTheme.keySet().toArray();
		String theme = null;
		if (this.dictTheme.get("1.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[1];
		else if (this.dictTheme.get("2.txt").contains(selectTheme.toLowerCase()))
			theme = (String)s[0];
		File filename1 = new File(theme);
		try {
			FileReader fr = new FileReader(filename1);
	        this.reader = new BufferedReader(fr);
		} 
		catch (IOException e) {
			throw new FileException(e, e.getMessage());
		}	
	}
	public List<String> getQwest(){
		return this.qwest;
	}
	
	 public List<String> getAnswer(String file) throws FileException {  
		 List <String> answer = new ArrayList<>();
		 File filename = new File(file); 
		 try {
			 FileReader frr = new FileReader(filename); 
			 this.buf = new BufferedReader(frr); 
		 }
		 catch(FileNotFoundException e) {
			 throw new FileException(e, e.getMessage()); 
		 }	 	
		 while(true) {  	 
			 try  {
				 this.line1 = this.buf.readLine();
			 }
			 catch(IOException e) {
				 throw new FileException(e, e.getMessage());
			 }
			 if (this.line1 == null)
				 break; 
			 answer.add(this.line1);  
		 }
		 return answer;
	 }
	
	public Map<String, Integer> getDict() throws FileException
	{	
		int count = 0;
		String lastQuest = null;
		int lastAnswer = 0;
		while(true) {
			try {
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
