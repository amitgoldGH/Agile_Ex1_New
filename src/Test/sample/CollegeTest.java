
package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;


public class CollegeTest {
    private College college;
    Administrator admin;

    @Before
    public void setUp() throws Exception {
        college = new College("AfekaTest");
        admin = new Administrator("Amit", 0);
        college.setAdmin(admin);
    }

    @Test
    public void testCreate5StudentsAndAddToCourse(){
        Course math = new Course("math",10010,"Sunday","08:00-12:00","a");
        college.add_Course(math);
        List<Student> studentList = IntStream.range(1,6)
                .mapToObj(num->new Student("Student #" + num,num,0,0))
                .peek(student->college.add_Student(student))
                .collect(Collectors.toList());
        for (Student s : studentList){
            s.register_To_Course(math);
        }

        for (Student s : studentList){
            assertThat(college.getAll_Students().get(s.getId()).getAssigned_Courses()).contains(math.getCourse_Id());
        }
    }

    @Test
    public void testAssignAndUpdateLecturerToExistedCourse(){

        Course math = new Course("math",10010,"Sunday","08:00-12:00","a");
        admin.register_Course_To_College(math);
        Lecturer lecturer1 = new Lecturer("boris",7,5,150000);
        Lecturer lecturer2 = new Lecturer("bella",10,7,150000);
        admin.register_Lecturer_To_College(lecturer1);
        admin.register_Lecturer_To_College(lecturer2);
//
//      admin.assign_Lecturer_To_Course(college.getAll_Lecturers().get(college.getAll_Lecturers().indexOf(lecturer1)),
//                college.getAll_Courses().get(college.getAll_Courses().indexOf(math)));
//
//        admin.assign_Lecturer_To_Course(college.getAll_Lecturers().get(college.getAll_Lecturers().indexOf(lecturer2)),
//                college.getAll_Courses().get(college.getAll_Courses().indexOf(math)));
//
//
//
//        assertThat( college.getAll_Courses().get(college.getAll_Courses().indexOf(math)).isEqualTo(lecturer2)
//
//        math.getLecturer()).isEqualTo(lecturer2.getId());
//        assertThat(lecturer2.getAttendingCourses()).contains(math.getCourseId());
//        assertThat(lecturer1.getAttendingCourses()).doesNotContain(math.getCourseId());


    }


    @After
    public void tearDown() throws Exception {
    }
}
