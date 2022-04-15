package com.springbank.user.cmd.api.aggregates;

import com.springbank.user.cmd.api.commands.RegisterUserCommand;
import com.springbank.user.cmd.api.commands.RemoveUserCommand;
import com.springbank.user.cmd.api.commands.UpdateUserCommand;
import com.springbank.user.core.events.UserRegisteredEvent;
import com.springbank.user.core.events.UserRemovedEvent;
import com.springbank.user.core.events.UserUpdatedEvent;
import com.springbank.user.core.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String id;
    private User user;

    public UserAggregate() {}


    @CommandHandler
    public UserAggregate(RegisterUserCommand command) {
        var newUser = command.getUser();
        newUser.setId(command.getId());
        var password = newUser.getAccount().getPassword();
        var hashePassword =

    }

    @CommandHandler
    public void handler(UpdateUserCommand command) {

    }

    @CommandHandler
    public void handler(RemoveUserCommand command) {

    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event) {

    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event) {

    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event) {

    }

}
