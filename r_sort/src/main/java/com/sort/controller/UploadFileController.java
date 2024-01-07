package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.util.SentenceRecognitionUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tencentcloudapi.asr.v20190614.AsrClient;
import com.tencentcloudapi.asr.v20190614.models.SentenceRecognitionRequest;
import com.tencentcloudapi.asr.v20190614.models.SentenceRecognitionResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tiia.v20190529.TiiaClient;
import com.tencentcloudapi.tiia.v20190529.models.DetectProductRequest;
import com.tencentcloudapi.tiia.v20190529.models.DetectProductResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/**
 * @author changing
 * @create 2021-12-26 13:13
 */
@RestController
@Api(description = "识别接口")
@RequestMapping("api/v1/recognize")
@CrossOrigin
public class UploadFileController {

    @PostMapping("/image")
    @ApiOperation(value = " 通过上传图像进行图像识别其垃圾分类")
    public R DetectProduct(@ApiParam(value = "base64编码") @RequestParam("imageBase64")String imgeBase64){
        System.out.println("----------------------------------------");
        System.out.println(imgeBase64);
        DetectProductResponse resp = null;
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKIDVqvjHaYFfqpa4IFvKSJtLbbKn44nFQKx", "OWNxHK6crpWw5xYsvhDTR8YgYAVZMs63");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tiia.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = new TiiaClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DetectProductRequest req = new DetectProductRequest();
            req.setImageBase64(imgeBase64);
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            resp = client.DetectProduct(req);
            // 输出json格式的字符串回包
            String data = DetectProductResponse.toJsonString(resp);
            System.out.println(data);
            System.out.println("-------------正常------------------------");
            return R.ok(data);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            System.out.println("-------异常----------------------------");
            return R.failed(e.toString());
        }
    }

    @PostMapping("/record")
    @ApiOperation(value = " 通过上传音频进行语音识别其垃圾分类")
    public R uploadRecord(@ApiParam(value = ".mp3格式音频文件")@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return R.failed("文件为空");
        }
        String key = UUID.randomUUID().toString();
        SentenceRecognitionUtil.upload(file.getInputStream(),key);
        URL url = SentenceRecognitionUtil.getObjectUrl(key);

        SentenceRecognitionResponse resp = null;
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKIDVqvjHaYFfqpa4IFvKSJtLbbKn44nFQKx", "OWNxHK6crpWw5xYsvhDTR8YgYAVZMs63");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("asr.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            AsrClient client = new AsrClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SentenceRecognitionRequest req = new SentenceRecognitionRequest();
            req.setProjectId(0L);
            req.setSubServiceType(2L);
            req.setEngSerViceType("16k_zh");
            req.setSourceType(0L);
            req.setUrl(url.toString());
            req.setVoiceFormat("mp3");
            req.setUsrAudioKey("test");
            // 返回的resp是一个SentenceRecognitionResponse的实例，与请求对象对应
            resp = client.SentenceRecognition(req);
            // 输出json格式的字符串回包
            String data = SentenceRecognitionResponse.toJsonString(resp);
            System.out.println( data);
            return R.ok(data);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return R.failed(e.toString());
        }
    }
}
