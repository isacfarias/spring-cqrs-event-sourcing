package com.springbank.bankacc.cmd.api.controllers;


import com.springbank.bankacc.cmd.api.commands.OpenAccountCommand;
import com.springbank.bankacc.cmd.api.dto.OpenAccountRespoonse;
import com.springbank.bankacc.core.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/openBankAccount")
public class OpenAccountController {

    private final CommandGateway commandGateway;
    @Autowired
    public OpenAccountController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> openAccount(@Valid @RequestBody OpenAccountCommand command) {
        var id = UUID.randomUUID().toString();
        command.setId(id);
        try {
            commandGateway.send(command);
            return new ResponseEntity<>(new OpenAccountRespoonse(id, "successfully opened a new bank account!"), HttpStatus.CREATED);
        } catch (Exception e) {
            var safeErrorMessage = "Error wile processing request to open a new bak account for id - ".concat(id);
            log.error(safeErrorMessage);
            return new ResponseEntity<>(new OpenAccountRespoonse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
