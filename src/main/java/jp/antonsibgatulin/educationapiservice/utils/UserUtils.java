package jp.antonsibgatulin.educationapiservice.utils;

import jp.antonsibgatulin.educationapiservice.entity.user.User;
import org.springframework.security.core.Authentication;

public class UserUtils {

    public static User getUser(Authentication authentication) {
        if(authentication==null)return null;
        return (User) authentication.getPrincipal();
    }
}
