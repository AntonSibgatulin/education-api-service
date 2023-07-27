package jp.antonsibgatulin.educationapiservice.response;

public class ResponseAccessDenied extends AResponse{

    public ResponseAccessDenied(){
        message = "FORBIDDEN";
        code = 401;
    }
}
