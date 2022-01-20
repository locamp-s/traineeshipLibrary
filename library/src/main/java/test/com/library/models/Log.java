package test.com.library.models;

import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dataStart;
    private String dataReturn;

    public Log(int id, String dataStart, String dataReturn) {
        this.id = id;
        this.dataStart = dataStart;
        this.dataReturn = dataReturn;
    }

    public Log() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(String dataReturn) {
        this.dataReturn = dataReturn;
    }
}
