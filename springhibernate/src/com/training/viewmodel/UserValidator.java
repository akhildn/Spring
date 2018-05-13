package com.training.viewmodel;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

 
@Component
public class UserValidator implements Validator {
 
    public boolean supports(Class<?> clazz) {
        return LoginBean.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
    	LoginBean user = (LoginBean)target;
        int age = user.getAge();        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "customer.age.empty", "Age is required");
        
        //Custom validation        
        if(age < 18 || age > 60){
            errors.rejectValue("age", "customer.age.range.invalid", "Age should be between 18 and 60");
        }
    
    }
}
