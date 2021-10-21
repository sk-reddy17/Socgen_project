package training;
import java.util.*;



 class Project {
	private String pname;
	private String company;
	private int budget;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public Project(String pname, String company, int budget) {
		super();
		this.pname = pname;
		this.company = company;
		this.budget = budget;
	}

}
 class User {
	 private int id;
	 private String name;
	 private int salary;
	 public int getId() {
	 	return id;
	 }
	 public void setId(int id) {
	 	this.id = id;
	 }
	 public String getName() {
	 	return name;
	 }
	 public void setName(String name) {
	 	this.name = name;
	 }
	 public int getSalary() {
	 	return salary;
	 }
	 public void setSalary(int salary) {
	 	this.salary = salary;
	 }
	 @Override
	 public String toString() {
	 	return "{id=" + id + ", name=" + name + ", salary=" + salary + "}";
	 }
	 public User(int id, String name, int salary) {
	 	super();
	 	this.id = id;
	 	this.name = name;
	 	this.salary = salary;
	 }

	 	
	 }

 class data
 {
	 private int credit;
	 private int left_amount;
	 private List<User> users;
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getLeft_amount() {
		return left_amount;
	}
	public void setLeft_amount(int left_amount) {
		this.left_amount = left_amount;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	 public void pushUser(User u){
	        this.users.add(u);
	    }
	public data(int credit, int left_amount, ArrayList<User> users) {
		super();
		this.credit = credit;
		this.left_amount = left_amount;
		this.users = users;
	}
	@Override
	public String toString() {
		return "data [credit=" + credit + ", left_amount=" + left_amount + ", users=" + users + "]";
	}
	 
 }
 
 class data_projects
 {
	 private int u_id;
	 private String u_name;
	 private int u_salary;
	 private Project p;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getU_salary() {
		return u_salary;
	}
	public void setU_salary(int u_salary) {
		this.u_salary = u_salary;
	}
	public Project getP() {
		return p;
	}
	public void setP(Project p) {
		this.p = p;
	}
	public data_projects(int u_id, String u_name, int u_salary, Project p) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_salary = u_salary;
		this.p = p;
	}
	@Override
	public String toString() {
		return "data_projects [u_id=" + u_id + ", u_name=" + u_name + ", u_salary=" + u_salary + ", p=" + p + "]";
	}
	 
 }


public class test3 {
	public static void main(String[] args)
	{
	data_projects dp1 = new data_projects(1, "User1", 100, new Project("Project1", "ATT",1000));
	data_projects dp2 = new data_projects(2, "User2", 150, new Project("Project2", "Google",320));
	data_projects dp3 = new data_projects(3, "User3", 500, new Project("Project1", "ATT",1000));
	
	List<data_projects> dp_list = new ArrayList<data_projects>();
	dp_list.add(dp1);
	dp_list.add(dp2);
	dp_list.add(dp3);
	
	
	
	
	Map <String, data> map = new HashMap<String, data>();
	
	for(data_projects dp:dp_list)
	{
		String s = dp.getP().getPname();
		System.out.println(s);
		User u = new User(dp.getU_id(),dp.getU_name(),dp.getU_salary());
		if(map.containsKey(s))
		{
			map.get(s).pushUser(u);
			map.get(s).setCredit(map.get(s).getCredit() + u.getSalary());
			map.get(s).setLeft_amount(map.get(s).getLeft_amount()-u.getSalary());
			
		}
		else
		{
			ArrayList<User> users = new ArrayList<>();
			users.add(u);
			data d = new data(u.getSalary(), dp.getP().getBudget()-u.getSalary(), users);
			map.put(s,d);
			
		}
	}
	for(String s:map.keySet())
	{
		System.out.println(s);
		System.out.println(map.get(s));
		System.out.println();
	}
	
	}
	
	
	
	
	
	 
	  

}
