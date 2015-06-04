package resteasysample.jaxrs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mattong
 */
@XmlRootElement(name = "Person")
public class Person {

    private static int count = 1;

    private String pid;
    private String name;
    private boolean sex = false;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        pid = "" + count;
        age = Integer.parseInt(count + "" + count);
        count++;
    }

    @XmlElement
    public String getName() {
        return name;
    }
    public Person setName(String name) {
        this.name = name;
        return this;
    }

    @XmlElement
    public String getPid() {
        return pid;
    }

    public Person setPid(String pid) {
        this.pid = pid;
        return this;
    }

    @XmlElement
    public boolean isMale() {
        return sex;
    }

    public Person setMale(boolean sex) {
        this.sex = sex;
        return this;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{'" + "pid:'" + pid + "', name:'" + name + "', sex:'" + sex + "', age:'" + age + "'}";
    }

}
