package com.pz.phrase.srvc;

import com.pz.phrase.db.AccountConfigRepository;
import com.pz.phrase.model.entity.AccountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConfigServiceImpl implements AccountConfigService {

    public static String MAIN_CODE = "MAIN";
    @Autowired
    private AccountConfigRepository configRepository;

    @Override
    public AccountConfig getMainRow() {
        AccountConfig cnf = configRepository.findByCode(MAIN_CODE);
        if (cnf == null) {
            cnf = new AccountConfig(MAIN_CODE, "", "");
        }
        return cnf;
    }

    @Override
    public AccountConfig save(AccountConfig config) {
        AccountConfig ret = configRepository.save(config);
        return ret;
    }

}
