package GUI;

import Algorithm.yuanSu;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class KnowledgeController {
    @FXML
    private TextArea textArea;
    ArrayList<yuanSu> collect=StudyController.collect;

    LinkedList<yuanSu> studyList = ChooseController.studyList;

    String result = "\n您当前一共学习了";

    public KnowledgeController() {

    }

    @FXML
    private void initialize() {

    }

    public void showKnowledge() {
        String collection="您的收藏夹现在有"+collect.size()+"首诗！分别是\n";
        for(int i=0;i<collect.size();i++){
            collection+=collect.get(i).getAuthor()+"\t"+collect.get(i).getTitle()+"\t"+collect.get(i).getParagraph()+"\n";
        }
        int size = studyList.size();
        result += size + "首诗！\n";
        for (int i = 0; i < studyList.size(); i++) {
            result += (i + 1) + "\t" + studyList.get(i).getAuthor() + "\t" + studyList.get(i).getTitle() + "\t" + studyList.get(i).getParagraph() +
                    studyList.get(i).getDegree() + "\n";
        }
        textArea.setText(collection);
        textArea.appendText(result);

    }

    public void setSave() throws IOException {
        result = "您当前一共学习了";
        int size = studyList.size();
        result += size + "首诗！\n";
        for (int i = 0; i < studyList.size(); i++) {
            result += (i + 1) + "\t" + studyList.get(i).getAuthor() + "\t" + studyList.get(i).getTitle() + "\t" + studyList.get(i).getParagraph() +
                    studyList.get(i).getDegree() + "\n";
        }
        File file = new File("myKnowledge.txt");
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(result);
        fileWriter.close();

    }
}
