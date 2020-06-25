package model;

public class Grading {
    private int uid;
    private int aid;
    private int score;
    private boolean isSupport;

    public Grading() {
    }

    public Grading(int uid, int aid, int score, boolean isSupport) {
        this.uid = uid;
        this.aid = aid;
        this.score = score;
        this.isSupport = isSupport;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isSupport() {
        return isSupport;
    }

    public void setSupport(boolean support) {
        isSupport = support;
    }

    @Override
    public String toString() {
        return "Grading{" +
                "uid=" + uid +
                ", aid=" + aid +
                ", score=" + score +
                ", isSupport=" + isSupport +
                '}';
    }
}
