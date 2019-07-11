package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.MusicType;
import com.iflytek.tms.pojo.Student;
import com.iflytek.tms.pojo.StudentVo;
import com.iflytek.tms.service.MusicTypeService;
import com.iflytek.tms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 9:55
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MusicTypeService musicTypeService;

    @RequestMapping("index")
    public  String studentIndex(Model model){
        Integer totalCount = studentService.getStudentTotalCount();
        model.addAttribute("totalCount",totalCount);
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        List<StudentVo> nameAndCount = studentService.getMusicTypeNameAndCount();
        List<List<Student>> list=new ArrayList<>();
        for (int i = 0; i <musicTypeList.size(); i++) {
            List<Student> lists= studentService.getStudentByMusicTypeId(musicTypeList.get(i).getId());
            list.add(lists);
         }
            model.addAttribute("list",list);
            model.addAttribute("musicTypeList",musicTypeList);
            model.addAttribute("nameAndCount",nameAndCount);


        return  "main";
    }
    @RequestMapping("editStudent/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model){
        Student student = studentService.getStudentById(id);
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
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
        model.addAttribute("student",student);
        model.addAttribute("musicTypeList",musicTypeList);
        return  "updatestudent";
    }

    @RequestMapping("update")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "main";
    }
    @RequestMapping("addStudent")
    public String addStudent(Model model) {
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);
      return "addstudent";
    }
    @RequestMapping("addStudentSub")
    public  String addStudentSub(Student student){
        studentService.addStudent(student);
        return  "redirect:index";
    }










}
