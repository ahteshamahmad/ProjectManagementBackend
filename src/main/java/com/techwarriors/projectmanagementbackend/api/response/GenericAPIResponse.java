package com.techwarriors.projectmanagementbackend.api.response;

public class GenericAPIResponse <T>{
    String message;
    T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
