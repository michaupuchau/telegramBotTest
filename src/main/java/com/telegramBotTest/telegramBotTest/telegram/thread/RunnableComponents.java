package com.telegramBotTest.telegramBotTest.telegram.thread;


import com.telegramBotTest.telegramBotTest.telegram.Dex;
import com.telegramBotTest.telegramBotTest.telegram.TrackerBot;
import com.telegramBotTest.telegramBotTest.telegram.message.MessageFactory;
import com.telegramBotTest.telegramBotTest.token.Token;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RunnableComponents {
    protected List<Message> botExecuteTask (MessageFactory messageFactory, TrackerBot telegramBot , List<Token> tokens, String channelId, Dex nameDex){
        return postMessagesAtTelegramChannel(messageFactory, telegramBot, tokens, channelId, nameDex);
    }

    protected String getLastBlockNumber(List<Token> tokens, String blockNumber){
        if (!tokens.isEmpty())
            return String.valueOf(
                    Integer.parseInt(
                            tokens.get(tokens.size() - 1).getBlockNumber()) + 1);
        return blockNumber;
    }

    private List<Message> postMessagesAtTelegramChannel(MessageFactory messageFactory, TrackerBot telegramBot, List<Token> tokens, String channelId, Dex nameDex){
        List<Message> sentMessages = new ArrayList<>();

        //temporary
        boolean frozen = tokens.stream()
                .anyMatch(t -> t.getTokenSymbol().equalsIgnoreCase("FROZEN") ||
                               t.getTokenSymbol().toUpperCase().contains("SHARE"));

        //temporary

        tokens.forEach(token -> {
            SendMessage message = createMessage(messageFactory, channelId, nameDex, token);
            message.enableHtml(true);
            try {
                sentMessages.add(telegramBot.execute(message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });

        return sentMessages;
    }

    private SendMessage createMessage(MessageFactory messageFactory, String channelId, Dex nameDex, Token token){
        return messageFactory
                .createMessage(nameDex, token)
                .parseToSendMessage(channelId);
    }

    void sleepThread(long sleepMilliseconds){
        try {
            Thread.sleep(sleepMilliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
