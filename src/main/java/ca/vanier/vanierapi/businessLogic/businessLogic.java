package ca.vanier.vanierapi.businessLogic;

import ca.vanier.vanierapi.entity.Course;

public class businessLogic {
    public static boolean isAvailable(Course course)
    {
        if(course.getStudent().size()>30)
        return false;
        else
        return true;
    }
}
