package staffinfo;

import java.text.ParseException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id")
    private Integer id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private String Age;
    @Column(name = "staff_email")
    private String email;

    /*
    public int getId() {
        return id;
    }
     */
    public void setId(int id) {
        this.setId((Integer) id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() throws ParseException {
        Age = calculateAge(Age) + " Years";
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String calculateAge(String birthDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(birthDate);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(l, now);
        String ageCal = String.valueOf(diff.getYears());

        return ageCal;
    }
}
