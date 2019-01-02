package sample;

import javafx.fxml.FXML;
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

    private ImageSorterService imageSorterService = new ImageSorterService();

    private ImageSorterValidator imageSorterValidator = new ImageSorterValidator();


    public void setStage(Stage stage){
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }

    public void openSelOrgDir(){
        System.out.println("openSelOrgDir");
        imageSorterService.chooseOrgDir(stage, orgDirTxt);

    }

    public void openSelTarDir(){
        System.out.println("openSelTarDir");
        imageSorterService.chooseTarDir(stage, tarDirTxt);
    }

    public void goImgArrange(){
        System.out.println("goImgArrange");
        imageSorterService.goImgArrange();
    }

    public void cancle(){
        System.out.println("cancle");
        System.exit(0);
    }

}
