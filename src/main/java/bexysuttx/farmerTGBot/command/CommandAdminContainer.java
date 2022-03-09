package bexysuttx.farmerTGBot.command;


import static bexysuttx.farmerTGBot.command.CommandName.SPAM;


import java.util.HashMap;
import java.util.Map;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class CommandAdminContainer {
	
	private final Map<String, Command> commMap;
	private final Command unkCommand;

	public CommandAdminContainer(SendBotMessageService sendBotMessageService) {
		this.commMap = new HashMap<>();
		commMap.put(SPAM.getCommandName(), new AdmSpamCommand(sendBotMessageService));
		this.unkCommand = new UnknownCommand(sendBotMessageService);
	}

	public Command retrieveCommand(String commandIdentifier) {
		return commMap.getOrDefault(commandIdentifier, unkCommand);
	}


}
