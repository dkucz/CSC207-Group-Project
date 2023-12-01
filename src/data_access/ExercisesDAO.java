package data_access;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ExercisesDAO implements WorkoutDataAccessInterface {

    //documentation: https://www.api-ninjas.com/api/exercises
//    public static void main(String[] args){
//
//        ExercisesDAO owa = new ExercisesDAO();
//
//        //owa.GetExercisesInfo("chest");
//        //owa.GetExercisesInfo("balls");
//        //owa.ExercisesOnDifficulty("hard");
//        //owa.FindOfType("strongman");
//    }

    public void GetExercisesInfo(String muscle) {
        //Muscle Examples: triceps, shoulders, biceps, shoulders, back, shoulders,

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle="+muscle)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();


        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            //System.out.println(response);
            Workout workout = new Workout();
            if (responseBody.equals("[]")) {
                System.out.println("No exercises found for this muscle");
                workout.SetExercisesInfo("No exercises found for this muscle");
                return;
            }
            workout.SetExercisesInfo(responseBody);
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void FindOfType(String type) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?type="+type)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            //System.out.println(response);
            Workout workout = new Workout();
            workout.SetExercisesInfo(responseBody);
            if (responseBody.equals("[]")) {
                System.out.println("No exercises found for this type");
                return;
            }
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void ExercisesOnDifficulty(String difficulty) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?difficulty="+difficulty)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();


        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            System.out.println(response);
            Workout workout = new Workout();
            workout.SetExercisesInfo(responseBody);
            if (responseBody.equals("[]")) {
                System.out.println("Not a valid difficulty");
                return;
            }
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Workout get(String muscle) {
        return null;
    }

    @Override
    public boolean existsByName(String identifer) {
        return false;
    }

    @Override
    public boolean existsByType(String type){
        return false;
    }

    @Override
    public boolean existsByDifficulty(String difficulty) {
        return false;
    }

}
