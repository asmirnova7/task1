import java.math.BigDecimal;

public class Student {
    Integer id;
    String name;
    BigDecimal stipend;

    public Student(Integer id, String name, BigDecimal stipend) {
        this.id = id;
        this.name = name;
        this.stipend = stipend;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStipend() {
        return stipend;
    }

    public void setStipend(BigDecimal stipend) {
        this.stipend = stipend;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Student))
            return false;

        Student student = (Student) obj;

        return this.id == student.id &&
                this.name != null && this.name.equals(student.name) &&
                this.stipend == student.stipend;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = id * result;
        return result;
    }

    @Override
    public String toString() {
        return "Student {\n id = " + id +
                ",\n name = " + name +
                ",\n stipend = " + stipend + "\n}";
    }
}
