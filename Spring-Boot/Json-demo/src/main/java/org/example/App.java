package org.example;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Student student =new Student();
        student.setCity("Kolkata");
        student.setName("Rahul");
        student.setCourse("kunal course");
        System.out.println(student);

        ObjectMapper objectMapper =new ObjectMapper();
        String object = objectMapper.writeValueAsString(student);
        System.out.println(object);

    }
}
