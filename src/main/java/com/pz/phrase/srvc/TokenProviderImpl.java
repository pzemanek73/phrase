package com.pz.phrase.srvc;

import com.pz.phrase.model.dto.AccountInfo;
import com.pz.phrase.model.dto.TokenInfo;
import com.pz.phrase.model.map.AccountConfigMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenProviderImpl implements TokenProvider {

    Logger logger = LoggerFactory.getLogger(TokenProviderImpl.class);

    @Autowired
    AccountConfigService accountConfigService;
    @Value("${phrase.token.url}")
    private String tokenUrl;
    private String token = null; //"k2BT5dTw1CC9yqVo1v7y1YNU0X62l3tJ0KxNOV9Jx5uV5buTIUmBer7IElMyDQzFd";

    @Override
    public synchronized String getToken() {
        if (token == null) {
            logger.info("Attempting to get token");
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.USER_AGENT, "Homework app (pzemanek73@gmail.com)");
                AccountInfo dto = AccountConfigMapper.toDTO(accountConfigService.getMainRow());
                HttpEntity<Object> entity = new HttpEntity<>(dto, headers);

                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<TokenInfo> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, TokenInfo.class);

                token = response.getBody().getToken();
            } catch (Exception e) {
                throw new RuntimeException("Error while obtaining API token", e);
            }
        }

        return token;
    }

    @Override
    public synchronized void invalidateToken() {
        token = null;
    }
}
