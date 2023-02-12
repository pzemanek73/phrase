package com.pz.phrase.srvc;

import com.pz.phrase.model.entity.AccountConfig;

public interface AccountConfigService {
    AccountConfig getMainRow();

    AccountConfig save(AccountConfig config);
}
