package com.springbank.bankacc.query.api.handlers;

import com.springbank.bankacc.query.api.dto.AccountLookupResponse;
import com.springbank.bankacc.query.api.queries.FindAccountByHolderIdQuery;
import com.springbank.bankacc.query.api.queries.FindAccountByIdQuery;
import com.springbank.bankacc.query.api.queries.FindAccountWithBalanceQuery;
import com.springbank.bankacc.query.api.queries.FindAllAccountSQuery;

public interface AccountQueryHandler {

    AccountLookupResponse findAccountById(FindAccountByIdQuery account);
    AccountLookupResponse findAccountByHolderId(FindAccountByHolderIdQuery account);
    AccountLookupResponse findAllAccounts(FindAllAccountSQuery account);
    AccountLookupResponse findAccountsWithdramBalance(FindAccountWithBalanceQuery account);

}
