package com.lucy.my_note_backend.error;

import com.lucy.my_note_backend.entity.JsonError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @see ErrorAttributes
 * @see ErrorProperties
 */
@Slf4j
@Controller
class CustomErrorController implements ErrorController {
    private final ErrorAttributes errorAttributes;

    @Value("${server.error.path:${error.path:/error}}")
    private String errorPath;


    public CustomErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("${server.error.path:${error.path:/error}}")
    public ResponseEntity<JsonError> handleError(HttpServletRequest request) {
        JsonError errorResponse = getErrorFromRequest(request);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }

    private JsonError getErrorFromRequest(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> errorRequest = getErrorAttributes(webRequest, false);

        int errorStatus = (int) errorRequest.get("status");
        String errorMessage =  errorRequest.get("error").toString();

        return new JsonError(errorStatus, errorMessage);
    }

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }

    @Override
    public String getErrorPath() {
        return this.errorPath;
    }
}
