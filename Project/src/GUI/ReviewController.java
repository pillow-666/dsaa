package GUI;

import Algorithm.yuanSu;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class ReviewController {
    LinkedList<yuanSu> studyList = ChooseController.studyList;
    LinkedList<yuanSu> list = new LinkedList<yuanSu>();
    int count = 0;
    String result;
    @FXML
    private TextField howMany;

    @FXML
    private TextArea show;



    public ReviewController() {

    }

    @FXML
    public void initialize() {
        howMany.setPromptText("今天你想要复习多少首诗呢？");
    }

    public void setConfirm() {
        String result = "";
        int num = Integer.parseInt(howMany.getText());
        LinkedList<yuanSu> list1 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list2 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list3 = new LinkedList<yuanSu>();
        LinkedList<yuanSu> list4 = new LinkedList<yuanSu>();


        for (yuanSu a : studyList) {
            switch (a.getDegree()) {
                case "完全忘记":
                    list1.add(a);
                    break;
                case "丢三落四":
                    list2.add(a);
                    break;
                case "渐入佳境":
                    list3.add(a);
                    break;
                case "滚瓜烂熟":
                    list4.add(a);
                    break;
            }
        }
        int count = 1;
        int second = num / 3;
        int third = num / 4;
        int first = num - second - third;
        int i = 0;
        for (yuanSu a : list1) {

            if (i < first) {
                result += count + "  " + a.getAuthor() + '\t' + a.getTitle() + '\t' + a.getParagraph() + "\t" + a.getDegree() + "\n";
//                System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
//                studyList.remove(a);
                i++;
                count++;
                list.add(a);
            } else {
                break;
            }
        }
        i = 0;
        for (yuanSu a : list2) {
            if (i < second) {
                result += count + "  " + a.getAuthor() + '\t' + a.getTitle() + '\t' + a.getParagraph() + "\t" + a.getDegree() + "\n";
//                System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
//                studyList.remove(a);
                i++;
                count++;
                list.add(a);
            } else {
                break;
            }
        }
        i = 0;
        for (yuanSu a : list3) {
            if (i < third) {
                result += count + "  " + a.getAuthor() + '\t' + a.getTitle() + '\t' + a.getParagraph() + "\t" + a.getDegree() + "\n";
//                System.out.println(count+"  "+a.getTitle() + '\t' + a.getAuthor() + '\t' + a.getDegree());
//                studyList.remove(a);
                i++;
                count++;
                list.add(a);
            } else {
                break;
            }

        }
        show.setText(result);

    }

    public void setBeginStudy() {
        result = list.get(count).getAuthor() + '\t' + list.get(count).getTitle() + '\t' + list.get(count).getParagraph() + "\t" + list.get(count).getDegree();
        show.setText(result);
//        System.out.println(list.get(count).getTitle()+ '\t' + list.get(count).getAuthor() + '\t' + list.get(count).getDegree());
    }

    public void setTotallyForget() {
        list.get(count).setDegree("完全忘记");
        count++;
    }

    public void setForget() {
        list.get(count).setDegree("丢三落四");
        count++;
    }

    public void setGood() {
        list.get(count).setDegree("渐入佳境");
        count++;
    }

    public void setBest() {
        list.get(count).setDegree("滚瓜烂熟");
        count++;
    }

    public void setFeedbackToday() {
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getAuthor() + '\t' + list.get(i).getTitle() + '\t' + list.get(i).getParagraph() + "\t" + list.get(i).getDegree()+"\n";
        }
        show.setText(result);
    }

}
