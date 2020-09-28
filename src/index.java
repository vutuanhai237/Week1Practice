
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

@WebServlet(description = "handle for index.jsp", urlPatterns = { "/index" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList<Student> students = new ArrayList<Student>();
	public Student smartestStudent, stupidStudent;

	public index() {
		super();
		// Initialize some example
		students.add(new Student("Hai1", 9.0, 9.0, 10.0));
		students.add(new Student("Hai2", 9.0, 9.0, 10.0));
		students.add(new Student("Hai3", 1.0, 9.0, 10.0));
		students.add(new Student("Hai4", 10.0, 10.0, 10.0));
	}

	public Student findSmartestStudent() {
		smartestStudent = students.get(0);
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getGPA() > smartestStudent.getGPA()) {
				smartestStudent = students.get(i);
			}
		}
		return smartestStudent;
	}

	public Student findStupidStudent() {
		stupidStudent = students.get(0);
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getGPA() < stupidStudent.getGPA()) {
				stupidStudent = students.get(i);
			}
		}
		return stupidStudent;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetching data
		request.setAttribute("students", students);
		request.setAttribute("smartestStudent", this.findSmartestStudent());
		request.setAttribute("stupidStudent", this.findStupidStudent());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add new student
		String name = request.getParameter("studentNameInput");
		double mathScore = Double.parseDouble(request.getParameter("mathScoreInput"));
		double englishScore = Double.parseDouble(request.getParameter("englishScoreInput"));
		double physicalScore = Double.parseDouble(request.getParameter("physicalScoreInput"));
		students.add(new Student(name, mathScore, englishScore, physicalScore));
		try (PrintWriter out = response.getWriter()) {
			out.print(students.get(students.size() - 1).getName());
			out.print(" is added successfully!");
		}
	}

}
