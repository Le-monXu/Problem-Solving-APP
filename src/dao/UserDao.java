package dao;

import model.User;

public class UserDao extends DBConnection {
    public boolean check(int uid, String password) {
        try {
            buildConn();
            String sql = "select * from usertable where uid='" + uid + "' and password='" + password + "'";
            r = s.executeQuery(sql);
            if (r.next()) {
                String tmpId = "";
                String tmpPs = "";
                tmpId = r.getString("uid");
                tmpPs = r.getString("password");

                if ((tmpId != null) && (tmpPs != null)) {
                    System.out.println("userId:" + tmpId + "; password:" + tmpPs);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                distroy();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return false;
    }

    public int add(User aUser) {
        try {
            buildConn();
            String password = aUser.getPassword();
            String name = aUser.getName();
            String sex = aUser.getSex();
            int age = aUser.getAge();
            String major = aUser.getMajor();

            String sql1 = "insert into usertable (name,password,sex,age,major) values ('" + name +
                    "', '" + password + "', '" + sex + "', '" + age + "', '" + major + "')";
            s.execute(sql1);
            String sql = "SELECT LAST_INSERT_ID()";
            int id = 0;
            r = s.executeQuery(sql);
            while (r.next()) {
                id = r.getInt(1);
                System.out.println("生成记录的key为 ：" + id);
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                distroy();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return 0;
    }

    public User getAUserByUid(int myUid) {
        try {
            buildConn();
            String sql = "select * from usertable where uid=" + myUid;
            r = s.executeQuery(sql);
            while (r.next()) {
                String uid = r.getString("uid");
                String name = r.getString("name");
                String sex = r.getString("sex");
                String age = r.getString("age");
                String major = r.getString("major");
                User user = new User(Integer.parseInt(uid), name, null, sex, Integer.parseInt(age), major);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                distroy();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return null;
    }
}



   
