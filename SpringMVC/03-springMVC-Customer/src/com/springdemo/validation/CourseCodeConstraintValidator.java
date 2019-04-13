package com.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefixes=courseCode.value();

    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result=false;
        if(code!=null){
            for(String tempPrefix : coursePrefixes) {
                result = code.startsWith(tempPrefix);
                if(result){
                    break;
                }
            }
        } else {
            result=false;
        }
            return result;
    }
}
