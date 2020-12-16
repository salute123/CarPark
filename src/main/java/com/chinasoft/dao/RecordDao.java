package com.chinasoft.dao;

import com.chinasoft.domain.Record;

import java.util.List;

public interface RecordDao {
    List<Record> findAll();

    void addRecord(Record record);
}
