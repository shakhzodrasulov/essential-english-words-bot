package uz.rasulov.essentialenglishwordsbotv2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SHR on 12.01.2022
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Command {
    public static List<String> commandsList = Arrays.asList(
            "/start",
            "/learn_new_words",
            "/test_yourself"
    );

    private String text;
    private long chatId;
}
