package Util;


import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtilAdmin {
    public static void uploadFile(byte[] file,String filePath4,String fileName4) throws Exception{
        File targetFile = new File(filePath4);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName4);
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
        File filePath = new File(path.getAbsolutePath(),"static/images/admin");
        return filePath.getAbsolutePath();
    }

}
