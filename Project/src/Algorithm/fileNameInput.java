package Algorithm;

import java.io.File;

public class fileNameInput {

    //实现的功能
    public static String[] filePath(String filepath) {


        File file = new File(filepath);

        String[] filelist = file.list();
          /*  for(int i =0;i<filelist.length;i++) {
            	System.out.println(filelist[i]);
            }*/

        return filelist;
    }

}
