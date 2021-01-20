package com.project.moneymanager.validator;

<<<<<<< HEAD
import com.project.moneymanager.models.User;
=======
import java.util.List;

>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

<<<<<<< HEAD
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
=======
import com.project.moneymanager.models.User;
import com.project.moneymanager.repositories.UserRepository;



@Component
public class UserValidator implements Validator {
    private final UserRepository userRepository;

    public UserValidator (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean supports (Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate (Object target, Errors errors) {
        User user = (User) target;
        List <User> allusers = (List<User>) userRepository.findAll();

        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "PasswordConfirm");
        }
        for (int i = 0; i < allusers.size(); i++) {
            String email = allusers.get(i).getEmail();
            if (email.equals(user.getEmail())) {
                errors.rejectValue("email", "EmailIsAlreadyThere");
            }
>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
        }
    }
}
