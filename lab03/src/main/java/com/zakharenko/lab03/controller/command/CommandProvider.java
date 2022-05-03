package com.zakharenko.lab03.controller.command;


import com.zakharenko.lab03.controller.command.impl.*;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    public CommandProvider(){
        repository.put(CommandName.CREATE_TABLE, new CreateTableCommand());
        repository.put(CommandName.ADD_TARIFF, new AddTariffCommand());
        repository.put(CommandName.REMOVE_TARIFF, new RemoveTariffCommand());
        repository.put(CommandName.SET_TARIFF, new SetTariffCommand());
        repository.put(CommandName.LOAD_FILE, new LoadTariffsFileCommand());
        repository.put(CommandName.SAVE_FILE, new SaveFileCommand());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    public Command getCommand(String name){
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (Exception e) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
