package Quiz;
import java.io.*;
import java.util.*;

public class Question 
{
	private String line;
	private BufferedReader reader;
	List<String> qwest = new ArrayList<>();
	List<Integer> answer = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
	
	public Question(int selectTheme) throws IOException 
	{
		String theme = null;
		if (selectTheme == 1)
			theme = "1.txt";
		else if (selectTheme == 2)
			theme = "2.txt";
		File filename1 = new File(theme);
//		if (!filename1.exists())
//			throw new MyException();
		FileReader fr = new FileReader(filename1);
//		if(!filename1.exists())
//			throw new MyException();
        this.reader = new BufferedReader(fr);
        this.line = this.reader.readLine();
	}
		
	public List<String> getQwest()
	{
		return this.qwest;
	}
	
	public Map<String, Integer> getDict() throws IOException
	{	
		String lastLine = null;
		while(this.line != null) 
		{
			if (this.line.length() == 1)
			{
				this.dict.put(lastLine, Integer.parseInt(this.line));
			}
        	else 
        	{	
        		this.qwest.add(this.line);
        		lastLine = this.line;
        	}
        	this.line = this.reader.readLine();
		}
		return dict;
	}
}
