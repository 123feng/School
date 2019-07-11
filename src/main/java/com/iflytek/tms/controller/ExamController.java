package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.*;
import com.iflytek.tms.service.ExamService;
import com.iflytek.tms.service.MusicTypeService;
import com.iflytek.tms.service.StudentService;
import com.iflytek.tms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 2:51
 */
@Controller
@RequestMapping("exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @Autowired
    private MusicTypeService musicTypeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("index")
    public String examIndex(Model model){
        Integer totalCount = examService.getExamTotalCount();
        model.addAttribute("totalCount",totalCount);
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        List<StudentVo> nameAndCount = examService.getExamNameAndCount();
        List<List<Exam>> list=new ArrayList<>();
        for (int i = 0; i <musicTypeList.size(); i++) {
            List<Exam> lists= examService.getExamByMtid(musicTypeList.get(i).getId());
            list.add(lists);
        }
        model.addAttribute("list",list);
        model.addAttribute("musicTypeList",musicTypeList);
        model.addAttribute("nameAndCount",nameAndCount);
        return  "exam";
    }


    @RequestMapping("delete")
    @ResponseBody
    public void delete(Integer id) {
        examService.deleteExam(id);
    }




    @RequestMapping("goAdd")
    public  String  goAddStudentPrice(Model model){
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);
        List<String> classlevel = new ArrayList<String>();
        classlevel.add("一");
        classlevel.add("二");
        classlevel.add("三");
        classlevel.add("四");
        classlevel.add("五");
        classlevel.add("六");
        classlevel.add("七");
        classlevel.add("八");
        classlevel.add("九");
        classlevel.add("十");
        model.addAttribute("classlevel",classlevel);
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList",teacherList);
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList",studentList);
        return "addexam";
    }
    @RequestMapping("add")
    public  String addExam(Exam exam){
        examService.addExam(exam);
        return "redirect:index";
    }




}
