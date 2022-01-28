package uz.rasulov.eew_bot_v3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class EewBotV3Application {
    private static TelegramBot telegramBot;

    public EewBotV3Application(TelegramBot telegramBot) {
        EewBotV3Application.telegramBot = telegramBot;
    }

    public static void main(String[] args) {
        SpringApplication.run(EewBotV3Application.class, args);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
