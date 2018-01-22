package com.alice.WorkoutDiary.handler;

import com.alice.WorkoutDiary.dao.UserDAO;
import com.alice.WorkoutDiary.model.User;
import com.alice.WorkoutDiary.util.DBConnector;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserHandler implements UserDAO {

    Connection connection = DBConnector.getConnection(DBConnector.DatabaseName.WorkoutDiaryDB);

    @Override
    public void saveUser(User user) {
        String query = "INSERT INTO Users (Username, Email, Password) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int id) {

        System.out.println(id);

        String query = "SELECT UserId, Username, Email FROM Users WHERE Users.UserId =" + id;

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                user = new User(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }
}
