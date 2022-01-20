package uz.rasulov.essentialenglishwordsbot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by SHR on 08.01.2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String text;
    private long chatId;
}
