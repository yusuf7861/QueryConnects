package com.queryconnect.queryconnect.controller;

import com.queryconnect.queryconnect.domain.Course;
import com.queryconnect.queryconnect.repository.CourseRepository;
import com.queryconnect.queryconnect.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    CourseRepository courseRepository;



    @GetMapping("/courses")
    public String form(Model model)
    {
        model.addAttribute("cmd", new Course());
        model.addAttribute("instituteList", instituteRepository.findAll());
        return "courses";
    }

    @GetMapping("/save-course")
    public String saveCourse(Course course)
    {
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @ModelAttribute("courseList")
    public List<Course> getCourseList()
    {
        return courseRepository.findAll();
    }


}


