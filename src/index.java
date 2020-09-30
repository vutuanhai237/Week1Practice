import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.ListStudent;
import model.Score;
import model.Student;

@WebServlet(description = "handle for index.jsp", urlPatterns = { "/index" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ListStudent listStudent;
	
	//Cuong Comments
	//Can you add configuration into .gitignore to ignore generated files when building (class, jar ...)
	//We don't need it or don't commit those files

	public index() {
		super();
		// Initialize some example
		Score math = new Score("math", 5.0);
		Score english = new Score("english", 9.0);
		Score physical = new Score("physical", 9.0);
		ArrayList<Score> scores = new ArrayList<Score>();
		scores.add(math);
		scores.add(english);
		scores.add(physical);
		Student s = new Student("Hai1", 18, "12C1", "Gia Lai", scores);
		Student s2 = new Student("Hai2", 18, "12C1", "Gia Lai", scores);
		listStudent = new ListStudent();
		listStudent.add(s);
		listStudent.add(s2);
		//Cuong Comments
		//Can you put these functions in to service package
		//In service package we will do business logic.
		//If a function which is used many times you can put it into Utils package
		//function getSmartestStudent(listStudent){}
		//Same for getStupidStudent
		listStudent.getSmartestStudent();
		listStudent.getStupidStudent();
	}

	//Cuong Comments
	//Change this function to parsingToJson()
	//Can you help to add java doc for each function if possible
	public String validateStudents() {
		String listStudentJSON = new Gson().toJson(this.listStudent);
		return listStudentJSON;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetching data
		request.setAttribute("listStudent", String.valueOf(this.validateStudents()));
		
		//Cuong Comments
		//Is this redundant code?
		request.setAttribute("number", String.valueOf(1));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add new student
		String name = request.getParameter("studentNameInput");
		int age = Integer.parseInt(request.getParameter("studentAgeInput"));
		String classes = request.getParameter("studentClassesInput");
		String province = request.getParameter("studentProvinceInput");
		double mathScore = Double.parseDouble(request.getParameter("mathScoreInput"));
		double englishScore = Double.parseDouble(request.getParameter("englishScoreInput"));
		double physicalScore = Double.parseDouble(request.getParameter("physicalScoreInput"));
		try (PrintWriter out = response.getWriter()) {
			String message = regexAddNewStudent(name, age, classes, province, mathScore, englishScore, physicalScore);
			if (message == "valid") {
				out.print(name + " is added successfully!");
				ArrayList<Score> newScores = new ArrayList<Score>();
				newScores.add(new Score("math", mathScore));
				newScores.add(new Score("english", englishScore));
				newScores.add(new Score("physical", physicalScore));
				listStudent.add(new Student(name, age, classes, province, newScores));
			} else {
				out.print(message + ", please try again!");
			}
		}
	}

	//Cuong Comments
	//validate function should be put into service package too :)
	public String regexAddNewStudent(String name, int age, String classes, String province, double mathScore,
			double englishScore, double physicalScore) {
		String message = "valid";
		if (name.length() > 30) {
			message = "Name was tool long!";
		} else if (age < 0 || age > 100) {
			message = "Age is not valid";
		} else if (classes.length() < 1 || classes.length() > 10) {
			message = "Class 's name is not valid";
		} else if (mathScore < 0 || mathScore > 10) {
			message = "Math score is not valid";
		} else if (englishScore < 0 || englishScore > 10) {
			message = "English score is not valid";
		} else if (physicalScore < 0 || physicalScore > 10) {
			message = "Physical score is not valid";
		}

		return message;
	}
}
