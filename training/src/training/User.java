package training;

public class User {
private String id;
private String name;
private int salary;
public String getId() {
	return id;
}
public void setId(String id) {
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
	return "User [id=" + id + ", name=" + name + ", salary=" + salary + "]";
}
public User(String id, String name, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
}

	
}
