package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;


import java.io.File;


public class Controller {

    Stage stage;

    @FXML
    protected TextField orgDirTxt;

    @FXML
    protected TextField tarDirTxt;

    @FXML
    protected TextArea logArea;

    private ImageSorterService imageSorterService;

    private ImageSorterValidator imageSorterValidator = new ImageSorterValidator();


    public void setStage(Stage stage){
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }

    public Controller(){
        System.out.println("controller 생성자");

        imageSorterService.setLogArea(logArea);
        imageSorterService.logArea.setText("controller 생성자");
    }

    public void openSelOrgDir(){
        logArea.setText("openSelOrgDir");
        imageSorterService.chooseOrgDir(stage, orgDirTxt);

    }

    public void openSelTarDir(){
        logArea.setText("openSelTarDir");
        imageSorterService.chooseTarDir(stage, tarDirTxt);
    }

    public void goImgArrange(){
        logArea.setText("goImgArrange");
        imageSorterService.goImgArrange();
    }

    public void cancle(){
        logArea.setText("cancle");
        System.exit(0);
    }

}
