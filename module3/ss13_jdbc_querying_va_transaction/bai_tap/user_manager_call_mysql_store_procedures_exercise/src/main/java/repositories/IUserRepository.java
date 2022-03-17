package repositories;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchByCountry(String countrySearch) throws SQLException;

    public List<User> sortByName();

    public List<User> sortById();

    public List<User> sortByCountry();

    public User getUserById(int id) throws SQLException;

    public void insertUserStore(User user) throws SQLException;

    public boolean updateUserProcedure(User user) throws SQLException;

    public boolean deleteUserProcedure(int id) throws SQLException;
}
