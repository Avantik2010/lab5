package com.studentmanagment.controller;

import com.studentmanagment.service.StudentService;

@Controller
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping ("/list")
	public String listBooks(Model theModel) {
		System.out.println("request recieved");
		List<student> theStudents = studentService.findAll();
		theModel.addAttribute ("Student",theStudents);
		return"list-Students";
		
	}
	@RequestMapping ("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent =new Student();
		
		theModel.addAttribute("Student",theStudent);
		return "Student-form";
	}
	@PostMapping ("/save")
	
	public String saveBook (@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		
		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(LastName);
			theStudent.setCourse(Course);
			theStudent.setCountry(Country);
		} else
			
			theStudent = new Student(firstName, lastName, course, country);
		studentService.save(theStudent);
		
		return"redirect:/student/list";
		
	}
	
	@RequestMapping("/delete")
	
	public String delete (@RequestParam("studentId") int theId) {
		
		studentService.deleteById(theId);
		
		
		return"redirect:/student/list";
			
	}

}
