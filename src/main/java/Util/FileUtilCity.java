package Util;


import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtilCity {
    public static void uploadFile(byte[] file,String filePath3,String fileName3) throws Exception{
        File targetFile = new File(filePath3);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName3);
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
        File filePath = new File(path.getAbsolutePath(), "static/Bootstrap2/img/");
        return filePath.getAbsolutePath();
    }

}

