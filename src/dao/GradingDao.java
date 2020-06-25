package dao;

import model.Grading;

public class GradingDao extends DBConnection {

    public boolean add(Grading grading) {
        try {
            buildConn();
            int uid = grading.getUid();
            int aid = grading.getAid();
            int score = grading.getScore();
            int isSupport = grading.isSupport() ? 1 : 0;

            String sql1 = "insert into scoretable (uid,aid,score,isSupport) values ('" + uid + "', '" + aid + "', '" + score + "', '" + isSupport + "')";
            s.execute(sql1);

            String sql2 = "update answertable set score=0.5*(score+" + score + ") , support=support+" + isSupport + " where aid=" + aid;
            s.execute(sql2);

            return true;
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

    public Grading check(int myUid, int myAid) {
        try {
            buildConn();

            String sql = "select * from scoretable where uid='" + myUid + "' and aid='" + myAid + "'";
            r = s.executeQuery(sql);
            if (r.next()) {
                String uid = r.getString("uid");
                String aid = r.getString("aid");
                String score = r.getString("score");
                boolean isSupport = r.getString("isSupport").equals("1");
                Grading grading = new Grading(Integer.parseInt(uid), Integer.parseInt(aid), Integer.parseInt(score), isSupport);
                return grading;
            } else {
                return null;
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
