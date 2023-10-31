package app;

import data_access.FileUserDataAccessObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        try{
            FileUserDataAccessObject dataAccess = new FileUserDataAccessObject(
                    "C:\\Users\\kuczd\\IdeaProjects\\CSC207-Group-Project\\accounts.csv",
                    userFactory);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
