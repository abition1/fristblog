package com.fbj.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig
{
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters()
    {
        FastJsonConfig conf = new FastJsonConfig();
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        convert.setFastJsonConfig(conf);
        return new HttpMessageConverters(convert);
    }
}