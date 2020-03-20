package com.example.consumer;

import com.example.common.service.ProviderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="provider")
public interface InvokeProvider extends ProviderApi {

}
