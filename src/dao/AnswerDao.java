package dao;

import model.Answer;

import java.util.SortedSet;
import java.util.TreeSet;

public class AnswerDao extends DBConnection {
    public int add(Answer myAnswer) {
        try {
            buildConn();
            int uid = myAnswer.getUid();
            int qid = myAnswer.getQid();
            String answer = myAnswer.getAnswer();
            String location = myAnswer.getLocation();
            // 回答评分
            float score = myAnswer.getScore();
            // 回答点赞数
            int support = myAnswer.getSupport();

            String sql1 = "insert into answertable (uid,qid,answer,location,score,support) values ('" + uid + "', '" + qid + "', '" + answer
                    + "', '" + location + "', '" + score + "', '" + support + "')";
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

    public boolean addImg(int aid, String imgLocation) {
        try {
            buildConn();

            String sql1 = "update answertable set location='" + imgLocation + "' where aid=" + aid;
            System.out.println(sql1);
            s.execute(sql1);
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

    public SortedSet<Answer> getAnswersByUid(int myUid) {
        try {
            buildConn();

            String sql = "select * from answertable where uid=" + myUid;
            r = s.executeQuery(sql);
            SortedSet<Answer> tc = new TreeSet<Answer>();
            while (r.next()) {
                String uid = r.getString("uid");
                String aid = r.getString("aid");
                String qid = r.getString("qid");
                String answer = r.getString("answer");
                String location = r.getString("location");
                float score = Float.parseFloat(r.getString("score"));
                // 回答点赞数
                int support = Integer.parseInt(r.getString("support"));
                Answer answer1 = new Answer(Integer.parseInt(uid), Integer.parseInt(aid), Integer.parseInt(qid), answer, location, score, support);
                tc.add(answer1);
            }
            return tc;
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

    public SortedSet<Answer> getAnswersByQid(int myQid) {
        try {
            buildConn();

            String sql = "select * from answertable where qid=" + myQid;
            r = s.executeQuery(sql);
            SortedSet<Answer> tc = new TreeSet<Answer>();
            while (r.next()) {
                String uid = r.getString("uid");
                String aid = r.getString("aid");
                String qid = r.getString("qid");
                String answer = r.getString("answer");
                String location = r.getString("location");
                float score = Float.parseFloat(r.getString("score"));
                // 回答点赞数
                int support = Integer.parseInt(r.getString("support"));
                Answer answer1 = new Answer(Integer.parseInt(uid), Integer.parseInt(aid), Integer.parseInt(qid), answer, location, score, support);
                tc.add(answer1);
            }
            return tc;
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
