package com.telegramBotTest.telegramBotTest.telegram.message;

import com.telegramBotTest.telegramBotTest.token.Token;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Map;

public class MessageSpookyswap extends MessageComponents implements Message {

    private final Token token;

    public MessageSpookyswap(Token token) {
        this.token = token;
    }

    @Override
    public SendMessage parseToSendMessage(String chatId) {
        return parse(buildTextMessage(), chatId);
    }

    @Override
    public String buildTextMessage(){
        return MessageCreator.MessageCreatorBuilder.builder(token)
                .title("New coin at Spookyswap!")
                .tokenInfo()
                .socialMedia()
                .liquidityPool()
                .charts(Map.of("Dexscreener: ", dexscreenerFantomUrl + token.getLiquidityPair().getPairAddress()))
                .dex(spookyBuyUrl + token.getAddress(),
                        spookySellUrl + token.getAddress(),
                        spookyInfoUrl + token.getLiquidityPair().getPairAddress())
                .explorer(Map.of(
                        "Token contract: ", ftmscanContractCodeUrl + token.getAddress() + "#code",
                        "Token hodlers: ", ftmscanBalancesUrl + token.getAddress() + "#balances",
                        "Similar contracts: ", ftmscanSimilarContracts + token.getAddress()))
                .security()
                .build();
    }
}
