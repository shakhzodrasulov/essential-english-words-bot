package uz.rasulov.eew_bot_v3.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by SHR on 28.01.2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Message {
    private String text;
    private long chatId;

    public String getChatId(){
        return String.valueOf(chatId);
    }
}
