package Algorithm;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class simulationStudy {
	//poem中存有所有古诗
    private static int getRandomWord(LinkedList<Node> poem) {
        int indexBound;
        indexBound = poem.size();//确定长度
        Random random = new Random();
        int index = random.nextInt(indexBound);//随机生成序号
        return index;

    }
    //显示学习模拟全部诗列表
    public static void simulationStudy(LinkedList<Node> temp, LinkedList<Node> poem) {
    	LinkedList<yuanSu> library = new LinkedList<yuanSu>();//设定存储链表
		int i = 0;
		while (temp.size() != 0 && i < 200) {
			int x = getRandomWord(temp);//从诗词库中随机生成一个序号
			library.add(temp.get(x));//在library链表中添加序号对应的古诗
			temp.remove(temp.get(x));//从temp中删除对应的古诗
			i++;
		}
		int j = 1;
		//将要学习模拟的诗依次打印出来
		for (yuanSu a : library) {
			System.out.println(j + "." + a.getTitle() + "\t" + a.getAuthor());
			j++;
		}
		//返回一个链表值
		return library;
}
