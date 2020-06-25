package model;

public class Question {
    private int qid;
    private int uid;
    private String content;
    private String category;
    private String describe;
    private int state;
    private String location;
    private int bestAnswer;

    public Question() {
    }

    public Question(int qid, int uid, String content, String category, String describe, int state, String location, int bestAnswer) {
        this.qid = qid;
        this.uid = uid;
        this.content = content;
        this.category = category;
        this.describe = describe;
        this.state = state;
        this.location = location;
        this.bestAnswer = bestAnswer;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBestAnswer() {
        return bestAnswer;
    }

    public void setBestAnswer(int bestAnswer) {
        this.bestAnswer = bestAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qid=" + qid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                ", location='" + location + '\'' +
                ", bestAnswer=" + bestAnswer +
                '}';
    }
}
