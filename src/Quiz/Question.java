package Quiz;
import java.io.*;
import java.util.*;

public class Question 
{
	public String line;
	public BufferedReader reader;
	ArrayList<String> qwest = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();
    HashMap<String, Integer> dict = new HashMap<String, Integer>();
	
	public Question(String filename) throws IOException 
	{
		File filename1 = new File(filename);
		FileReader fr = new FileReader(filename1);
        this.reader = new BufferedReader(fr);
        this.line = this.reader.readLine();
        
	}
	
	public ArrayList<String> getQwest()
	{
		return this.qwest;
	}
	
	public HashMap<String, Integer> getDict() throws IOException
	{	
		while(this.line != null) 
		{
			if (this.line.length() == 1)
        		this.answer.add(this.line);
        	else
        		this.qwest.add(this.line);
        	this.line = this.reader.readLine();
		}
		
        for (int i = 0; i < this.qwest.size(); i++)
        	this.dict.put(this.qwest.get(i), Integer.parseInt(this.answer.get(i)));
        return dict;
	}
}
