package by.tms.dao;

import by.tms.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDataBaseDao implements UserDao {

    private Connection connection;

    private static final String CREATE_USER = "INSERT INTO users VALUES (default, ?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String GET_BY_LOGIN = "SELECT * FROM users WHERE login=? ";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String UPDATE_BY_ID = "UPDATE users SET login=?, name = ?, password = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE  FROM users WHERE id=?";

    public UserDataBaseDao(Connection connection)  {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(CREATE_USER);
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getPassword());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException();
    }

    @Override
    public Optional<User> getByLogin(String login) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1, login);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
      return  Optional.empty();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(GET_ALL);
           while (resultSet.next()) {
               users.add(new User(resultSet.getString("name"),
                       resultSet.getString("login"),
                       resultSet.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users.isEmpty()){
            throw new NoResultException();
        }
        return  users;
    }

    @Override
    public void updateById(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setLong(4, user.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
       try {
           PreparedStatement st = connection.prepareStatement(DELETE_BY_ID);
           st.setLong(1, id);
           st.execute();
       } catch (SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public boolean containsById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);
            return st.executeQuery().next();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean containsByLogin(String login) {
        try{
            PreparedStatement st =connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1, login);
            return st.executeQuery().next();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }

//    public static void main(String[] args) throws SQLException {
//        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","Vorobei55");
//        UserDataBaseDao userDataBaseDao=new UserDataBaseDao(connection);
//        userDataBaseDao.create(new User("Vasya", "Vasya123", "12356"));
//        userDataBaseDao.create(new User("Masha", "Masha34", "778899"));
//        System.out.println(userDataBaseDao.getById(1));
//        System.out.println(userDataBaseDao.getByLogin("Vasya123"));
//        System.out.println(userDataBaseDao.getAll());
//        userDataBaseDao.deleteById(0);
//        System.out.println(userDataBaseDao.containsByLogin("Vasya123"));
//    }
}
