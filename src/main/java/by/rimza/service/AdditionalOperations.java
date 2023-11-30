package by.rimza.service;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AdditionalOperations {

    public static String textFromUpdate (Update update) {
        return update.getMessage().getText();
    }

    public static  long getChatId(Update update) {
        return update.getMessage().getChatId();
    }

    public static String getCallback (Update update) {
        return update.getCallbackQuery().getData();
    }

    public static long getChatIdFromCallback(Update update) {
        return update.getCallbackQuery().getFrom().getId();
    }
}
