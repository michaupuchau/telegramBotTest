package com.telegramBotTest.telegramBotTest.service;

import com.telegramBotTest.telegramBotTest.dao.PolygonscanQuickswapV2Dao;
import com.telegramBotTest.telegramBotTest.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolygonscanService extends ExplorerService{

    private final PolygonscanQuickswapV2Dao polygonscanQuickswapV2Dao;

    @Autowired
    public PolygonscanService(PolygonscanQuickswapV2Dao polygonscanQuickswapV2Dao) {
        this.polygonscanQuickswapV2Dao = polygonscanQuickswapV2Dao;
    }

    public List<Token> getCreatedPairQuickswapV2(String fromBlock) {
        return getCreatedPair(polygonscanQuickswapV2Dao, fromBlock);
    }

    public String getBlockNumber(){return getBlockNumber(polygonscanQuickswapV2Dao);}
}
