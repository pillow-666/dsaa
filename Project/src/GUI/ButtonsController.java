package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonsController {
    @FXML
    private Button study;

    @FXML
    private Button choose;

    @FXML
    private Button review;

    @FXML
    private Button myKnowledge;

    public ButtonsController() {

    }

    @FXML
    private void initialize() {

    }

    public Button getStudyButton() {
        return study;
    }

    public Button getChooseButton() {
        return choose;
    }

    public Button getReviewButton() {
        return review;
    }

    public Button getMyKnowledgeButton() {
        return myKnowledge;
    }


}
