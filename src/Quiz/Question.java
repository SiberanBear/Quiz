package Quiz;
import java.io.*;
import java.util.*;

class Question
{
    private String line;
    private BufferedReader reader;
    List<String> theme = new ArrayList<>();
    List<String> qwest = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
    Map<String, String> dictTheme = new HashMap<String, String>();
    private String line1;
    private BufferedReader buf;

    Question() {
        this.theme.add("1.матмех");
        this.theme.add("2.география");
        this.dictTheme.put(this.theme.get(0), "1.txt");
        this.dictTheme.put(this.theme.get(1), "2.txt");
    }

    void readFile(String selectTheme) throws FileException {
        String theme;
        if (this.theme.get(0).contains(selectTheme))
            theme = this.dictTheme.get(this.theme.get(0));
        else if (this.theme.get(1).contains(selectTheme))
            theme = this.dictTheme.get(this.theme.get(1));
        else {
            System.out.println("Данная тематика не найдена");
            throw new FileException();
        }
        File filename = new File(theme);
        try {
            FileReader fr = new FileReader(filename);
            this.reader = new BufferedReader(fr);
        }
        catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            throw new FileException(e, e.getMessage());
        }
    }

    List<String> getQwest(){
        return this.qwest;
    }

    List<String> getAnswer(String file) throws FileException {
        List <String> answer = new ArrayList<>();
        File filename = new File(file);
        try {
            FileReader frr = new FileReader(filename);
            this.buf = new BufferedReader(frr);
        }
        catch(FileNotFoundException e) {
            System.out.println("Данный файл не найден");
            throw new FileException(e, e.getMessage());
        }
        while(true) {
            try {
                this.line1 = this.buf.readLine();
            }
            catch(IOException e) {
                System.out.println("Ошибка при чтении файла");
                throw new FileException(e, e.getMessage());
            }
            if (this.line1 == null)
                break;
            answer.add(this.line1);
        }
        return answer;
    }

    Map<String, Integer> getDict() throws FileException
    {
        int count = 0;
        String lastQuest = null;
        int lastAnswer = 0;
        while(true) {
            try{
                this.line = this.reader.readLine();
            }
            catch (IOException e) {
                System.out.println("Невозможно прочитать строку");
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
