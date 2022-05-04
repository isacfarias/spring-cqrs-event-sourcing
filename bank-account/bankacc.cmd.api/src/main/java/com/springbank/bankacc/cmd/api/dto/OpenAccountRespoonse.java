package com.springbank.bankacc.cmd.api.dto;

import com.springbank.bankacc.core.dto.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OpenAccountRespoonse extends BaseResponse {

    private String id;

    public OpenAccountRespoonse(String id, String message) {
        super(message);
        this.id = id;
    }

}
