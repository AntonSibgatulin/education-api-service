package jp.antonsibgatulin.educationapiservice.response.standarlone;

import jp.antonsibgatulin.educationapiservice.response.AResponse;

public class ResponseAccessDenied extends AResponse {

    public ResponseAccessDenied(){
        message = "FORBIDDEN";
        code = 401;
    }
}
