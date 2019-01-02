package sample;
import javafx.scene.control.TextArea;
import lombok.Data;

import javax.xml.soap.Text;
import java.io.File;

@Data
public class ImageSorterData {
    private File orgDir;
    private File tarDir;
    private TextArea logArea;

/*
    public File getOrgDir() {
        return orgDir;
    }

    public File getTarDir() {
        return tarDir;
    }

    public void setOrgDir(File orgDir) {
        this.orgDir = orgDir;
    }

    public void setTarDir(File tarDir) {
        this.tarDir = tarDir;
    }
*/
}
