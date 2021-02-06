package project.dao;

import java.util.List;
import project.models.*;

public interface DaoInterface {

	public int insert(User u); // CREATE
	
	public int insertC(Customer cu);
	
	public int insertB(BankAdmin ba);
	
	public int insertT(Teller tell);

	public List<User> findAll(); // READ (findALL)
	public List<Customer> findAllC();
	public List<Teller> findAllT();
	public List<BankAdmin> findAllB();

	public User findById(int id); // READ (return 1 by id)

	public User findByUsername(String username);
	public Customer findByUsernameC(String username);
	public Teller findByUsernameT(String username);
	public BankAdmin findByUsernameB(String username);// READ (return 1 by username)

	public int update(User u); // UPDATE

	public int delete(User u); // DELETE

	
	//public int[] insertB(User adm);

	

}
