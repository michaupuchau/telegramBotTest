package com.telegramBotTest.telegramBotTest.service;

import com.telegramBotTest.telegramBotTest.dao.SnowtracePangolinDao;
import com.telegramBotTest.telegramBotTest.dao.SnowtraceTraderjoeDao;
import com.telegramBotTest.telegramBotTest.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnowtraceService extends ExplorerService{

    private final SnowtraceTraderjoeDao snowtraceTraderjoeDao;
    private final SnowtracePangolinDao snowtracePangolinDao;

    @Autowired
    public SnowtraceService(SnowtraceTraderjoeDao snowtraceTraderjoeDao, SnowtracePangolinDao snowtracePangolinDao) {
        this.snowtraceTraderjoeDao = snowtraceTraderjoeDao;
        this.snowtracePangolinDao = snowtracePangolinDao;
    }

    public List<Token> getCreatedPairTraderjoe(String fromBlock) {
        return getCreatedPair(snowtraceTraderjoeDao, fromBlock);
    }

    public List<Token> getCreatedPairPangolin(String fromBlock) {
        return getCreatedPair(snowtracePangolinDao, fromBlock);
    }

    public String getBlockNumber(){return getBlockNumber(snowtraceTraderjoeDao);}
}

