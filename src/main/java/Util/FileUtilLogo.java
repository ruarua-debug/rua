package Util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtilLogo {
    public static void uploadFile(byte[] file,String filePath1,String fileName1) throws Exception{
        File targetFile = new File(filePath1);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName1);
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
        File filePath = new File(path.getAbsolutePath(),"static/images/logo");
        return filePath.getAbsolutePath();
    }

}
