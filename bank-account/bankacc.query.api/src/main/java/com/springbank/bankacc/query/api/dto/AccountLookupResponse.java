package com.springbank.bankacc.query.api.dto;

import com.springbank.bankacc.core.dto.BaseResponse;
import com.springbank.bankacc.core.models.BankAccount;
import lombok.Data;

import java.util.List;

@Data
public class AccountLookupResponse extends BaseResponse {

    private List<BankAccount> accounts;

    public AccountLookupResponse(String message) {
        super(message);
    }

    public AccountLookupResponse(List<BankAccount> accounts, String message) {
        super(message);
        this.accounts = accounts;
    }

    public AccountLookupResponse(BankAccount account, String message) {
        super(message);
        this.accounts = List.of(account);
    }
}
