package com.springbank.bankacc.cmd.api.commands;

import com.springbank.bankacc.core.models.AccountType;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class OpenAccountCommand {

    @TargetAggregateIdentifier
    private String Id;

    @NotNull(message = "no accouunt holder ID was supplied.")
    private String accountHolderId;

    @NotNull(message = "no accouunt type was supplied.")
    private AccountType accountType;

    @Min(value = 50, message = "opening balance must be at least 50.")
    private double openingBalance;
}
