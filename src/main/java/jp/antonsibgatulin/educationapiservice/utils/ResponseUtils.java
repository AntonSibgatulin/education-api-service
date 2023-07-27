package jp.antonsibgatulin.educationapiservice.utils;

import jp.antonsibgatulin.educationapiservice.response.ResponseAccessDenied;
import jp.antonsibgatulin.educationapiservice.response.ResponseOK;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static ResponseEntity<ResponseAccessDenied> getAccessDenied() {
        return ResponseEntity.ok(new ResponseAccessDenied());
    }
    public static ResponseEntity getOK() {
        return ResponseEntity.ok(new ResponseOK());
    }
}
