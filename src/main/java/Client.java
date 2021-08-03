public class Client {

    private String name;
    private Boolean status;
    private Integer value;

    public Client(String name, Boolean status, Integer value) {
        this.name = name;
        this.status = status;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
