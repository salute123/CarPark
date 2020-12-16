package com.chinasoft.service.impl;

import com.chinasoft.dao.RecordDao;
import com.chinasoft.dao.impl.RecordDaoImpl;
import com.chinasoft.domain.Record;
import com.chinasoft.service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {
private RecordDao dao = new RecordDaoImpl();
    @Override
    public List<Record> findAll() {
        return dao.findAll();
    }

    @Override
    public void addRecord(Record record) {
        dao.addRecord(record);
    }
}
