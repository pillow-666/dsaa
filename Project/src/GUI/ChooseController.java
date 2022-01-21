package GUI;

import Algorithm.fileNameInput;
import Algorithm.jsonjiexi;
import Algorithm.yuanSu;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class ChooseController {
    LinkedList<yuanSu> temp = new LinkedList<yuanSu>();
    LinkedList<yuanSu> library = new LinkedList<yuanSu>();
    LinkedList<yuanSu> newStudy = new LinkedList<yuanSu>();
    static LinkedList<yuanSu> studyList = new LinkedList<yuanSu>();
    LinkedList<yuanSu> todayStudy = new LinkedList<yuanSu>();
    String result = "";
    int number = 0;

    @FXML
    private TextField howMany;

    @FXML
    private TextField textField;

    @FXML
    private TextArea show;


    public ChooseController() {

    }

    @FXML
    public void initialize() {
        howMany.setPromptText("你今天想要学习多少首诗呢？");
        jsonjiexi a = new jsonjiexi();
        ArrayList<yuanSu> list = new ArrayList<yuanSu>();

        String filePathName = "D:\\Formal_Study\\Project\\src\\";
        fileNameInput getFileName = new fileNameInput();

        String[] filepath = getFileName.filePath(filePathName);

        list = a.newjiexi("poet.song.2000.json", list, "song");
        LinkedList<yuanSu> mm = new LinkedList<yuanSu>();
        for (yuanSu k : list) {
            mm.add(k);
        }


        temp = mm;
        library = new LinkedList<yuanSu>();
        int i = 0;
        while (temp.size() != 0 && i < 200) {
            int x = getRandomWord(temp);
            library.add(temp.get(x));
            temp.remove(temp.get(x));
            i++;
        }
        int j = 1;
        for (yuanSu b : library) {
            result += j + "." + b.getTitle() + "\t" + b.getAuthor() + "\n";
            j++;
        }
        show.setText(result);


    }

    public void setConfirm() {
        todayStudy.clear();
        result = "";
        int num1 = Integer.parseInt(howMany.getText());
//        newStudy = recommend2(library, newStudy,num1);
        for (int i = 0; i < num1; i++) {
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
            result += j + "." + a.getTitle() + "\t" + a.getAuthor() + "\n";
//            System.out.println(j + "." + a.getTitle() + "\t" + a.getAuthor());
            j++;
        }
        show.setText(result);

    }


    private static int getRandomWord(LinkedList<yuanSu> poem) {
        int indexBound;
        indexBound = poem.size();
        Random random = new Random();
        int index = random.nextInt(indexBound);
        return index;
    }

//    yuanSu a = newStudy.get(number);

    public void setBeginStudy() {

        result = "";
//        int length = newStudy.size();

        yuanSu a = newStudy.get(number);
        result = "<" + a.getAuthor() + "," + a.getTitle() + ", " + a.getParagraph()
                + a.getTags() + ">";

//            String change = input.next();
//            a.setDegree(change);

        show.setText(result);
//        number++;
    }


    public void setTotallyForget() {
        String change = "完全忘记";
        yuanSu a = newStudy.get(number);
        a.setDegree(change);
        studyList.add(a);
        newStudy.remove(a);
        todayStudy.add(a);
    }

    public void setForget() {
        String change = "丢三落四";
        yuanSu a = newStudy.get(number);
        a.setDegree(change);
        studyList.add(a);
        newStudy.remove(a);
        todayStudy.add(a);
    }

    public void setGood() {
        String change = "渐入佳境";
        yuanSu a = newStudy.get(number);
        a.setDegree(change);
        studyList.add(a);
        newStudy.remove(a);
        todayStudy.add(a);
    }

    public void setBest() {
        String change = "滚瓜烂熟";
        yuanSu a = newStudy.get(number);
        a.setDegree(change);
        studyList.add(a);
        newStudy.remove(a);
        todayStudy.add(a);
    }

    //反馈
    int count=0;
    public void setFeedbackAll() {
        count++;
        textField.setText(String.valueOf(count));
        String result = "";
//        feedBack(studyList);
        for (int i = 0; i < studyList.size(); i++) {
            result += studyList.get(i).getAuthor() + "\t" + studyList.get(i).getTitle() + "\t" + studyList.get(i).getDegree() + "\n";
//            System.out.println(studyList.get(i).getAuthor() + studyList.get(i).getTitle() + studyList.get(i).getDegree());
        }
        show.setText(result);
    }

    public void setFeedbackToday() {
        String result = "";
        for (int i = 0; i < todayStudy.size(); i++) {
            result += todayStudy.get(i).getAuthor() + "\t" + todayStudy.get(i).getTitle() + "\t" + todayStudy.get(i).getDegree() + "\n";
        }
        show.setText(result);
    }

    public static void feedBack(LinkedList<yuanSu> studyList) {


        LinkedList<yuanSu> list1 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list2 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list3 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list4 = new LinkedList<yuanSu>();

        LinkedList<yuanSu> list = new LinkedList<yuanSu>();
        // System.out.println(studyList.get(0));
      /*  list1 = keyDegree(studyList,"完全忘記");
        System.out.println("a");
        list2 = keyDegree(studyList,"丟三落四");
        System.out.println("b");
        list3 = keyDegree(studyList,"漸入佳境");
        System.out.println("c");
        list4 = keyDegree(studyList,"滾瓜爛熟");
        System.out.println("d");*/
        /*for (int i=0;i<studyList.size();i++) {
            switch (studyList.get(i).getDegree()) {
                case "完全忘記":
                    list1.add(studyList.get(i));
                    break;
                case "丟三落四":
                    list2.add(studyList.get(i));
                    break;
                case "漸入佳境":
                    list3.add(studyList.get(i));
                    break;
                case "滾瓜爛熟":
                    list4.add(studyList.get(i));
                    break;
            }
        }*/

//        for (yuanSu a : studyList) {
//
//            switch (a.getDegree()) {
//                case "完全忘記":
//                    list1.add(a);
//                    break;
//                case "丟三落四":
//                    list2.add(a);
//                    break;
//                case "漸入佳境":
//                    list3.add(a);
//                    break;
//                case "滾瓜爛熟":
//                    list4.add(a);
//                    break;
//            }
//        }


        /*for (yuanSu a : list1) {
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
        }*/

    }

    public static LinkedList<yuanSu> keyDegree(LinkedList<yuanSu> studyList, String degree) {
        LinkedList<yuanSu> temp = new LinkedList<yuanSu>();

        yuanSu yuanSu1;
        for (Iterator<yuanSu> kk = studyList.iterator(); kk.hasNext(); ) {
            yuanSu1 = kk.next();
            if (yuanSu1.getDegree().equalsIgnoreCase(degree)) {
                temp.add(yuanSu1);
                System.out.println(yuanSu1.getTitle() + yuanSu1.getAuthor() + yuanSu1.getDegree());
                System.out.println("2");

            } else {
                System.out.println("null");
            }


        }
        return temp;
    }
}
