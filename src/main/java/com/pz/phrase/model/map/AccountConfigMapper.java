package com.pz.phrase.model.map;

import com.pz.phrase.model.dto.AccountInfo;
import com.pz.phrase.model.entity.AccountConfig;

public class AccountConfigMapper {
    public static AccountInfo toDTO(AccountConfig entity) {
        return toDTO(entity, new AccountInfo());
    }

    public static AccountInfo toDTO(AccountConfig entity, AccountInfo dto) {
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static AccountConfig toEntity(AccountInfo dto) {
        return toEntity(dto, new AccountConfig());
    }

    public static AccountConfig toEntity(AccountInfo dto, AccountConfig entity) {
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
