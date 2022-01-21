package Algorithm;

import com.spreada.utils.chinese.ZHConverter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//D:\dsaa\test
public class inputTxt {
public LinkedList<yuanSu> inputResult(LinkedList<yuanSu> mm) {
	LinkedList<yuanSu> resultStore =new LinkedList<yuanSu>();
	String resultSuccess ="";	
	String resultSorry   ="";
    BufferedReader reader = null;    
    try {  
        FileInputStream fileInputStream = new FileInputStream("D:\\Formal_Study\\Project\\src\\Algorithm\\poem75.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");  
        reader = new BufferedReader(inputStreamReader);  
        String tempString = null;  
       
        int countSorry =0;
        int countSuccess =0;
        while ((tempString = reader.readLine()) != null) {  
        	tempString =tempString.replaceAll("[\\s\\u00A0]", "");
        	tempString =tempString.replaceAll("\\d+","");
    		tempString = tempString.replaceAll("（","and");
    		tempString =tempString.replaceAll("）","and");
        	
            
            ZTchange ztt = new ZTchange();

            tempString = ZHConverter.convert(tempString, ZHConverter.TRADITIONAL);

            splitInput splitInput=new splitInput();
String[] tempot = splitInput.SplitInputAnd(mm,tempString);
            tempString=tempot[0];
            if(tempString =="") {
            	tempString ="Sorry";
            	//resultSorry +=tempString+"/n"; 
            	countSorry++;
            	System.out.println(countSorry);
            }else {
            	//resultSuccess +=tempString+"/n";
            	countSuccess++;
            	System.out.println(countSuccess);
            }           
        }  
//        yuanSu yuanSu1 = null;
//        yuanSu1.setId(resultSorry);
//        yuanSu1.setCount(countSorry);
//        resultStore.add(yuanSu1);
//        yuanSu yuanSu2 = null;
//        yuanSu2.setId(resultSuccess);
//        yuanSu2.setCount(countSuccess);
//        resultStore.add(yuanSu2);
        
        reader.close();  
    } catch (IOException e) {  
        e.printStackTrace();  
    } finally {  
        if (reader != null) {  
            try {  
                reader.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  	
	return resultStore;
}
}
