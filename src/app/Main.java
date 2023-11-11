package app;

import data_access.GoogleCalendarDAO;
import login.data_access.LoginUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        try{
            LoginUserDataAccessInterface dataAccess = new GoogleCalendarDAO(
                    "C:\\Users\\kuczd\\IdeaProjects\\CSC207-Group-Project\\accounts.csv",
                    userFactory);
        } catch (IOException | GeneralSecurityException e){
            throw new RuntimeException(e);
        }
    }
}
