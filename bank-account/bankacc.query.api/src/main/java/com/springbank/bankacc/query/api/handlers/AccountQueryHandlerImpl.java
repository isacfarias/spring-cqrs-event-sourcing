package com.springbank.bankacc.query.api.handlers;

import com.springbank.bankacc.core.models.BankAccount;
import com.springbank.bankacc.query.api.dto.AccountLookupResponse;
import com.springbank.bankacc.query.api.dto.EqualityType;
import com.springbank.bankacc.query.api.queries.FindAccountByHolderIdQuery;
import com.springbank.bankacc.query.api.queries.FindAccountByIdQuery;
import com.springbank.bankacc.query.api.queries.FindAccountWithBalanceQuery;
import com.springbank.bankacc.query.api.queries.FindAllAccountSQuery;
import com.springbank.bankacc.query.api.repositories.AccountRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountQueryHandlerImpl implements AccountQueryHandler {

    private final AccountRepository repository;

    public AccountQueryHandlerImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountById(FindAccountByIdQuery query) {
        var bankAccount = repository.findById(query.getId());
        return  bankAccount.map(account -> new AccountLookupResponse(account, "Bank Account Sucessfully Returned!"))
                .orElseGet(() -> new AccountLookupResponse("No Bank Account Found for ID - ".concat(query.getId())));
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountByHolderId(FindAccountByHolderIdQuery query) {
        var bankAccount = repository.findByAccountHolderId(query.getAccountHolderId());
        return  bankAccount.map(account -> new AccountLookupResponse(account, "Bank Account Sucessfully Returned!"))
                .orElseGet(() -> new AccountLookupResponse("No Bank Account Found for Holder ID - ".concat(query.getAccountHolderId())));
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAllAccounts(FindAllAccountSQuery query) {
        var bankAccountIterator = repository.findAll();

        if (!bankAccountIterator.iterator().hasNext()) {
            return new AccountLookupResponse("No Bank Accounts were Found!");
        }

        var bankAccounts = new ArrayList<BankAccount>();
        bankAccountIterator.forEach(bankAccounts::add);

        return new AccountLookupResponse(bankAccounts, "Successfully Returned ".concat(bankAccounts.size()+"").concat(" Bank Accounts!"));
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountsWithdramBalance(FindAccountWithBalanceQuery query) {
        var bankAccounts = query.getEqualityType().equals(EqualityType.GREATER_THAN)
                ? repository.findByBalanceGreaterThan(query.getBalance())
                : repository.findByBalanceLessThan(query.getBalance());

        var response = bankAccounts != null && bankAccounts.size() > 0
                ? new AccountLookupResponse(bankAccounts, "Successfully Returned ".concat(bankAccounts.size()+"").concat(" Bank Accounts!"))
                : new AccountLookupResponse("No Bank Accounts were Found!");

        return response;
    }
}
