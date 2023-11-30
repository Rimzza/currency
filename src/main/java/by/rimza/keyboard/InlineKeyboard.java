package by.rimza.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboard {

    public static InlineKeyboardMarkup createInlineKeyboard() {
    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row1Inline = new ArrayList<>() {{
            add( InlineKeyboardButton.builder().text("RUB").callbackData("RUB").build());
            add(InlineKeyboardButton.builder().text("USD").callbackData("USD").build());
            add(InlineKeyboardButton.builder().text("EUR").callbackData("EUR").build());
        }};

        rowsInline.add(row1Inline);
        inlineKeyboardMarkup.setKeyboard(rowsInline);
        return inlineKeyboardMarkup;
    }
}
