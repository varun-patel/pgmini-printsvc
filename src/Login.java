public class Login {

    private String firstName;
    private String lastName;
    private String user;
    private String pass;
    private int[] quota;
    private boolean student;
    private boolean admin;

    public Login() {
        this("guest", "guest");
    }
    public Login(String user, String pass) {
        setUser(user);
        setPass(pass);

    }


    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }


    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getPass() {
        return pass;
    }


    public void setQuota(int[] quota) {
        this.quota = quota;
    }
    public int[] getQuota() {
        return quota;
    }


    public void setStudent(boolean student) {
        this.student = student;
    }
    public boolean isStudent() {
        return student;
    }


    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean isAdmin() {
        return admin;
    }



    @Override
    public String toString() {
        return user +","+ pass +","+ quota +","+ student +","+ admin;
    }


}
