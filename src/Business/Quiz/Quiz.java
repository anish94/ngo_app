/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Quiz;

import java.util.ArrayList;

/**
 *
 * @author Anish Gupta
 */
public class Quiz {
    private String quizName;
    private ArrayList<Question> questions;    
    
    public Quiz() {
        this.questions = new ArrayList<>();        
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
       
    public Question createQuestion(int questionNumber, String question, String answer, int marks, String answerA, String answerB, String answerC, String answerD)
    {
     Question q = new Question();
     q.setQuestionNumber(questionNumber);
     q.setQuestion(question);
     q.setAnswer(answer);
     q.setMarks(marks);
     q.setAnswerA(answerA);
     q.setAnswerB(answerB);
     q.setAnswerC(answerC);
     q.setAnswerD(answerD);
     questions.add(q);
     return q;
    }
}
