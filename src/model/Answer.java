package model;

public class Answer implements Comparable<Answer> {
    private int uid;
    private int aid;
    private int qid;
    private String answer;
    private String location;
    // 回答评分
    private float score;
    // 回答点赞数
    private int support;

    public Answer() {
    }

    public Answer(int uid, int aid, int qid, String answer, String location, float score, int support) {
        this.uid = uid;
        this.aid = aid;
        this.qid = qid;
        this.answer = answer;
        this.location = location;
        this.score = score;
        this.support = support;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "uid=" + uid +
                ", aid=" + aid +
                ", qid=" + qid +
                ", answer='" + answer + '\'' +
                ", location='" + location + '\'' +
                ", score=" + score +
                ", support=" + support +
                '}';
    }

    @Override
    public int compareTo(Answer answer) {
        if (answer == null) {
            return 0;
        }
        if (this.aid == answer.aid) {
            return 0;
        } else {
            return (this.aid - answer.aid);
        }
    }
}
