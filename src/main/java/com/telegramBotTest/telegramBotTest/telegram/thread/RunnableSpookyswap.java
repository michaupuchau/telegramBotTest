package com.telegramBotTest.telegramBotTest.telegram.thread;

import com.telegramBotTest.telegramBotTest.controller.ExplorerController;
import com.telegramBotTest.telegramBotTest.telegram.Dex;
import com.telegramBotTest.telegramBotTest.telegram.TrackerBot;
import com.telegramBotTest.telegramBotTest.telegram.message.MessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RunnableSpookyswap extends RunnableComponents implements Runnable{

    private final ExplorerController controller;
    private final TrackerBot telegramBot;
    private final MessageFactory messageFactory;
    private final String channelId;

    @Autowired
    public RunnableSpookyswap(ExplorerController controller,
                                 @Lazy TrackerBot telegramBot,
                                 MessageFactory messageFactory,
                                 @Value("${telegram.channel.fantom.id}") String channelId) {
        this.controller = controller;
        this.telegramBot = telegramBot;
        this.messageFactory = messageFactory;
        this.channelId = channelId;
    }

    @Override
    public void run() {
        var blockNumber = controller.getLastBlockNumber(Dex.SpookySwap);
        while (!Thread.currentThread().isInterrupted()){
            var tokens = controller.getLastPairCreated(Dex.SpookySwap, blockNumber);
            if (!tokens.isEmpty()) botExecuteTask(messageFactory, telegramBot, tokens, channelId, Dex.SpookySwap);
            blockNumber = getLastBlockNumber(tokens, blockNumber);
            sleepThread(3000);
        }
    }
}
