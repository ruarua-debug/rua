package Util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtilMap {
    public static void uploadFile(byte[] file,String filePath2,String fileName2) throws Exception{
        File targetFile = new File(filePath2);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName2);
        out.write(file);
        out.flush();
        out.close();
    }
    public static String getUpLoadFilePath(){
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File filePath2 = new File(path.getAbsolutePath(),"static/images/map");
        return filePath2.getAbsolutePath();
    }

}
