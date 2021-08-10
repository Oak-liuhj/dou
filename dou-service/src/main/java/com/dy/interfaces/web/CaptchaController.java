package com.dy.interfaces.web;

import com.dy.application.service.CaptchaService;
import com.dy.enums.BizCodeAndMsgEnum;
import com.dy.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片识别
 *
 * @author: liuhj
 * @date: 2021/8/9 16:54
 */
@RestController
@RequestMapping(value = "/capture")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;


    /**
     * 根据上传不同类型图片进行识别
     *
     * @param file        文件
     * @param captchaType 识别类型
     * @return
     */
    @PostMapping(value = "/captureByType")
    public R capture(MultipartFile file, String captchaType) {
        String code = captchaService.capture(file, captchaType);
        return BizCodeAndMsgEnum.SUCCESS.toR(code);
    }

}
