package com.sort.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/11/21:31
 */

@Component
public class RestTemplateUtil {

    private static final int CONNECT_TIMEOUT = 5000; // 连接超时时间
    private static final int READ_TIMEOUT = 5000; // 读取超时时间

    private RestTemplate restTemplate;

    public RestTemplateUtil() {
        // 创建 RestTemplate 实例
        restTemplate = new RestTemplate ();

        // 设置请求工厂，用于处理HTTPS请求
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory ();
        requestFactory.setBufferRequestBody(false);  // 可选的设置，用于支持大文件上传

        // 设置连接超时和读取超时时间
        requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
        requestFactory.setReadTimeout(READ_TIMEOUT);

        // 应用请求工厂设置到 RestTemplate
        restTemplate.setRequestFactory(requestFactory);
    }

    public <T> T get(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType);
        System.out.println (responseEntity );
        System.out.println (responseEntity.getBody () );
        return responseEntity.getBody();
    }

    public <T> T get(String url, Class<T> responseType, Map<String, ?> uriVariables) {
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType, uriVariables);
        return responseEntity.getBody();
    }

//    public <T> List<T> getList(String url,Class<T> responseType) {
//        ResponseEntity<Map<String, List<T>>> responseEntity = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Map<String, List<T>>>() {}
//        );
//
//        Map<String, List<T>> responseBody = responseEntity.getBody();
//        if (responseBody != null && responseBody.containsKey("data")) {
//            return responseBody.get("data");
//        } else {
//            // 处理没有 "records" 键的情况，返回空列表或抛出异常，具体取决于你的需求
//            return Collections.emptyList ();
//        }
//    }

    public <T> T post(String url, Class<T> responseType, Map<String, ?> uriVariables, MultiValueMap<String, String> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType, uriVariables);
        return responseEntity.getBody();
    }
}

