package uz.rasulov.eew_bot_v3.scripts;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.rasulov.eew_bot_v3.models.Message;

import java.util.Map;

import static uz.rasulov.eew_bot_v3.service.Constants.scriptIsRun;
import static uz.rasulov.eew_bot_v3.service.Constants.selectedUnit;

/**
 * Created by SHR on 02.02.2022
 */
@Component
public class Script {
    private Map<String, String> EnglishWordsUnitPack;
    private final WordPacks wordPacks;

    public Script(WordPacks wordPacks) {
        this.wordPacks = wordPacks;
    }

    public SendMessage run(Message receivedMessage) {
        if (!scriptIsRun){
            scriptIsRun = true;
            selectedUnit = receivedMessage.getText().substring(8);
        }

        if (EnglishWordsUnitPack == null) {
            Map<String, String> EnglishWordsUnitPack = wordPacks.getUnitPack();
        }
        return null;
    }
}
