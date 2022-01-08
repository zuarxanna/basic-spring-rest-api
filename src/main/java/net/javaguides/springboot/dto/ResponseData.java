package net.javaguides.springboot.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<Data> {
         private boolean status;
         private List<String> message = new ArrayList<>();
         private Data payload;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Data getPayload() {
        return payload;
    }

    public void setPayload(Data payload) {
        this.payload = payload;
    }
}
