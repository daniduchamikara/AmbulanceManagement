package edu.sliit.ambulancemanagement.domain.http;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@Service
public class CommonJsonResponse implements Serializable {

    public CommonJsonResponse() {
    }

    private int status;
    private transient Object data;
    private String message;


    public CommonJsonResponse(int status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;

    }

}
