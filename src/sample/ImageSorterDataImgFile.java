package sample;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Collection;

@Data
public class ImageSorterDataImgFile {
    public static final int TAG_TYPE_CREATE_DATE = 306;
    private File orgFile;
    private String createDt;


    public ImageSorterDataImgFile(File orgFile) throws Exception{
        Metadata metadata = JpegMetadataReader.readMetadata(new FileInputStream(orgFile));
        Iterable<Directory> iter = metadata.getDirectories();

        for(Directory dir : iter){
            Collection<Tag> tags = dir.getTags();
            for(Tag tag : tags){
                if(tag.getTagType() == this.TAG_TYPE_CREATE_DATE){
                    this.createDt = tag.getDescription().substring(0,10).replaceAll(":","-" );;
                    break;
                }
            }

            if (this.createDt == null){
                BasicFileAttributes attrs = Files.readAttributes(orgFile.toPath(), BasicFileAttributes.class);
                FileTime time = attrs.creationTime();
                this.createDt = time.toString().substring(0,10);
            }
        }
    }
}
