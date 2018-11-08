package com.parcial.DbConnector.Metadata;

import org.springframework.data.annotation.Id;

public class Information {

    @Id
    public String id;

    public String metaData;

    public Information(String id,String metaData) {
        this.id = id;
        this.metaData=metaData;
    }

    @Override
    public String toString() {
        return String.format(
                "Information[id=%s, metaData='%s']",
                id, metaData);
    }
}
