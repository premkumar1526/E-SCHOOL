package com.cts.eschool.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cts.eschool.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentService implements InitializingBean, DisposableBean {

    private Scanner sc = new Scanner(System.in);
    private List<Student> studentList ;


    public StudentService(){
        studentList = new ArrayList<Student>();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\n>>> The StudentService is being destroyed <<<\n");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\n>>> The StudentService has been initialized <<<\n");
    }

    public void addNewStudentDetail(int sId, String sName, double score){
        Student s = new Student(sId, sName, score);
        studentList.add(s);
    }

    public void getAllStudentDetails(){
        System.out.println("\n>>>\tStudent Details\t<<<");
        for(Student s: studentList){

            System.out.println("\nName :"+s.getsName());
            System.out.println("Id: "+s.getsId());
            System.out.println("Score: "+s.getScore());
            updateScoreLog(s.getScore());

        }
    }

    public void getStudentDetailsById(int sId){
        for(Student s: studentList){
            if(s.getsId()==sId){

                System.out.println("\nName :"+s.getsName());
                System.out.println("Id: "+s.getsId());
                System.out.println("Score: "+s.getScore());
                updateScoreLog(s.getScore());

            }
        }

    }

    public void updateStudentScore(int sId, double newScore){
        for(Student s:studentList){
            if(s.getsId() == sId){
                s.setScore(newScore);
                System.out.println(">>> Updated Score for Student <<<");
                System.out.println("Name: "+s.getsName());
                System.out.println("Updated Score: "+s.getScore());
                updateScoreLog(s.getScore());
            }
        }
    }

    public void deleteStudentDetails(int sId){
        for(Student s: studentList){
            if(s.getsId() == sId){
                System.out.println(">>> Details of Student Id \'"+s.getsId()+"\' has been removed from the records <<<");
                studentList.remove(s);
            }
        }
    }

    private void updateScoreLog(double score){
           if(score>=0 && score<=100){
            if(score<50){
                System.out.println(">>> Below Average <<<");
            } else if (score<=75) {
                System.out.println(">>> Average <<<");
            } else{
                System.out.println(">>> Above Average <<<");
            }

        }
    }
}
