package project.dao;

import java.util.List;
import project.models.*;

public interface DaoInterface {
	
	public int insertC(Customer cu);
	
	public int insertB(BankAdmin ba);
	
	public int insertT(Teller tell);
	
	public List<Customer> findAllC();
	
	public List<Teller> findAllT();
	
	public List<BankAdmin> findAllB();

	public Customer findByIdC(int id);

	public Teller findByIdT(int id);

	public BankAdmin findByIdB(int id);
	
	public Customer findByUsernameC(String username);
	
	public Teller findByUsernameT(String username);
	
	public BankAdmin findByUsernameB(String username);
	
	public int delete(Customer u);
	
	public int delete(Teller u);
	
	public int delete(BankAdmin u);

	
	
	
}

	
