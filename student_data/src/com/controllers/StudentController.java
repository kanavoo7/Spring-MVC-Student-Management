package com.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.Student;
import com.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
StudentDao dao1;
	@RequestMapping("/")
	public ModelAndView loginpage() {
		return new ModelAndView("loginform");
		
	}
	@RequestMapping(value="/loginform",method= RequestMethod.POST)
	public ModelAndView homepage(@ModelAttribute("student")Student student)throws SQLException
	{
		String page="";
		try {
	page = dao1.login(student);
	
	}catch(Exception e)
		{
		System.out.println(e);
		}
		return new ModelAndView(page,"command",new Student());
	}
@RequestMapping("/studentform")
public ModelAndView viewForm() {
	return new ModelAndView("studentform","",new Student());
}

@RequestMapping(value="/save",method = RequestMethod.POST)
public ModelAndView save(@ModelAttribute("student")Student student ) {
	dao1.save(student);
	return new ModelAndView("redirect:/viewstudent");
	
}
@RequestMapping("/viewstudent")
public ModelAndView viewStudents()
{
	List<Student> list= dao1.getStudents();
	return new ModelAndView("viewstudent","list",list);
}
  @RequestMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable int id) {
		dao1.delete(id);
		return new ModelAndView("redirect:/viewstudent");  

}
  

}