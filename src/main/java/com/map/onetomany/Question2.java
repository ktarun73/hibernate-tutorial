package com.map.onetomany;


import javax.persistence.*;
import java.util.List;

@Entity
public class Question2 {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToMany(mappedBy = "question2")
    private List<Answer2> answer2s;

    public List<Answer2> getAnswers() {
        return answer2s;
    }

    public void setAnswers(List<Answer2> answer2s) {
        this.answer2s = answer2s;
    }

    public Question2(int questionId, String question, List<Answer2> answer2s) {
        this.questionId = questionId;
        this.question = question;
        this.answer2s = answer2s;
    }

    public Question2() {
    }


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
