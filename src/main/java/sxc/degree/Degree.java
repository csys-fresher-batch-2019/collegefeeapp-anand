package sxc.degree;

public class Degree {

	public static Degree getInstance()
	{
		return new Degree();
	}
	
	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "Degree [id=" + id + ", name=" + name + "]";
	}
}
