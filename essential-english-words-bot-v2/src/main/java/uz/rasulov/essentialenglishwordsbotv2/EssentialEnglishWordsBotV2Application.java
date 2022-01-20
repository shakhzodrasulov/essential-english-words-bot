package uz.rasulov.essentialenglishwordsbotv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class EssentialEnglishWordsBotV2Application {
    private static TelegramBot telegramBot;

    public EssentialEnglishWordsBotV2Application(TelegramBot telegramBot) {
        EssentialEnglishWordsBotV2Application.telegramBot = telegramBot;
    }

    public static void main(String[] args) {
        SpringApplication.run(EssentialEnglishWordsBotV2Application.class, args);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
