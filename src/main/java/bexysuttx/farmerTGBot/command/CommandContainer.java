package bexysuttx.farmerTGBot.command;

import static bexysuttx.farmerTGBot.command.CommandName.*;

import java.util.HashMap;
import java.util.Map;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class CommandContainer {

	private final Map<String, Command> commMap;
	private final Command unkCommand;

	public CommandContainer(SendBotMessageService sendBotMessageService) {
		this.commMap = new HashMap<>();
		commMap.put(START.getCommandName(), new StartCommand(sendBotMessageService));
		commMap.put(STOP.getCommandName(), new StopCommand(sendBotMessageService));
		commMap.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
		commMap.put(NO.getCommandName(), new NoCommand(sendBotMessageService));
		commMap.put(HOWTO.getCommandName(), new HowToCommand(sendBotMessageService));
		commMap.put(FAQ.getCommandName(), new FAQCommand(sendBotMessageService));
		commMap.put(EXIT.getCommandName(), new ExitCommand(sendBotMessageService));
		commMap.put(CONTACT.getCommandName(), new ContactCommand(sendBotMessageService));
		commMap.put(CONTACTADM.getCommandName(), new ContactCommand(sendBotMessageService));
		commMap.put(HELPME.getCommandName(), new HelpmeCommand(sendBotMessageService));
		commMap.put(REF.getCommandName(), new RefCommand(sendBotMessageService));
		commMap.put(BUY.getCommandName(), new BuyCommand(sendBotMessageService));
		commMap.put(SPAM.getCommandName(), new AdmSpamCommand(sendBotMessageService));
		this.unkCommand = new UnknownCommand(sendBotMessageService);
	}

	public Command retrieveCommand(String commandIdentifier) {
		return commMap.getOrDefault(commandIdentifier, unkCommand);
	}

}
