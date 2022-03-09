package bexysuttx.farmerTGBot.command;

import static bexysuttx.farmerTGBot.command.CommandName.HELP;
import static bexysuttx.farmerTGBot.command.CommandName.*;

import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class HelpCommand implements Command {

	   private final SendBotMessageService sendBotMessageService;

	   public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

	                   + "<b>Начать работу с ботом</b>\n"
	                   + "%s - начать работу со мной\n"
	                   + "%s - получить помощь в работе со мной\n"+
	                   "%s - контакты и отзывы\n",
	           START.getCommandName(), HELP.getCommandName(), CONTACTADM.getCommandName());

	   public HelpCommand(SendBotMessageService sendBotMessageService) {
	       this.sendBotMessageService = sendBotMessageService;
	   }

	   @Override
	   public void execute(Update update) {
	       sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
	   }
	}
