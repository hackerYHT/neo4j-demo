package com.tao.neo4jdemo.Service.client;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.tao.neo4jdemo.constant.ConfigConstants.ADAPT_LIMIT_HTTP_CLIENT_CONN_TIMEOUT;
import static com.tao.neo4jdemo.constant.ConfigConstants.ADAPT_LIMIT_HTTP_CLIENT_READ_TIMEOUT;

@Slf4j
@Service
public class JsonHttpClient {
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    @Autowired
    private Environment environment;

    private OkHttpClient client;

    @PostConstruct
    public void initJsonHttpClient() {
        Integer connTimeout = environment.getProperty(ADAPT_LIMIT_HTTP_CLIENT_CONN_TIMEOUT, Integer.class, 8000);
        Integer readTimeout = environment.getProperty(ADAPT_LIMIT_HTTP_CLIENT_READ_TIMEOUT, Integer.class, 8000);
        client = new OkHttpClient.Builder().connectTimeout(connTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS).build();
    }

    public <T> T doGet(String url, Class<T> tClass) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        return executeCall(request, tClass);
    }

    public <T> T doGet(String url, TypeReference<T> typeReference) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        return executeCall(request, typeReference);
    }

    public <T> T get(String url, Map<String, String> headers, Class<T> tClass) throws IOException {
        Headers.Builder hb = new Headers.Builder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            hb.add(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder().url(url).headers(hb.build()).get().build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("code=" + response.code() + ", status=" + response.message() + response.body().string());
            }
            return JSON.parseObject(response.body().string(), tClass);
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }
    }

    public String doGet(String url, Map<String, String> requestHeaders) throws IOException {
        Headers.Builder hb = new Headers.Builder();
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            hb.add(entry.getKey(), entry.getValue());
        }
        Request request = new Request.Builder().url(url).headers(hb.build()).get().build();
        return executeCall(request);
    }

    public <T> T doPost(String url, Object requestBody, TypeReference<T> typeReference) throws IOException {
        String json = "";
        if (requestBody != null) {
            json = JSONUtil.toJsonStr(requestBody);
        }
        RequestBody body = RequestBody.create(JSON_TYPE, json);
        Request request = new Request.Builder().url(url).post(body).build();
        return executeCall(request, typeReference);
    }

    public <T> T doPost(String url, Map<String, String> requestHeaders, Object requestBody, Class<T> tClass) throws IOException {
        String json = "";
        if (requestBody != null) {
            json = JSONUtil.toJsonStr(requestBody);
        }
        RequestBody body = RequestBody.create(JSON_TYPE, json);
        Headers.Builder hb = new Headers.Builder();
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            hb.add(entry.getKey(), entry.getValue());
        }
        Request request = new Request.Builder().url(url).headers(hb.build()).post(body).build();
        return executeCall(request, tClass);
    }

    public String doPost(String url, Map<String, String> requestHeaders, Object requestBody) throws IOException {
        String json = "";
        if (requestBody != null) {
            json = JSONUtil.toJsonStr(requestBody);
        }
        RequestBody body = RequestBody.create(JSON_TYPE, json);
        Headers.Builder hb = new Headers.Builder();
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            hb.add(entry.getKey(), entry.getValue());
        }
        Request request = new Request.Builder().url(url).headers(hb.build()).post(body).build();
        return executeCall(request);
    }

    private String executeCall(Request request) throws IOException {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("code=" + response.code() + ", status=" + response.message());
            }
            return response.body().string();
        } catch (IOException e) {
            log.error("调用{}接口异常,", request.url(), e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }
    }

    private <T> T executeCall(Request request, Class<T> tClass) throws IOException {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("code=" + response.code() + ", status=" + response.message());
            }
            String body = response.body().string();
            return JSONUtil.toBean(body, tClass);
        } catch (IOException e) {
            log.error("调用{}接口异常,", request.url().toString(), e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }
    }

    private <T> T executeCall(Request request, TypeReference<T> typeReference) throws IOException {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("code=" + response.code() + ", status=" + response.message());
            }
            String body = response.body().string();
            return JSONUtil.toBean(body, typeReference, false);
        } catch (IOException e) {
            log.error("调用{}接口异常,", request.url().toString(), e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
