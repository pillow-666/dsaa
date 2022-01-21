package Algorithm;

import com.spreada.utils.chinese.ZHConverter;

import java.util.Scanner;

public class ZTchange {
    public void Ztchange() {
        Scanner input = new Scanner(System.in);
        System.out.println("please input the jianti");
        String zt = input.nextLine();
        String TagTraditional = ZHConverter.convert(zt, ZHConverter.TRADITIONAL);

        System.out.println(TagTraditional);
    }
}
