package com.chinasoft.dao.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
import com.chinasoft.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public void addTciket(Ticket ticket) {

            String sql = "insert into yticket(uid,username,carNumber,ktime,jtime,cost) values (?,?,?,?,?,?)";
            template.update(sql,ticket.getUid(),ticket.getUsername(),ticket.getCarNumber(),ticket.getKtime(),ticket.getJtime(),ticket.getCost());

    }

    @Override
    public List<Ticket> findticketAll() {
        try {
            String sql = "select * from yticket";
            return template.query(sql,new BeanPropertyRowMapper<>(Ticket.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        return null;
        }

    }

    @Override
    public List<User> findUserByPage(Integer pages, Integer row, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select * from user where 1 = 1 ");
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
        List<User> list = template.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public Integer findTotalCount(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select count(uid) from user where 1 = 1 ");
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
        Integer integer = template.queryForObject(sql.toString(), params.toArray(), Integer.class);
        return integer;
    }
}
