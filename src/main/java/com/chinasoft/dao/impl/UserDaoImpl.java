package com.chinasoft.dao.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.Record;
import com.chinasoft.domain.Report;
import com.chinasoft.domain.User;
import com.chinasoft.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public void addUser(User user) {
        String gender=user.getGender();
        String phoneNumber=user.getPhoneNumber();
        String carNumber=user.getCarNumber();
        String username=user.getUsername();
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        template.update(sql,null,gender,phoneNumber,username,carNumber,"123456",1);
    }

    @Override
    public User findUserById(String uid) {
        String sql="select * from user where uid = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uid);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set gender=?,phoneNumber=?,username=?,carNumber=?,password=? ,role=? where uid=?";
        template.update(sql, user.getGender(), user.getPhoneNumber(), user.getUsername(), user.getCarNumber(), "123456", 1,user.getUid());

    }

    @Override
    public void deleteUser(String uid) {
        String sql = "delete from user where uid = ?";
        template.update(sql, uid);
    }

    @Override
    public void deleteCheckUser(String uid) {
        String sql = "delete from user where uid = ?";
        template.update(sql, uid);
    }




    @Override
    public void findrecordAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Integer> map= new HashMap<>();
        String sql="select * from record";
        //将record表中的每条数据转换成对象
        List<Record> list = template.query(sql, new BeanPropertyRowMapper<>(Record.class));
        //遍历
        for (Record record : list) {
                 //如果结算不为空值
                 if (record.getJiesuan()!=null){
                     //将date类型数据转换成string类型,去掉时分秒,只需要年月日
                     String format = sdf.format(record.getLeaveTime());
                     //遍历keySet日期(key),如果map里面没有该日期,就把此日期和钱都加进去,如果有就只需要加钱(value)
                     Set<String> keySet = map.keySet();
                     if(!keySet.contains(format)) {
                         map.put(format, record.getJiesuan());
                     }else {
                         Integer integer = map.get(format);
                         integer = integer + record.getJiesuan();
                         map.put(format,integer);
                     }
              }
        }
        //将map集合里面的数据插入到report表中
        String sql1 = "insert into report values(?,?,?)";
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            template.update(sql1,null,entry.getKey(),entry.getValue());
        }
    }


    @Override
    public List<Report> findReportAll() {
            String sql = "select * from report";
            List<Report> list =template.query(sql, new BeanPropertyRowMapper<>(Report.class));
       return list;
    }

    @Override
    public List<Report> findUserByPage(Integer pages, Integer row, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select * from report where 1 = 1 ");
        Set<String> keySet = map.keySet();
//        声明集合装参数
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if ("pageNum".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = map.get(key)[0];
//            如果遍历查询条件 key对应的value有值的话 将sql添加进去
            if(value != null && !"".equals(value) ){
                sql.append(" AND "+ key+"  like  ?");
                params.add("%"+value+"%");
            }
        }
        sql.append(" limit ?,?");
        Integer start = (pages-1)*row;
        params.add(start);
        params.add(row);
        return template.query(sql.toString(),params.toArray(),new BeanPropertyRowMapper<>(Report.class));
    }

    @Override
    public Integer findTotalCount(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select count(id) from report where 1 = 1 ");
        Set<String> keySet = map.keySet();
//        声明集合装参数
        List<String> params = new ArrayList<>();
        for (String key : keySet) {
            if ("pageNum".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = map.get(key)[0];
//            如果遍历查询条件 key对应的value有值的话 将sql添加进去
            if(value !=null && !"".equals(value) ){
                sql.append(" AND "+ key+"  like  ?");
                params.add("%"+value+"%");
            }
        }
        return template.queryForObject(sql.toString(),params.toArray(),Integer.class);
    }

    @Override
    public void deleteReport(String id) {
        String sql = "delete from report where id = ?";
        template.update(sql, id);
    }

    @Override
    public void deleteCheckReport(Integer id) {
        String sql = "delete from report where id = ?";
        template.update(sql, id);
    }
}
