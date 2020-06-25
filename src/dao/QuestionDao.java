package dao;

import model.Question;

import java.util.HashSet;

public class QuestionDao extends DBConnection {
    public int add(Question myQuestion) {
        try {
            buildConn();
//            int qid = myQuestion.getQid();
            int uid = myQuestion.getUid();
            String content = myQuestion.getContent();
            String category = myQuestion.getCategory();
            String describe = myQuestion.getDescribe();
            int state = myQuestion.getState();
            int bestAnswer = myQuestion.getBestAnswer();
            String location = myQuestion.getLocation();

            String sql1 = "insert into questiontable (uid,content,category,description,state,bestAnswer,location,startTime) values (" +
                    uid + ", '" + content + "', '" + category
                    + "', '" + describe + "', " + state + ", " + bestAnswer + ", '" + location + "',now())";
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

    public boolean addImg(int qid, String imgLocation) {
        try {
            buildConn();

            String sql1 = "update questiontable set location='" + imgLocation + "' where qid=" + qid;
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

    public HashSet<Question> getAllQuestion() {
        try {
            buildConn();

            String sql = "select * from questiontable";
            r = s.executeQuery(sql);
            HashSet<Question> tc = new HashSet<Question>();
            while (r.next()) {
                String qid = r.getString("qid");
                String uid = r.getString("uid");
                String content = r.getString("content");
                String category = r.getString("category");
                String describe = r.getString("description");
                String state = r.getString("state");
                String bestAnswer = r.getString("bestAnswer");
                String location = r.getString("location");
                Question question = new Question(Integer.parseInt(qid), Integer.parseInt(uid), content, category, describe, Integer.parseInt(state), location, Integer.parseInt(bestAnswer));
                tc.add(question);
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

    public HashSet<Question> getQuestionByUid(int myUid) {
        try {
            buildConn();

            String sql = "select * from questiontable where uid=" + myUid;
            r = s.executeQuery(sql);
            HashSet<Question> tc = new HashSet<Question>();
            while (r.next()) {
                String qid = r.getString("qid");
                String uid = r.getString("uid");
                String content = r.getString("content");
                String category = r.getString("category");
                String describe = r.getString("description");
                String state = r.getString("state");
                String bestAnswer = r.getString("bestAnswer");
                String location = r.getString("location");
                Question question = new Question(Integer.parseInt(qid), Integer.parseInt(uid), content, category, describe, Integer.parseInt(state), location, Integer.parseInt(bestAnswer));
                tc.add(question);
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

    public Question getAQuestion(int myQid) {
        try {
            buildConn();

            String sql = "select * from questiontable where qid=" + myQid;
            r = s.executeQuery(sql);
            while (r.next()) {
                String qid = r.getString("qid");
                String uid = r.getString("uid");
                String content = r.getString("content");
                String category = r.getString("category");
                String describe = r.getString("description");
                String state = r.getString("state");
                String bestAnswer = r.getString("bestAnswer");
                String location = r.getString("location");
                Question question = new Question(Integer.parseInt(qid), Integer.parseInt(uid), content, category, describe, Integer.parseInt(state), location, Integer.parseInt(bestAnswer));
                return question;
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
