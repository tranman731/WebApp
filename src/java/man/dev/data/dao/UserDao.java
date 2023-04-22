package man.dev.data.dao;

import java.util.List;

import man.dev.data.model.User;

public interface UserDao {
	public boolean insert(User user);
	public boolean update(User user);	
	public boolean delete(int Id);
	public User find(int Id);
	public List<User> findAll();
	
}
