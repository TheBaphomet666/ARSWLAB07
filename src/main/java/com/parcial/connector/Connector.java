package com.parcial.connector;

import java.io.IOException;

public interface Connector {
    public StringBuffer Fetch(String function,String symbol) throws IOException;

    }

