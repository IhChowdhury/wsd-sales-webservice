package com.wsdtest.salesservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommonContentResponse {
    private Object content;

    public static CommonContentResponse getCommonContentResponse(Object content){
        return new CommonContentResponse(content);
    }
}
