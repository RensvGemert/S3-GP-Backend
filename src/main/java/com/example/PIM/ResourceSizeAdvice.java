package com.example.PIM;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;

@ControllerAdvice
public class ResourceSizeAdvice implements ResponseBodyAdvice<Collection<?>> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //Checks if this advice is applicable.
        //In this case it applies to any endpoint which returns a collection.
        return Collection.class.isAssignableFrom(returnType.getParameterType());
    }


    @Override
    public Collection<?> beforeBodyWrite(Collection<?> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        response.getHeaders().add("x-total-count", String.valueOf(body.size()));
        response.getHeaders().add("access-control-expose-headers", "X-Total-Count");
        return body;
    }
}