package Algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class keySearch {
    public static void keyName(LinkedList<yuanSu> mm) {
        Scanner input = new Scanner(System.in);
        System.out.println("please input the key name");
        String keyName = input.nextLine();

        yuanSu yuanSu1;
        for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext(); ) {
            yuanSu1 = kk.next();
            //System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getParagraph() + ", " + yuanSu1.getTitle() +", " + yuanSu1.getId() +">");
            //System.out.println("2");
            if (yuanSu1.getAuthor().indexOf(keyName) != -1 || yuanSu1.getId().indexOf(keyName) != -1 || yuanSu1.getTitle().indexOf(keyName) != -1 || yuanSu1.getTitle().indexOf(keyName) != -1) {
//                System.out.println("33");
                System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getParagraph() + yuanSu1.getTitle() + ", " + yuanSu1.getId() + ">");
            } else if (yuanSu1.getParagraphs().size() != 0 && yuanSu1.getParagraph().indexOf(keyName) != -1) {
//                System.out.println("33");
                System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getParagraph() + yuanSu1.getTitle() + ", " + yuanSu1.getId() + ">");
            }
        }
//        System.out.println("2");

    }



}
