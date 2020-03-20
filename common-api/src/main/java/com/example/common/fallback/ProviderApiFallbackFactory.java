package com.example.common.fallback;

import com.example.common.model.User;
import com.example.common.service.ProviderApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderApiFallbackFactory implements FallbackFactory<ProviderApi> {

    @Override
    public ProviderApi create(Throwable throwable) {
        return new ProviderApi(){

            @Override
            public User findUserById(Integer id) {
                User temp = new User();
                temp.setUserName("man");
                temp.setUserId(id);
                return temp;
            }
        };
    }
}
