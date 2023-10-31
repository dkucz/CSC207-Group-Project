package data_access;

import app.UserFactory;
import entity.User;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final HashMap<String, User> accounts = new HashMap<String, User>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);

        if (csvFile.length() == 0){
            save();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String header = reader.readLine();
            assert header.equals("username, password");

            String row;
            while((row = reader.readLine()) != null){
                String[] columns = row.split(",");
                String username = String.valueOf(columns[headers.get("username")]);
                String password = String.valueOf(columns[headers.get("password")]);
                User user = userFactory.create(username, password);
                accounts.put(username, user);
            }
        }
    }

    public User get(String username){return accounts.get(username);}

    public boolean userExists(String username){return accounts.containsKey(username);}

    private void save(User user) throws IOException {
        accounts.put(user.getUsername(), user);
        save();
    }

    private void save() throws IOException {
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter(csvFile));
        bufferedWriter.write(String.join(",", headers.keySet()));
        bufferedWriter.newLine();

        for (User user: accounts.values()){
            String line = String.format("%s, %s",
                    user.getUsername(), user.getPassword());
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
