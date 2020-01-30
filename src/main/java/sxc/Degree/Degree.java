package sxc.Degree;

public class Degree {

	int id;
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

	String name;

	@Override
	public String toString() {
		return "Degree [id=" + id + ", name=" + name + "]";
	}
}
