package com.map.onetomany;

import javax.persistence.*;

@Entity
public class Answer2 {
    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private Question2 question2;

    public Question2 getQuestion() {
        return question2;
    }

    public void setQuestion(Question2 question2) {
        this.question2 = question2;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer2() {
    }

    public Answer2(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }
}
