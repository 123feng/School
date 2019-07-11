package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.*;
import com.iflytek.tms.service.CoursePlanService;
import com.iflytek.tms.service.MusicTypeService;
import com.iflytek.tms.service.StudentService;
import com.iflytek.tms.service.TeacherService;
import com.iflytek.tms.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/4 - 6:05
 */
@Controller
@RequestMapping("courseplan")
public class CoursePlanController  {
    @Autowired
    private CoursePlanService cps;
    @Autowired
    private MusicTypeService musicTypeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


    @RequestMapping("goadd")
    public  String goAddCoursePlan(Model model){
        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        model.addAttribute("musicTypeList",musicTypeList);
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList",teacherList);
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList",studentList);
        return "addcourseplan";
    }

    @RequestMapping("addcourse")
    public  String  addCoursePlan(CoursePlan  coursePlan){
     cps.addCoursePlan(coursePlan);
       return  "redirect:index";
    }

    @RequestMapping("index")
    public  String coursePlanIndex(Model model)  {

        List<MusicType> musicTypeList = musicTypeService.getAllMusicType();
        List<Week> oneWeekDate = DateUtil.getOneWeekDate();
        model.addAttribute("oneWeekDate",oneWeekDate);
        List<CoursePlanVo> result = new ArrayList<CoursePlanVo>();
        
        for (MusicType musicType : musicTypeList) {
            CoursePlanVo cpv=new CoursePlanVo();
            cpv.setMusicType(musicType);
           int mtid=musicType.getId();

           for (int i=1;i<=7;i++){
               Map map=new HashMap<>();
               map.put("mtid",mtid );
               map.put("year",oneWeekDate.get(i-1).getYear());
               map.put("month",oneWeekDate.get(i-1).getMonth());
               map.put("day",oneWeekDate.get(i-1).getDay());
               List<CoursePlanVo> list = cps.getCoursePlanByType(map);
               try {
                   Class cls = cpv.getClass();
                   Method me = cls.getMethod("setList" + i, List.class);
                   me.invoke(cpv, list);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
            result.add(cpv);
        }

        model.addAttribute("courselist", result);
   //     model.addAttribute("musicTypeList",musicTypeList);
        return "courseplan";
    }


    @RequestMapping("delete")
    @ResponseBody
    public void delete(Integer id){
           cps.deleteCoursePlan(id);
    }


}
