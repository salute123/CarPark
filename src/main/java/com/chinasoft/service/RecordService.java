package com.chinasoft.service;

import com.chinasoft.domain.Record;

import java.util.List;

public interface RecordService {
    List<Record> findAll();

    void addRecord(Record record);
}
