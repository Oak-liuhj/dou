package com.dy.application.service.impl;

import cn.hutool.core.io.FileUtil;
import com.dy.application.service.CaptchaService;
import com.dy.exception.BizException;
import com.dy.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 图片识别实现类
 *
 * @author: liuhj
 * @date: 2021/8/9 17:11
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Override
    public String capture(MultipartFile multipartFile, String captchaType) {

        try {
            File file = FileUtils.multipartFileToFile(multipartFile);

            // 调用ocr服务

            FileUtil.del(file);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(e);
        }
        return null;
    }
}
