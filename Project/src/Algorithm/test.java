package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		jsonjiexi a = new jsonjiexi();
		ArrayList<yuanSu> list = new ArrayList<yuanSu>();
		
		Scanner input = new Scanner(System.in);
		String filePathName = "D:\\Formal_Study\\Project\\src\\";
		fileNameInput getFileName = new fileNameInput();

		String[] filepath = getFileName.filePath(filePathName);
		list = a.newjiexi("poet.song.2000.json", list,"song");
		LinkedList<yuanSu> mm = new LinkedList<yuanSu>();
		for (yuanSu k : list) {
			mm.add(k);
		};
		LinkedList<yuanSu> temp = new LinkedList<yuanSu>();
		LinkedList<yuanSu> library = new LinkedList<yuanSu>();
		LinkedList<yuanSu> newStudy = new LinkedList<yuanSu>();
		LinkedList<yuanSu> studyList = new LinkedList<yuanSu>();
		temp = mm;
		
		library = simulationStudy(temp);
		
		System.out.println("請輸入每天想要學習古詩的數目");
		int num1 = input.nextInt();
		newStudy = recommend2(library, newStudy,num1);
		studyList = reciteNewPoem(newStudy,studyList);
		System.out.println("请输入每天想要复习古诗的数目");
		int num2 = input.nextInt();
		LinkedList<yuanSu> reviewList = new LinkedList<yuanSu>();
		reviewList = reviewRecommend(studyList,num2);
		studyList = review(reviewList,studyList);
		feedBack(studyList);
		

		/*
		 * for (int i = 0; i < filepath.length; i++) { list = a.newjiexi(filepath[i],
		 * list); }
		 */
		}

//1、顯示學習模擬全部詩列表
	public static LinkedList<yuanSu> simulationStudy(LinkedList<yuanSu> temp) {

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

	private static int getRandomWord(LinkedList<yuanSu> poem) {
		 int indexBound;
	     indexBound = poem.size();//确定长度
	     Random random = new Random();
	     int index = random.nextInt(indexBound);//随机生成序号
	     return index;

	    }
	
	//推薦新學習詩詞
	public static LinkedList<yuanSu> recommend2(LinkedList<yuanSu> library, LinkedList<yuanSu> newStudy,int num) {
		
		for (int i = 0; i < num; i++) {
			if (i <= library.size()) {
				int x = getRandomWord(library);
				newStudy.add(library.get(x));
				library.remove(x);
			} else {
				break;
			}
		}
		int j = 1;
		for (yuanSu a : newStudy) {

			System.out.println(j + "." + a.getTitle() + "\t" + a.getAuthor());
			j++;
		}
		return newStudy;
	}
	//背誦新詩詞
	public static LinkedList<yuanSu> reciteNewPoem(LinkedList<yuanSu> newStudy, LinkedList<yuanSu> studyList) {
	
		Scanner input = new Scanner(System.in);
		int length = newStudy.size();
		for (int i = 0;i < length ;i++) {
			yuanSu a = newStudy.getFirst();
			System.out.println("<" + a.getAuthor() + "," + a.getTitle() + ", " + a.getParagraph()
			+a.getTags()  + ">");
			String change = input.next();
			a.setDegree(change);
			studyList.add(a);
			newStudy.remove(a);
		}
		return studyList;
	}
	
//顯示要複習的詩以及熟練程度
	public static LinkedList<yuanSu> reviewRecommend(LinkedList<yuanSu> studyList, int num) {
		LinkedList<yuanSu> list1 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list2 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list3 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list4 = new LinkedList<yuanSu>();

		LinkedList<yuanSu> list = new LinkedList<yuanSu>();
		for (yuanSu a : studyList) {
			switch (a.getDegree()) {
			case "完全忘記":
				list1.add(a);
				break;
			case "丟三落四":
				list2.add(a);
				break;
			case "漸入佳境":
				list3.add(a);
				break;
			case "滾瓜爛熟":
				list4.add(a);
				break;
			}
		}
		int count = 1;
	    int second = num/3;
		int third = num /4;
		int first = num-second-third;
		int i = 0;
		for (yuanSu a : list1) {
			
			if (i < first) {
				System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
				studyList.remove(a);
				i++;
				count++;	
				list.add(a);
			}else {
				break;
			}
		}
		i = 0;
		for (yuanSu a : list2) {
			if (i < second) {
				System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
				studyList.remove(a);
				i++;
				count++;
				list.add(a);
			}else {
				break;
			}
		}
		i = 0;
		for (yuanSu a : list3) {
			if (i < third) {
				System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
				studyList.remove(a);
				i++;
				count++;
				list.add(a);
			}else {
				break;
			}

		}
		
		return list;

	}
	//背誦要複習的單詞
	public static LinkedList<yuanSu> review(LinkedList<yuanSu> list,LinkedList<yuanSu> studyList) {
		Scanner input = new Scanner(System.in);
		for (yuanSu a : list) {
			System.out.println("<" + a.getAuthor() + "," + a.getTags() + ", " + a.getParagraph()
			+ a.getTitle() + ", " + a.getId() + ">");		
			String change = input.next();
			a.setDegree(change);
			studyList.add(a);
		}
		
		return studyList;	
	}
	//反饋學習後新的熟練度
	public static void feedBack(LinkedList<yuanSu> studyList){
		LinkedList<yuanSu> list1 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list2 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list3 = new LinkedList<yuanSu>();
		LinkedList<yuanSu> list4 = new LinkedList<yuanSu>();

		LinkedList<yuanSu> list = new LinkedList<yuanSu>();
		for (yuanSu a : studyList) {
			switch (a.getDegree()) {
			case "完全忘記":
				list1.add(a);
				break;
			case "丟三落四":
				list2.add(a);
				break;
			case "漸入佳境":
				list3.add(a);
				break;
			case "滾瓜爛熟":
				list4.add(a);
				break;
			}
		}
		int count = 0;
		
		for (yuanSu a : list1) {
			count++;
			System.out.println(count+". "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
		}
		for (yuanSu a : list2) {
			count++;
			System.out.println(count+". "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
		}
		for (yuanSu a : list3) {
			count++;
			System.out.println(count+". "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
		}
		for (yuanSu a : list4) {
			count++;
			System.out.println(count+". "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
		}

	}
}
