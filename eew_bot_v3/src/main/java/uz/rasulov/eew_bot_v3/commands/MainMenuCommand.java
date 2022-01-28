package uz.rasulov.eew_bot_v3.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.eew_bot_v3.responses.MainMenuResponse;
import uz.rasulov.eew_bot_v3.responses.Response;
import uz.rasulov.eew_bot_v3.responses.StartResponse;

import static uz.rasulov.eew_bot_v3.service.Constants.COMMANDS_LIST;

/**
 * Created by SHR on 28.01.2022
 */
@Component
public class MainMenuCommand implements Command{
    private final Response response;

    public MainMenuCommand(MainMenuResponse response) {
        COMMANDS_LIST.add(this);
        this.response = response;
    }


    @Override
    public String getApi() {
        return "/main_menu";
    }

    @Override
    public String getTitle() {
        return "Main Menu";
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
