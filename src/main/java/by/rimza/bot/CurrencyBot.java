package by.rimza.bot;

import by.rimza.keyboard.InlineKeyboard;
import by.rimza.model.Currency;
import by.rimza.service.AdditionalOperations;
import by.rimza.service.CurrencyService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CurrencyBot extends TelegramLongPollingBot {

    private final String botUsername;

    public CurrencyBot(String botToken, String botUsername) {
        super(botToken);
        this.botUsername = botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = AdditionalOperations.getChatId(update);
            if (AdditionalOperations.textFromUpdate(update).equals("/start")) {
                sendMessage(chatId, "Здравствуйте, это мой мини проект: курс бел рубля относительно других валют.");
                sendMessageWithStartUpKeyboard(chatId);
                return;
            }
            sendMessageWithStartUpKeyboard(chatId);
        } else if (update.hasCallbackQuery()) {
            long chatId = AdditionalOperations.getChatIdFromCallback(update);
            String callback = AdditionalOperations.getCallback(update);
            getCurrencyRate(chatId, callback);
            sendMessageWithStartUpKeyboard(chatId);
            answerCallbackQuery(update);
        }
    }

    public void answerCallbackQuery(Update update) {
        AnswerCallbackQuery ae = AnswerCallbackQuery.builder().callbackQueryId(update.getCallbackQuery().getId()).cacheTime(1).build();
        try {
            execute(ae);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(long chatId, String text) {
        SendMessage sm = SendMessage.builder().text(text).chatId(chatId).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageWithStartUpKeyboard(long chatId) {
        SendMessage sm = SendMessage.builder().text("Курс какой валюты хотите узнать?").chatId(chatId).
                replyMarkup(InlineKeyboard.createInlineKeyboard()).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCurrencyRate(long chatId, String cur) {
        Currency currency = CurrencyService.getCurrency(cur);
        sendMessage(chatId, "Курс " + currency.getCur_name() + " относительно бел рубля составляет: " + currency.getCur_officialRate());
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
