package bexysuttx.farmerTGBot.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import bexysuttx.farmerTGBot.repository.NewUserDAO;


@Service
public class Schreduler {
	
	@Autowired
	private NewUserDAO newUserHandler;


	@Scheduled(cron= "0 0 0/3 * * ?")
	public  void backupUsers() throws IOException {
			File  file = new File("user_chat_id.txt");
			System.out.println("Scheduled!");
			Path path = Paths.get(file.getPath());
			Files.write(path, newUserHandler.getUserChatId(), StandardCharsets.UTF_8);
			
	
	}
}
