package sample;

import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class ImageSorterService {

    ImageSorterData imageSorterData = new ImageSorterData();

    private ImageSorterValidator imageSorterValidator = new ImageSorterValidator();

    public void chooseOrgDir(Stage stage, TextField orgDirTxt){
        imageSorterData.orgDir = getDir(stage);
        orgDirTxt.setText(imageSorterData.orgDir.getAbsolutePath());
    }

    public void chooseTarDir(Stage stage, TextField tarDirTxt){
        imageSorterData.tarDir = getDir(stage);
        tarDirTxt.setText(imageSorterData.tarDir.getAbsolutePath());
    }

    public void goImgArrange(){
        imageSorterValidator.checkImagArrange(imageSorterData);
        File [] orgFiles =

    }

    private File getDir(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        return directoryChooser.showDialog(stage);
    }




}
