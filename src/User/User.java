package User;

public class User {
    private String name;
    private String mail;
    private String address;
    public Wallet wallet = new Wallet();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", mail='" + mail + '\'' +
                        ", address='" + address + '\'' + wallet.toString();
    }

}
