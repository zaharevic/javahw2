package lesson2.hw;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class first {
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("C:\\Java\\lesson2\\hw\\firstdata.txt"));
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();
    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    String everything = sb.toString();
    br.close();
    String line1 = everything.replace("{", "");
    String line2 = line1.replace("}", "");
    String line3 = line2.replaceAll("\"", "");
    System.out.println(line3);
    StringBuilder result = new StringBuilder("select * from students where ");
    String[] arrayData = line3.split(",");
    for(int i = 0; i <arrayData.length; i++){
        String[] arrData = arrayData[i].split(":");
        if(arrData[1].equals("null") == false) {
            if (i != 0) {
                result.append(", ");
                result.append(arrData[0]);
                result.append(" = ");
                result.append(arrData[1]);
            } else {
                result.append(arrData[0]);
                result.append(" = ");
                result.append(arrData[1]);
            }
        }
    }
    System.out.println(result);
}   
}