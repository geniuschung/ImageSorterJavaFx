package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.*;

public class ImageSorterService {

    ImageSorterData imageSorterData = new ImageSorterData();
    File [] orgFiles;
    TextArea logArea;

    public void setLogArea(TextArea logArea) {
        this.logArea = logArea;
    }

    public TextArea getLogArea(){
        return this.logArea;
    }

    private ImageSorterValidator imageSorterValidator = new ImageSorterValidator();

    public void goImgArrange(){
        try {
            imageSorterValidator.checkImagArrange(imageSorterData);
            orgFiles = getImgFiles();
            for (File orgFile : orgFiles) {
                ImageSorterDataImgFile imageSorterDataImgFile =  new ImageSorterDataImgFile(orgFile);
                File tarDir = getTarDir(imageSorterDataImgFile);
                if(checkTarFile(orgFile, tarDir)) {
                    copyImgFile(orgFile, tarDir);
                    logArea.setText(orgFile.getName() + "복사");
                }else {
                    logArea.setText(orgFile.getName()+"존재함 skip");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public boolean checkTarFile(File orgFile, File tarDir){
        File tarFile = new File(tarDir,orgFile.getName());
        if(tarFile.exists()){
            return false;
        }
        return true;
    }


    public void copyImgFile(File orgFile, File targetLeafDir){
        File tarFile = new File(targetLeafDir,orgFile.getName());

        try{
            FileInputStream is = new FileInputStream(orgFile);
            FileOutputStream out = new FileOutputStream(tarFile);

            byte[] byteArray = new byte[1024];
            int readLength = 0 ;

            while ( (readLength = is.read(byteArray,0,byteArray.length)) != -1 ){
                out.write(byteArray, 0, readLength);
            }
            out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public File getTarDir(ImageSorterDataImgFile imageSorterDataImgFile){
        File targetLeafDir = new File(imageSorterData.getTarDir(),imageSorterDataImgFile.getCreateDt());
        if(!imageSorterData.getTarDir().exists()){
            imageSorterData.getTarDir().mkdir();
        }

        if(!targetLeafDir.exists()){
            targetLeafDir.mkdir();
        }

        return targetLeafDir;

    }

    public void chooseOrgDir(Stage stage, TextField orgDirTxt){
        imageSorterData.setOrgDir(getDir(stage));
        orgDirTxt.setText(imageSorterData.getOrgDir().getAbsolutePath());
    }

    public void chooseTarDir(Stage stage, TextField tarDirTxt){
        imageSorterData.setTarDir(getDir(stage));
        tarDirTxt.setText(imageSorterData.getTarDir().getAbsolutePath());
    }

    private File[] getImgFiles() {
        File [] orgFiles = imageSorterData.getOrgDir().listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean isImgFile = false;
                if(name.toUpperCase().endsWith("JPG") || name.toUpperCase().endsWith("JPEG")){
                    isImgFile = true;
                }
                return isImgFile;
            }
        });
        return orgFiles;
    }

    private File getDir(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        return directoryChooser.showDialog(stage);
    }




}
