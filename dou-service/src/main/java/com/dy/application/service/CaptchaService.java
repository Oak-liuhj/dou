package com.dy.application.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: liuhj
 * @date: 2021/8/9 17:09
 */
public interface CaptchaService {

    /**
     * 根据上传不同类型图片进行识别
     *
     * @param file
     * @param captchaType
     * @return
     */
    String capture(MultipartFile file, String captchaType);
}
