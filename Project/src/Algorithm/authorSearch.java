package Algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class authorSearch {

    public static void authorName(LinkedList<yuanSu> mm) {
        Scanner input = new Scanner(System.in);
        System.out.println("please input the author name");
        String zuozhem = input.nextLine();

        yuanSu yuanSu1;
        for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext(); ) {
            yuanSu1 = kk.next();
            //System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getParagraph() + ", " + yuanSu1.getTitle() +", " + yuanSu1.getId() +">");
            //System.out.println("2");
            if (zuozhem.equalsIgnoreCase(yuanSu1.getAuthor())) {
                //System.out.println("33");
                System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getParagraph() + ", " + yuanSu1.getTitle() + ", " + yuanSu1.getId() + ">");
            }
        }
        System.out.println("2");

    }
}

