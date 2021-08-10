package com.dy.utils;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: liuhj
 * @date: 2021/8/9 17:24
 */
@Slf4j
public class FileUtils {

    /**
     * 文件转换
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {
        File toFile = null;
        if (file != null) {
            InputStream ins = file.getInputStream();
            toFile = FileUtil.file(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    /**
     * 获取流文件
     *
     * @param ins
     * @param file
     */
    private static void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e1) {
                log.error(e.getMessage(), e);
            }
            log.error(e.getMessage(), e);
        }
    }
}
