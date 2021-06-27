package com.training.trainingdealine.service;

import com.training.trainingdealine.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentsService {


    private List<StudentEntity> list = new ArrayList<>(
            Arrays.asList(
                    new StudentEntity("ln", "Nhận định bóng đá", "Euro", "null"),
                    new StudentEntity("lenghia", "Bóng đá Euro", "Giải Châu Á", "null")
            ));


    public List<StudentEntity> getAllStudents() {
        return list;
    }

    public StudentEntity getStudent(String id) {
        return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addStudent(StudentEntity studentEntity) {
        list.add(studentEntity);

    }

    public void updateStudent(String id, StudentEntity studentEntity) {
        for(int i = 0;i<list.size();i++){
            StudentEntity st = list.get(i);
            if(st.getId().equals(id)){
                list.set(i, studentEntity);
                return;
            }
        }
    }

    public void deleteStudent(String id) {
        list.removeIf(t->t.getId().equals(id));
    }
}
