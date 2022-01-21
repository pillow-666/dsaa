package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Study extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        //Load Buttons
        FXMLLoader ButtonsLoader = new FXMLLoader();
        ButtonsLoader.setLocation(ButtonsLoader.getClassLoader().getResource("GUI/Buttons.fxml"));
        AnchorPane Buttons = (AnchorPane) ButtonsLoader.load();

        //Load Study
        FXMLLoader StudyLoader = new FXMLLoader();
        StudyLoader.setLocation(StudyLoader.getClassLoader().getResource("GUI/Study.fxml"));
        AnchorPane Study = (AnchorPane) StudyLoader.load();

        //Load Choose
        FXMLLoader ChooseLoader = new FXMLLoader();
        ChooseLoader.setLocation(ChooseLoader.getClassLoader().getResource("GUI/Choose.fxml"));
        AnchorPane Choose = (AnchorPane) ChooseLoader.load();

        //加载Review
        FXMLLoader ReviewLoader = new FXMLLoader();
        ReviewLoader.setLocation(ReviewLoader.getClassLoader().getResource("GUI/Review.fxml"));
        AnchorPane Review = (AnchorPane) ReviewLoader.load();

        //加载Knowledge
        FXMLLoader KnowledgeLoader = new FXMLLoader();
        KnowledgeLoader.setLocation(KnowledgeLoader.getClassLoader().getResource("GUI/Knowledge.fxml"));
        AnchorPane Knowledge = (AnchorPane) KnowledgeLoader.load();

        //mainPane放置Buttons
        AnchorPane mainPane = new AnchorPane();
        mainPane.getChildren().add(Buttons);

        //secondPane放置功能区
        AnchorPane secondPane = new AnchorPane();
        secondPane.getChildren().add(Study);
        mainPane.getChildren().add(secondPane);

//        test.search();


        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("陪你学诗");
        primaryStage.show();


        //关闭请求
        /*primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });*/



        //设置文本区域
        StudyController studyController = (StudyController) StudyLoader.getController();
        studyController.getTextArea().setText("");

        //按钮设置
        ButtonsController buttonsController = (ButtonsController) ButtonsLoader.getController();
        //显示搜索界面
        buttonsController.getStudyButton().setOnAction(event -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().add(Study);

        });

        //显示学习界面
        buttonsController.getChooseButton().setOnAction(event -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().add(Choose);

        });

        //显示复习界面
        buttonsController.getReviewButton().setOnAction(event -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().add(Review);
        });

        //显示回顾界面
        buttonsController.getMyKnowledgeButton().setOnAction(event -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().add(Knowledge);
        });
    }

    //关闭窗口
    public void closeProgram() {
        Boolean answer = New_Alert_Window.display("关闭", "你确定要离开吗？");
        if (answer) {
            window.close();
        }
    }


}