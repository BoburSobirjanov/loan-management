package uz.com.brb.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardResponse<T> {

    private Status status;
    private String message;
    private T data;
}
