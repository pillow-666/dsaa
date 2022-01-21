package Algorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class splitInput {
	public String SplitInputOr(LinkedList<yuanSu> mm, String keynamedemo) {
		String[] tempLink = keynamedemo.split("or");
		keySearch keyname = new keySearch();
		String keynametemp = "";
		for (int i = 0; i < tempLink.length; i++) {
			LinkedList<yuanSu> Linktemp = new LinkedList<yuanSu>();
			Linktemp = keyName1(mm, tempLink[i]);
			yuanSu yuanSu;
			for (Iterator<yuanSu> kk = Linktemp.iterator(); kk.hasNext();) {
				yuanSu = kk.next();
				keynametemp += "<" +yuanSu.getAuthor()+", " + yuanSu.getTitle()   + ", " + yuanSu.getParagraph() +yuanSu.getTags() + ">" + "\n";
			}
		}
		//要改
		return keynametemp;
	}

	public String[] SplitInputAnd(LinkedList<yuanSu> mm, String keyName) {
		int counter =0;
		String[] tempA = keyName.split("and");
		String[] returnValue = new String[2];
		String keynametemp = "";
		LinkedList<yuanSu> finalLink = new LinkedList<yuanSu>();
		for (int i = 0; i < tempA.length; i++) {
//			LinkedList<yuanSu> tempLink = new LinkedList<yuanSu>();
//			tempLink = keyName1(mm, tempLink[i]);
			LinkedList<yuanSu> tempLink = new LinkedList<yuanSu>();
			yuanSu yuanSu1;
			for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext();) {
				yuanSu1 = kk.next();
				if (yuanSu1.getAuthor().indexOf(tempA[i]) != -1 || yuanSu1.getId().indexOf(tempA[i]) != -1
						|| yuanSu1.getTitle().indexOf(tempA[i]) != -1) {
					tempLink.add(yuanSu1);
					//counter=yuanSu1.getCount();
				} else if (yuanSu1.getParagraphs().size() != 0 && yuanSu1.getParagraph().indexOf(tempA[i]) != -1) {
					tempLink.add(yuanSu1);
					//counter=yuanSu1.getCount();
				} else if (yuanSu1.getTag() != null && yuanSu1.getTag().indexOf(tempA[i]) != -1) {
					tempLink.add(yuanSu1);
					//counter=yuanSu1.getCount();
				}
			}

			if (i == 0) {
				finalLink = tempLink;
			} else {
				finalLink = compareDoubleList(finalLink, tempLink);
			}
	}
		counter = finalLink.get(finalLink.size()-1).getCount();
		yuanSu yuanSu;
		for (Iterator<yuanSu> kk = finalLink.iterator(); kk.hasNext();) {
			yuanSu = kk.next();

			keynametemp += "<" +yuanSu.getAuthor()+", " + yuanSu.getTitle()   + ", " + yuanSu.getParagraph() +yuanSu.getTag() + ">" + "\n";
		}

		returnValue[0]=keynametemp;
		returnValue[1]=String.valueOf(counter);
		return returnValue;
	}

	public LinkedList<yuanSu> compareDoubleList(LinkedList<yuanSu> tempLink, LinkedList<yuanSu> newtemp) {
		LinkedList<yuanSu> temper = new LinkedList<yuanSu>();
		yuanSu yuansu1;
		for (Iterator<yuanSu> temp1 = tempLink.iterator(); temp1.hasNext();) {
			yuansu1 = temp1.next();
			yuanSu yuansu2;
			for (Iterator<yuanSu> temp2 = newtemp.iterator(); temp2.hasNext();) {
				yuansu2 = temp2.next();
				if (yuansu1.equals(yuansu2)) {
					temper.add(yuansu2);
				}
			}
		}

		return temper;

	}
	public LinkedList<yuanSu> newcompareDoubleList(LinkedList<yuanSu> tempLink, LinkedList<yuanSu> newtemp) {
		LinkedList<yuanSu> temper = new LinkedList<yuanSu>();
		yuanSu yuansu1;
		for (Iterator<yuanSu> temp1 = tempLink.iterator(); temp1.hasNext();) {
			yuansu1 = temp1.next();
			yuanSu yuansu2;
			for (Iterator<yuanSu> temp2 = newtemp.iterator(); temp2.hasNext();) {
				yuansu2 = temp2.next();
				if (yuansu1.equals(yuansu2)) {
					temper.add(yuansu2);

				}
			}
		}

		return temper;

	}
	public static LinkedList<yuanSu> keyName1(LinkedList<yuanSu> mm, String keyName) {
		LinkedList<yuanSu> tempLink = new LinkedList<yuanSu>();
		yuanSu yuanSu1;
		for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext();) {
			yuanSu1 = kk.next();
			if (yuanSu1.getAuthor().indexOf(keyName) != -1 || yuanSu1.getId().indexOf(keyName) != -1
					|| yuanSu1.getTitle().indexOf(keyName) != -1) {
				tempLink.add(yuanSu1);
			} else if (yuanSu1.getParagraphs().size() != 0 && yuanSu1.getParagraph().indexOf(keyName) != -1) {
				tempLink.add(yuanSu1);
			} else if (yuanSu1.getTag() != null && yuanSu1.getTag().indexOf(keyName) != -1) {
				tempLink.add(yuanSu1);
			}
		}

		return tempLink;
	}

}
