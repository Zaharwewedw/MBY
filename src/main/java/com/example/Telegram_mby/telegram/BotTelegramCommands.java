package com.example.Telegram_mby.telegram;

import com.example.Telegram_mby.config.BotTelegramModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j
public class BotTelegramCommands extends TelegramLongPollingBot {

    private final BotTelegramModel botTelegramModel;
    private byte aByte;
    @Override
    public String getBotUsername() {
        return botTelegramModel.getUsername();
    }

    @Override
    public String getBotToken() {
        return botTelegramModel.getToken();
    }


    private void saveDataCommandBot(Message message, byte aByte) {
        if (aByte == 0) {
            executeSendMessage(SendMessage
                    .builder()
                    .chatId(message.getChatId())
                    .parseMode("Markdown")
                    .text("Вы не выбрали заявку")
                    .build());
            return;
        }

        if (aByte == 1)
            log.debug(message.getText() + "-> спил");
        if (aByte == 2)
            log.debug(message.getText() + "-> кранация");
        if (aByte == 3)
            log.debug(message.getText() + "-> вывоз");

        executeSendMessage(SendMessage
                .builder()
                .chatId(message.getChatId())
                .parseMode("Markdown")
                .text("Ваш запрос в оброботке, спасибо за обращение!")
                .build());
    }
    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getText().split(" ").length > 3) {
                saveDataCommandBot(message, aByte);
                return;
            }
            log.debug(message.getText());
            switch (update.getMessage().getText().toLowerCase()) {
                case "/start": startCommandBot(message);
                    break;
                case  "информация": infoCommandBot(message);
                    break;
                case  "заявка": aplCommandBot(message);
                    break;
                case  "команды": commandMassage(message);
                    break;
                default: defaultMassage(message);
                    break;
            }
        } else if (update.hasCallbackQuery()) {
            String callBackData = update.getCallbackQuery().getData();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            log.debug(callBackData);
            if (callBackData.equals("спил")) {
                aByte = 1;
                executeEditMessageTextMessage(EditMessageText.builder()
                        .text("Напишите ИФО, ваш номер телефона, адрес где будет осущевстлятся спил.\n Пример:\n Иван Иванов Иванович,+7(900)-000-00-70, ул.Свободы. После отправки заявки вам позвонят")
                        .chatId(chatId)
                        .messageId((int)messageId)
                        .build());
            } else if (callBackData.equals("кранация")) {
                aByte = 2;
                executeEditMessageTextMessage(EditMessageText.builder()
                        .text("Напишите ИФО, ваш номер телефона, адрес где будет осущевстлятся кранация.\n Пример:\n Иван Иванов Иванович,+7(900)-000-00-70, ул.Свободы. После отправки заявки вам позвонят")
                        .chatId(chatId)
                        .messageId((int)messageId)
                        .build());
            } else if (callBackData.equals("вывоз")) {
                aByte = 3;
                executeEditMessageTextMessage(EditMessageText.builder()
                        .text("Напишите ИФО, ваш номер телефона, адрес где будет осущевстлятся вывоз мусора.\n Пример:\n Иван Иванов Иванович,+7(900)-000-00-70, ул.Свободы. После отправки заявки вам позвонят")
                        .chatId(chatId)
                        .messageId((int)messageId)
                        .build());
            }
        }
    }

    private void defaultMassage(Message message) {
        executeSendMessage(SendMessage.builder()
                .chatId(message.getChatId())
                .parseMode("Markdown")
                .text("Такой команды нет если вы хотите ознакомится с данным ботом наберите -> информация, если вам нужно информация по командам наберите -> комады")
                .build());
    }

    private void commandMassage(Message message) {
        executeSendMessage(SendMessage.builder()
                .chatId(message.getChatId())
                .parseMode("Markdown")
                .text("Основные команды:\nИнформация - для предостовления информации о боте\nЗаявка - для создание заявки\n ")
                .build());
    }
    private void startCommandBot (Message message) {
        executeSendMessage(SendMessage.builder()
                    .chatId(message.getChatId())
                    .parseMode("Markdown")
                    .text("Здраствуйте, мы приветствуем вас в нашем боте, если вы хотите создать заявку отправте слово -> заявка, ознакомится с данным ботом наберите -> информация")
                    .build());
    }

    private void infoCommandBot(Message message) {
        executeSendMessage(SendMessage.builder()
                .chatId(message.getChatId())
                .parseMode("Markdown")
                .text("Данный бот преднозначен для принятия заявок, сруб деревьев, кранация, вывоз мусора, постройка детских городов. Что бы создать заявку отправте слово -> заявка ")
                .build());
    }
    private void aplCommandBot(Message message) {

        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        rowsInLine.add(getInlineKeyboardButtons());

        executeSendMessage(SendMessage.builder()
                .chatId(message.getChatId())
                .parseMode("Markdown")
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(rowsInLine).build())
                .text("Нажмите на кнопку соотвествующей вашей заявки.")
                .build());
    }
    @SneakyThrows(TelegramApiException.class)
    private void executeSendMessage(SendMessage message) {
        execute(message);
    }

    @SneakyThrows(TelegramApiException.class)
    private void executeEditMessageTextMessage(EditMessageText message) {
            execute(message);
    }

    private static List<InlineKeyboardButton> getInlineKeyboardButtons() {
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var cutting = new InlineKeyboardButton();
        cutting.setText("спил");
        cutting.setCallbackData("спил");

        var cranation = new InlineKeyboardButton();
        cranation.setText("кранация");
        cranation.setCallbackData("кранация");

        var export = new InlineKeyboardButton();
        export.setText("вывоз мусора");
        export.setCallbackData("вывоз");

        rowInLine.add(cutting);
        rowInLine.add(cranation);
        rowInLine.add(export);
        return rowInLine;
    }
}
