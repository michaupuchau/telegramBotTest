package com.telegramBotTest.telegramBotTest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EtherscanUniswapV2Dao extends ExplorerDao {

    @Autowired
    protected EtherscanUniswapV2Dao(RestTemplate restTemplate,
                                    @Value("${etherscan.root}") String root,
                                    @Value("${etherscan.apikey}") List<String> apiKey,
                                    @Value("${etherscan.uniswapV2.topic.pair.created}") String pairCreatedTopic,
                                    @Value("${etherscan.uniswapV2.topic.pair.minted}") String pairMintedTopic,
                                    @Value("${etherscan.uniswapV2.factory}") String factoryAddress) {
        super(restTemplate, root, apiKey, pairCreatedTopic, pairMintedTopic, factoryAddress);
    }
}
