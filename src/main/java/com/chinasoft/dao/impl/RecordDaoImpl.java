package com.chinasoft.dao.impl;

import com.chinasoft.dao.RecordDao;
import com.chinasoft.domain.Record;
import com.chinasoft.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RecordDaoImpl implements RecordDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<Record> findAll() {
        String sql = "select * from record";
        List<Record> list = template.query(sql, new BeanPropertyRowMapper<>(Record.class));
        return list;
    }

    @Override
    public void addRecord(Record record) {
        String sql = "insert into record(carNumber,startime,leavetime,jiesuan,cost) values(?,?,?,?,?) ";
        template.update(sql,record.getCarNumber(),record.getStartime(),record.getLeavetime(),record.getJiesuan(),record.getCost());

    }


}
