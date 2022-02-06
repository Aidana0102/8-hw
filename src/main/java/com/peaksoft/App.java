package com.peaksoft;

import com.peaksoft.entity.Student;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
         Student student= new Student( "jeck"," Mikl","Java", 22);
        Student student2= new Student( "Clara"," Mike","C#", 19);
        Student student3= new Student( "Aiza","Nana","Prolog", 19);
        Student student4= new Student( "Omar"," Mirbekov","C++", 23);
        Student student5= new Student( "Aza","Nana","Kotlin", 22);
        Student student6= new Student( "Omar"," Mirbekov","Swift", 20);



        create(student);
        create(student2);
        create(student3);
        create(student4);
        create(student5);
        create(student6);
         getById(student);
         DeleteAza("Aza");
//        for (Student s :getAll()
//             ) {
//            System.out.println(s);
//        }
//
//        Update(1,"Kanym", "Mederkyzy","MPD",22);
//
//        Delete(2);
//         DeletAll();
//



    }
        public static void create (Student student ){
            Session session=HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
            System.out.println(" Added succesfully   "+ student);
        }
//
//        public static Student getById(Student id){
//        Session session=HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Student student= session.get(Student.class, (Serializable) id);
//        session.getTransaction().commit();
//        session.close();
//        return student ;
//
//        }



    public static List getById(Student id){
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List student= session.createQuery(" from Student  where name='Aza' and age>20").getResultList();
        session.getTransaction().commit();
        session.close();
        return student ;

    }




//
//    public  static List<Student> getAll(){
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        List<Student>students=session.createQuery("from Student ").getResultList();
//        session.getTransaction().commit();
//        session.close();
//             System.out.println("Finded"+students.size()+"   students ");
//
//        return students;
//    }
//






//    public  static Student Update(int id , String name, String surname, String course , int age) {
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class, id);
//        student.setId(1);
//        student.setName("Aesl");
//        student.setSurname("Kambarkanova");
//        student.setAge(18);
//
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Updated");
//        return  student;
//
//
//    }





//    public  static  Student Update(String name ) {
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class,name);
//        student.setAge(18);
//
//        Query query = session.createQuery("update Student student  set student.age=18  where student.name ='Aza' ");
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Updated");
//        return  student;
//    }





        public  static void DeleteAza(String name ){
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student>students =  session.createQuery("from Student").getResultList();
            for (Student student : students) {
                if(student.getName().equals(name)){
                    session.delete(student);
                }
            }
        session.getTransaction().commit();
        session.close();
         System.out.println("Successfully deleted");
     }


//     public  static  List<Student>  DeleteAll(){
//        Session session=HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        List<Student> students=session.createQuery(" from Student ").getResultList();
//        session.delete(students);
//        session.getTransaction().commit();
//        session.close();
//         System.out.println(" Deleted successfully");
//         return students;
//     }
//
//     public static  void DeleteAll(){
//        Session session=HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Query query=session.createQuery("delete  from Student ");
//        query.executeUpdate();
//         session.getTransaction().commit();
//         session.close();
//         System.out.println(" Deleted successfully");
//
//     }
//




}
