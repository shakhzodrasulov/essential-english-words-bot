package uz.rasulov.essentialenglishwordsbotv2;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * Created by SHR on 12.01.2022
 */
public class Constants {
    public static String inProcess;

    private static SendMessage sendMessage;

    public static SendMessage getSendMessage(String text, String chatId){
        if (sendMessage == null) {
            sendMessage = new SendMessage();
        }
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);

        return sendMessage;
    }

    public static SendMessage getIsNotCommandMessage(String chatId){
        if (sendMessage == null) {
            sendMessage = new SendMessage();
        }
        sendMessage.setChatId(chatId);
        sendMessage.setText("Your message is not command! /help");
        return sendMessage;
    }


}
