package bexysuttx.farmerTGBot.command;

public enum CommandName {

	START("/start"),
	STOP("/stop"),
	HELP("/help"),
	NO("/no"),
	HOWTO("Как это работает?"),
	FAQ("FAQ"),
	EXIT("Все понятно"),
	CONTACT("Контакты и отзывы"),
	CONTACTADM("/contact"),
	HELPME("/helpme"),
	REF("Реферальная система"),
	BUY("Купить"),
	SPAM("/spam");
	

	private final String commandName;

	private CommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

}
