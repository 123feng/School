package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.*;
import com.iflytek.tms.service.MusicTypeService;
import com.iflytek.tms.service.StudentPriceService;
import com.iflytek.tms.service.StudentService;
import com.iflytek.tms.service.TeacherService;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/2 - 11:21
 */
@Controller
@RequestMapping("studentpay")
public class StudentPriceController {
    @Autowired
    private StudentPriceService sps;

    @Autowired
    private MusicTypeService musicTypeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


    @RequestMapping("index")
    public  String  studentPayIndex(Model model){

        int totalDataSize = sps.getAllStudentPriceCount();
        int start=0;
        int end = 4;
        Map map=new HashMap<>();
        map.put("start",start);
        map.put("end", end);
        List<StudentPrice> list = sps.getPageAll(map);
        model.addAttribute("list", list);
      /*  List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);*/
        PageBean pb = new PageBean(totalDataSize, end);
        pb.setCurrentPageNum(1);
        model.addAttribute("pb", pb);
        return "studentpay";
    }

    @RequestMapping("nameandtype")
   //public  String nameAndType(Model model, @PathVariable("sname") String sname,@PathVariable("mtname") int mtname,@PathVariable("pageSize") String  pageSize){
    public  String nameAndType(Model model ,String sname, String  mtname, String  pageSize){
        Map map=new HashMap<>();
        map.put("sname", sname);
        map.put("mtname", mtname);
        int totalDataSize = sps.getStudentPriceByNameAndTypeCount(map);
        int end = 4;
        int currentPageNum = 1;
        if(pageSize != null) {
            currentPageNum = Integer.parseInt(pageSize);
        }
        int start = (currentPageNum - 1) * end;

        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);

        model.addAttribute("sname",sname);
        model.addAttribute("mtname",mtname);
        map.put("start",start);
        map.put("end",end);
        List<StudentPrice> list = sps.getStudentPriceByNameAndType(map);
        PageBean pb = new PageBean(totalDataSize, end);
        pb.setCurrentPageNum(currentPageNum);
        model.addAttribute("pb", pb);
        model.addAttribute("list", list);
        return "studentpay";
    }

    @RequestMapping("goaddstudentprice")
    public  String  goAddStudentPrice(Model model){
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);
        List<String> classlevel = new ArrayList<String>();
        classlevel.add("启蒙");
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
        return "addstudentprice";
    }


    @RequestMapping("addstudentprice")
    public  String addStudentPrice(StudentPrice studentPrice){
        sps.addStudentPrice(studentPrice);
        return "redirect:index";
    }





}
