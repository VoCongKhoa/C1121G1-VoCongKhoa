package services;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchByCountry(String countrySearch) throws SQLException;

    public List<User> sortByName();

    public List<User> sortById();

    public List<User> sortByCountry();

    public void insertUserStore(User userCreate) throws SQLException;
}
