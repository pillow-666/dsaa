package Algorithm;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.*;
import java.util.*;

public class jsonjiexi {
    public static ArrayList<yuanSu> newjiexi(String filepath, ArrayList<yuanSu> list,String dynasty) {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
        InputStreamReader in = new InputStreamReader(is);
        JsonReader a = new JsonReader(in);
        list = readMessageArray(a, list, dynasty);
	
	/*for(yuanSu k:list) {
		System.out.println(k);
	}*/
    /*try {
    	a.beginArray();
    	while(a.hasNext()){
    		list.add(parseName(a));
    	}
    } catch (IOException e) {
    	e.printStackTrace();
    }
    */
        return list;
    }



    private static ArrayList<yuanSu> readMessageArray(JsonReader a, ArrayList<yuanSu> list,String dynasty) {


        try {
            a.beginArray();
            while (a.hasNext()) {
                list.add(readMessage(a, dynasty));
            }
            a.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static yuanSu readMessage(JsonReader a,String dynasty) {
        // TODO Auto-generated method stub

        yuanSu poem = new yuanSu();
        try {
            a.beginObject();
            while (a.hasNext()) {
                String atyuanSu = a.nextName();

                if ("author".equals(atyuanSu)) {
                    poem.setAuthor(a.nextString());
                } else if ("paragraphs".equals(atyuanSu) && a.peek() != JsonToken.NULL) {
                    poem.setParagraphs(readparagraph(a));
                } else if ("tags".equals(atyuanSu)) {
                    poem.setTags(readparagraph(a));
                } else if ("title".equals(atyuanSu)) {
                    poem.setTitle(a.nextString());
                } else if ("id".equals(atyuanSu)) {
                    poem.setId(a.nextString());
                } else {
                    a.skipValue();
                }
                poem.setDynasty(dynasty);
            }
            a.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return poem;
    }


    //��ȡparagraph����
    private static ArrayList<String> readparagraph(JsonReader a) {
        // TODO Auto-generated method stub
        ArrayList<String> paragraph = new ArrayList<String>();
        try {
            a.beginArray();
            while (a.hasNext()) {

                paragraph.add(a.nextString());

            }
            a.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraph;
    }


}
