package by.tms.service;

import by.tms.dao.UserDataBaseDao;
import by.tms.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.Optional;


public class UsersService {
    public static boolean getAnswerUserRegistrationIsOrNo(ServletContext sc, HttpSession hs){
        User user = (User) sc.getAttribute("userRegistration");
        UserDataBaseDao userDataBaseDao = new UserDataBaseDao((Connection) hs.getAttribute("connection"));
        boolean answer = userDataBaseDao.containsByLogin((String) sc.getAttribute("loginRegistration"));
        if (answer){

        } else {
            userDataBaseDao.create(user);
        }
        return answer;
    }

    public static boolean getAnswerUserAuthorizationIsOrNo(HttpSession hs){
        UserDataBaseDao userDataBaseDao = new UserDataBaseDao((Connection) hs.getAttribute("connection"));
        Optional<User> userFromDB = userDataBaseDao.getByLogin((String) hs.getAttribute("loginAuthorization"));
        if (userFromDB.isEmpty()){
            String error = "Нет такого пользователя";
            hs.setAttribute("errorAuthorization", error);
            return false;
        } else {
           User user = userFromDB.get();
           if(user.getLogin().equals(hs.getAttribute("loginAuthorization")) && user.getPassword().equals(hs.getAttribute("passwordAuthorization"))){
               hs.setAttribute("helloUserByLogin", user.getLogin());
               return true;
           } else {
               String error = "Неверный логин или пароль";
               hs.setAttribute("errorAuthorization", error);
               return false;
           }
        }

    }
}
