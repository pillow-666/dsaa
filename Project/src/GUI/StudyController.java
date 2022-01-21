package GUI;

import Algorithm.fileNameInput;
import Algorithm.jsonjiexi;
import Algorithm.splitInput;
import Algorithm.yuanSu;
import com.spreada.utils.chinese.ZHConverter;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class StudyController {
    static ArrayList<yuanSu> collect=new ArrayList<>();
    yuanSu temporary = new yuanSu();
    int count = 0;
    int tangCountPoem = 0;
    int songCountPoem = 0;
    String tangAuthor = "";
    String songAuthor = "";
    int tangCountAuthor = 0;
    int songCountAuthor = 0;
    int counter = 0;
    LinkedList<yuanSu> mm;
    String result = "";


    @FXML
    private TextArea textArea;

    @FXML
    private ImageView music;

    @FXML
    private TextField textField;

    @FXML
    private TextField searchAuthor;

    @FXML
    private Button search;

    @FXML
    private Button tag;

    @FXML
    private Label label;

    public StudyController() {

    }



    @FXML
    private void initialize() {

        //创建arraylist储存元素
        jsonjiexi a = new jsonjiexi();
        ArrayList<yuanSu> list = new ArrayList<>();



        String filePathName = "D:\\Formal_Study\\Project\\src\\";
        fileNameInput getFileName = new fileNameInput();

        String[] filepath = getFileName.filePath(filePathName);


        for (int i = 2; i < filepath.length; i++) {
            if (filepath[i].indexOf("song") != -1) {
                list = a.newjiexi(filepath[i], list, "song");
            } else if (filepath[i].indexOf("tang") != -1) {
                list = a.newjiexi(filepath[i], list, "tang");
            }
        }
        int count1 = 0;
        mm = new LinkedList<yuanSu>();
        for (yuanSu k : list) {
            k.setCount(count1);
            mm.add(k);
            count1++;
        }

        textField.setPromptText("随便搜搜看：");
        searchAuthor.setPromptText("搜作者：");
        label.setText("当前诗库空空如也，尝试搜索一下吧！");
    }


    public TextArea getTextArea() {
        return textArea;
    }

    public void setCollect(){
        collect.add(mm.get(counter));

    }

    public void setTag() {
        Stage stage = new Stage();
        AnchorPane anchorPane = new AnchorPane();
        TextField textField = new TextField();
        textField.setPromptText("请输入你想设置的标签：");
        textField.setFocusTraversable(false);
        Button delete=new Button("删除");
        Button button = new Button("确定");
        button.setOnAction(event -> {
//            System.out.println(counter);

            String tag = textField.getText();
            ArrayList<String> tagLink = new ArrayList<String>();
            if (mm.get(counter).getTags() == null) {
                tagLink.add(tag);
//                System.out.println(tagLink.get(0));
//                System.out.println("1");
            } else {
                tagLink = mm.get(counter).getTags();
                tagLink.add(tag);
//                System.out.println(tagLink.get(tagLink.size() - 1));
//
//                System.out.println("2");
            }
//            ArrayList<String> tagLink = mm.get(counter).getTags();
//            if(tagLink==null){
//                tagLink=new ArrayList<>();
//                tagLink.add(tag);
//            }
//            tagLink.add(tag);
//            System.out.println(tagLink.get(tagLink.size() - 1));
//            System.out.println(counter);
            mm.get(counter).setTags(tagLink);
//            System.out.println("3");
//            System.out.println(mm.get(counter).getTag());
//            System.out.println(mm.get(counter).getTitle() + mm.get(counter).getAuthor());
//            System.out.println("4");
            String tagText = "[";
            for (int i = 0; i < mm.get(counter).getTags().size(); i++) {
                tagText += mm.get(counter).getTags().get(i) + "  ";
            }
            tagText += "]";

            textArea.setText(tagText);
//            System.out.println();
        });

        delete.setOnAction(event -> {
            String tag = textField.getText();
            ArrayList<String> tagLink = new ArrayList<String>();
            if (mm.get(counter).getTags() == null) {
                tagLink.remove(tag);
            } else {
                tagLink = mm.get(counter).getTags();
                tagLink.remove(tag);
            }
            mm.get(counter).setTags(tagLink);
            String tagText = "[";
            for (int i = 0; i < mm.get(counter).getTags().size(); i++) {
                tagText += mm.get(counter).getTags().get(i) + "  ";
            }
            tagText += "]";

            textArea.setText(tagText);
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(textField, button,delete);
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane, 350, 50);
        stage.setScene(scene);
        stage.setTitle("标签设置");
        stage.show();
    }


    //  音乐播放
    public void Music() {

//        File file=new File("D:\\Formal_Study\\Project\\src\\GUI\\Pictures\\西江月.mp3");
//        String url=file.toURI().toString();
//        Media media=new Media(url);
//        MediaPlayer mediaPlayer=new MediaPlayer(media);
//        mediaPlayer.setVolume(10);
//        mediaPlayer.play();
//
//        System.out.println("jie");
    }

    //    搜索按钮
    @FXML
    public void search() throws IOException {

        String result = "";
//        //创建arraylist储存元素
//        jsonjiexi a = new jsonjiexi();
//        ArrayList<yuanSu> list = new ArrayList<>();
//
//
//        String filePathName = "D:\\Formal_Study\\Project\\src\\";
//        fileNameInput getFileName = new fileNameInput();
//
//        String[] filepath = getFileName.filePath(filePathName);
//
//
//        for (int i = 2; i < filepath.length; i++) {
//            if (filepath[i].indexOf("song") != -1) {
//                list = a.newjiexi(filepath[i], list, "song");
//            } else if (filepath[i].indexOf("tang") != -1) {
//                list = a.newjiexi(filepath[i], list, "tang");
//            }
//        }
//        int count1 = 0;
//        mm = new LinkedList<yuanSu>();
////        mm = new LinkedList<yuanSu>();
//        for (yuanSu k : list) {
//            k.setCount(count1);
//            mm.add(k);
//            count1++;
//        }
        yuanSu yuanSu1;

        if (!searchAuthor.getText().equals("")) {
            String temp = searchAuthor.getText();
            String keyName = ZHConverter.convert(temp, ZHConverter.TRADITIONAL);
            for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext(); ) {

                yuanSu1 = kk.next();
                if (yuanSu1.getAuthor().indexOf(keyName) != -1) {
                    result += "<" + yuanSu1.getAuthor() + ", " + yuanSu1.getTitle() + ", " + yuanSu1.getParagraph() + yuanSu1.getTags() + ">" + "\n";
//                    temporary = yuanSu1;
//                    counter = yuanSu1.getCount();
                }
            }
            if (result.equals("")) {
                result = "抱歉，未找到相应结果";
            }
        } else {
            String temp = textField.getText();
            String keyName = ZHConverter.convert(temp, ZHConverter.TRADITIONAL);
            if (keyName.equalsIgnoreCase("")) {

                for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext(); ) {
                    yuanSu1 = kk.next();
                    if (yuanSu1.getDynasty().equals("song")) {
                        songCountPoem++;
                        if (!yuanSu1.getAuthor().equals(songAuthor)) {
                            songCountAuthor++;
                            songAuthor = yuanSu1.getAuthor();
                        }
                    } else if (yuanSu1.getDynasty().equals("tang")) {
                        tangCountPoem++;
                        if (!yuanSu1.getAuthor().equals(tangAuthor)) {
                            tangCountAuthor++;
                            tangAuthor = yuanSu1.getAuthor();
                        }
                    }
                    System.out.println("<" + yuanSu1.getAuthor() + ", " + yuanSu1.getTitle() + ", " + yuanSu1.getParagraph() + yuanSu1.getTags() + ">");
                    count++;
                }

            } else {
                if (keyName.indexOf("poem75") != -1) {
//                    inputTxt inputTxt = new inputTxt();
//                    LinkedList<yuanSu> txtStore = new LinkedList<yuanSu>();
//                    txtStore = inputTxt.inputResult(mm);
//                    System.out.println(txtStore.toString());
                    String fileName = "poem75.txt";
                    String tag=keyName.replaceAll("poem75","");
                    BufferedReader bf = new BufferedReader(new FileReader(fileName));
                    String textLine;
//                    String result="";
                    while ((textLine = bf.readLine()) != null) {
                        result += textLine +"\t"+tag +"\n";
                    }
                    textArea.setText(result);





                } else {
                    splitInput splitInput = new splitInput();
                    if (keyName.indexOf("and") != -1) {
                        String[] andGet = splitInput.SplitInputAnd(mm, keyName);
                        result = andGet[0];
                        counter = Integer.parseInt(andGet[1]);

                    } else if (keyName.indexOf("or") != -1) {
                        result = splitInput.SplitInputOr(mm, keyName);
                        System.out.println(result);
                    } else {
                        yuanSu yuanSuJ;
                        for (Iterator<yuanSu> kk = mm.iterator(); kk.hasNext(); ) {
                            yuanSuJ = kk.next();
                            if (yuanSuJ.getAuthor().indexOf(keyName) != -1 || yuanSuJ.getId().indexOf(keyName) != -1 || yuanSuJ.getTitle().indexOf(keyName) != -1) {
                                result += "<" + yuanSuJ.getAuthor() + ", " + yuanSuJ.getTitle() + ", " + yuanSuJ.getParagraph() + yuanSuJ.getTags() + ">" + "\n";
                                counter = yuanSuJ.getCount();
                            } else if (yuanSuJ.getParagraphs().size() != 0 && yuanSuJ.getParagraph().indexOf(keyName) != -1) {
                                result += "<" + yuanSuJ.getAuthor() + ", " + yuanSuJ.getTitle() + ", " + yuanSuJ.getParagraph() + yuanSuJ.getTags() + ">" + "\n";
                                counter = yuanSuJ.getCount();
                            } else if (yuanSuJ.getTag() != null && yuanSuJ.getTag().indexOf(keyName) != -1) {
                                result += "<" + yuanSuJ.getAuthor() + ", " + yuanSuJ.getTitle() + ", " + yuanSuJ.getParagraph() + yuanSuJ.getTags() + ">" + "\n";
                                counter = yuanSuJ.getCount();
                            }
                        }

                    }


                }
                if (result.equals("")) {
                    result = "抱歉，未找到相应结果";
                }

            }

        }

        label.setText("恭喜！当前诗库共有" + count + "首！诗人" + (tangCountAuthor + songCountAuthor) + "名!\n" + "其中唐代诗人" + tangCountAuthor + "名" + ",唐诗" +
                tangCountPoem + "首；" + "宋代诗人" + songCountAuthor + "名，宋诗" + songCountPoem + "首！"
        );


//        AnchorPane an=new AnchorPane();
//        TextArea textArea=new TextArea();
        textArea.setText(result);
        textArea.setEditable(false);
//        an.getChildren().add(textArea);
//
//        Scene scene=new Scene(an);
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();

    }


}
