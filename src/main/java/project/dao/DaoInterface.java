package project.dao;

import java.util.List;
import project.models.*;

public interface DaoInterface {

	public int insert(User u); // CREATE
	
	public int insertC(Customer cu);
	
	public int insertB(BankAdmin ba);
	
	public int insertT(Teller tell);

	public List<User> findAll();
	
	public List<Customer> findAllC();
	
	public List<Teller> findAllT();
	
	public List<BankAdmin> findAllB();

	public User findById(int id); 
	
	public Customer findByIdC(int id);

	public Teller findByIdT(int id);

	public BankAdmin findByIdB(int id);

	public User findByUsername(String username);
	
	public Customer findByUsernameC(String username);
	
	public Teller findByUsernameT(String username);
	
	public BankAdmin findByUsernameB(String username);// READ (return 1 by username)

	public int update(User u); 
	
	public int update(Customer u);
	
	public int update(Teller u); 
	
	public int update(BankAdmin u); 

	public int delete(User u); 

	public int delete(Customer u);
	
	public int delete(Teller u);
	
	public int delete(BankAdmin u);
	
}

	
