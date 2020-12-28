package com.alexsander.bankapi.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseApi<T> {

    private T data;

    private List<String> errors;

    public ResponseApi() {

    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }

        return this.errors;
    }

    public void setErrors(List<String> errors){
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
