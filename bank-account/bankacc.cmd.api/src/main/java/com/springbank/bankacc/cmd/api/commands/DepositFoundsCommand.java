package com.springbank.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DepositFoundsCommand {

    @TargetAggregateIdentifier
    private String Id;
    private double amount;

}
