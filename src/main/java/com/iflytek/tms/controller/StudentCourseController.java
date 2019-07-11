package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.*;
import com.iflytek.tms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 1:34
 */
@Controller
@RequestMapping("studentcourse")
public class StudentCourseController {
    @Autowired
    private StudentCourseService  scs;

    @Autowired
    private MusicTypeService musicTypeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


    @Autowired
    private StudentPriceService sps;

    @RequestMapping("index")
    public  String   studentCourseIndex(Model model,String sname, String  starttime, String endtime, String  pageSize){

       int curr=1;
       if(pageSize!=null &&!pageSize.equals("")){
           curr=Integer.parseInt(pageSize);
       }
        int everyPageSize = 4;
        int start = (curr - 1) * everyPageSize;

        int total = scs.getStudentCourseByNameAndTimeCount(sname, starttime, endtime);

        List<StudentCourse> list = scs.getStudentCourseByNameAndTime(sname, starttime, endtime,start,everyPageSize);
       PageBean pb=new PageBean();
       pb.setCurrentPageNum(curr);
       pb.setTotalDataCount(total);
       pb.setEveryPageSize(everyPageSize);


        model.addAttribute("list",list);
        model.addAttribute("sname",sname);
        model.addAttribute("starttime",starttime);
        model.addAttribute("endtime",endtime);
        model.addAttribute("pb", pb);
        return  "studentcourse1";
    }
    @RequestMapping("nameandtime")
    public  String nameAndTime(Model model,String sname, String  starttime, String endtime, String  pageSize){
       /* Map map=new HashMap<>();
        map.put("sname", sname);
        map.put("starttime",starttime);
        map.put("endtime",endtime);
        int totalDataSize = scs.getStudentCourseByNameAndTimeCount(map);
        int end = 4;
        int currentPageNum = 1;
        if(pageSize != null) {
            currentPageNum = Integer.parseInt(pageSize);
        }
        int start = (currentPageNum - 1) * end;


        model.addAttribute("sname",sname);
        model.addAttribute("starttime",starttime);
        model.addAttribute("endtime",endtime);
        map.put("start",start);
        map.put("end",end);
        List<StudentCourse> list = scs.getStudentCourseByNameAndTime(map);
        PageBean pb = new PageBean(totalDataSize, end);
        pb.setCurrentPageNum(currentPageNum);
        model.addAttribute("pb", pb);
        model.addAttribute("list", list);*/


        return "studentcourse";
    }

    @RequestMapping("goadd/{id}")
    public  String goAdd(Model  model,@PathVariable("id") Integer id ){
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList",teacherList);
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList",studentList);
        model.addAttribute("id",id);
        return "addstudentcourse";
    }

    @RequestMapping("add")
    public  String add(StudentCourse studentCourse,Integer studentid){
       scs.addStudentCourse(studentCourse);
        System.out.println(studentid+"学生id");
        StudentPrice studentPrice = sps.getStudentPriceById(studentid);
        System.out.println(studentPrice.getLeftclass()+"有没有减");
        studentPrice.setLeftclass(studentPrice.getLeftclass()-1);
        sps.updateLeftclass(studentPrice);

        return  "redirect:index";
    }









}
