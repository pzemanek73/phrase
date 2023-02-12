package com.pz.phrase.srvc;

public interface TokenProvider {
    String getToken();

    void invalidateToken();
}
