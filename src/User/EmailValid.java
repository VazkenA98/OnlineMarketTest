package User;

public class EmailValid {
    private String address;
    private String[] s = {"mail.ru", "gmail.com", "yandex.ru", "yahoo.ru", "hotmail.com"};


    public EmailValid() {

    }

    public EmailValid(String address) {
        this.address = address;


    }

    public boolean hasValidMail() {

        for (int i = 0; i < s.length; i++)
            if (address.endsWith("@" + s[i]))
                return true;
        return false;


    }

    public boolean hasVaildLetters() {
        char ch = address.charAt(0);
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9' || ch == '.')
            return true;
        return false;
    }

    public boolean isVaild() {
        boolean valid = false;
        if (hasVaildLetters() == true && hasValidMail() == true) {
            valid = true;
        } else {
            System.out.println("you entered a vaild mail!");
            valid = false;
        }
        return valid;
    }
}
