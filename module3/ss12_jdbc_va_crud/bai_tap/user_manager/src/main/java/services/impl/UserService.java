package services.impl;

import models.User;
import repositories.IUserRepository;
import repositories.impl.UserRepository;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
        iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String countrySearch) throws SQLException {
        return iUserRepository.searchByCountry(countrySearch);
    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortByName();
    }

    @Override
    public List<User> sortById() {
        return iUserRepository.sortById();
    }

    @Override
    public List<User> sortByCountry() {
        return iUserRepository.sortByCountry();
    }
}