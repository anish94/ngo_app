/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.WorkQueue.EducationEventWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private int id;
    private int managerId;
    private static int count = 1;
    private ArrayList<Integer> quizScore;
    private Map<String, Integer> quizScoreMap;
    private ArrayList<EducationEventWorkRequest> quizTakenEdEventWorkReq;

    public Employee() {
        id = count;
        count++;
        this.quizScore = new ArrayList();
        this.quizTakenEdEventWorkReq = new ArrayList();
        this.quizScoreMap = new HashMap<String,Integer>();
    }

    public Map<String, Integer> getQuizScoreMap() {
        return quizScoreMap;
    }

    public void setQuizScoreMap(Map<String, Integer> quizScoreMap) {
        this.quizScoreMap = quizScoreMap;
    }
    
    

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public ArrayList<Integer> getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(ArrayList<Integer> quizScore) {
        this.quizScore = quizScore;
    }

    public ArrayList<EducationEventWorkRequest> getQuizTakenEdEventWorkReq() {
        return quizTakenEdEventWorkReq;
    }

    public void setQuizTakenEdEventWorkReq(ArrayList<EducationEventWorkRequest> quizTakenEdEventWorkReq) {
        this.quizTakenEdEventWorkReq = quizTakenEdEventWorkReq;
    }
    
    

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
