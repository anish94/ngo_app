/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Quiz.Quiz;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class EducationEventWorkRequest extends WorkRequest{
    
    private String ngoName;
    private String workshopName;
    private String instructorRequired;
    private String date;
    private String venue;
    private String topics;
    private String duration;
    private String comments;
    private String deadline;
    Date eventDate;
            
    private ArrayList<String> enterpriseList;
    
    private ArrayList<Employee> employeeList;
    private ArrayList<Employee> employeeWaitList;
    
    private Quiz quiz;
    
    public EducationEventWorkRequest(){
    this.employeeList = new ArrayList();
    this.employeeWaitList = new ArrayList();
    this.enterpriseList = new ArrayList();
    this.quiz = new Quiz();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    
    

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    
    public ArrayList<Employee> getEmployeeWaitList() {
        return employeeWaitList;
    }

    public void setEmployeeWaitList(ArrayList<Employee> employeeWaitList) {
        this.employeeWaitList = employeeWaitList;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }
    
    
    
        
    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    
    public String getInstructorRequired() {
        return instructorRequired;
    }

    public void setInstructorRequired(String instructorRequired) {
        this.instructorRequired = instructorRequired;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public ArrayList<Employee> getEmployeeList() {
        System.err.print("getting");
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public ArrayList<String> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<String> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    
    
    //    public void addEmployee(Employee emp){
//        employeeList.add(emp);
//    }
    
    
    @Override
    public String toString() {
        return workshopName+" ";
    }
}
