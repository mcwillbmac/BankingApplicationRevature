package project.dao;

import java.util.List;
import project.models.*;

public interface DaoInterface {

	public int insert(User u); // CREATE
	
	public int insertC(Customer cu);
	
	public int insertB(BankAdmin ba);
	public List<User> findAll(); // READ (findALL)

	public User findById(int id); // READ (return 1 by id)

	public User findByUsername(String username);// READ (return 1 by username)

	public int update(User u); // UPDATE

	public int delete(User u); // DELETE

	

}
