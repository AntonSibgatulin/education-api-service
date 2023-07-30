package jp.antonsibgatulin.educationapiservice.response.standarlone;

import jp.antonsibgatulin.educationapiservice.response.AResponse;

public class ResponseNotFound extends AResponse {

    public ResponseNotFound() {
        message = "NOT_FOUND";
        code = 404;
    }
}
