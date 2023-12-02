package data_access;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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

    public void GetExercisesInfo(Workout workout, String muscle) {
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

    public void FindOfType(Workout workout, String type) {

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


    public void ExercisesOnDifficulty(Workout workout, String difficulty) {

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
    public void addExercise(String user, String exerciseName, int day) {}


    @Override
    public boolean existsByMuscle(String identifer) {
        String[] validMuscles = {
                "abdominals", "abductors", "adductors", "biceps", "calves",
                "chest", "forearms", "glutes", "hamstrings", "lats",
                "lower_back", "middle_back", "neck", "quadriceps", "traps", "triceps"
        };

        for (String muscle : validMuscles) {
            if (muscle.equalsIgnoreCase(identifer)) {
                return true; // Input matches a valid muscle
            }
        }

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
