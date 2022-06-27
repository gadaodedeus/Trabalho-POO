public class Login
{
    private String user;
    private String password;
    private int acesso;

    public Login(String user, String password, int ac)
    {
        this.user = user;
        this.password = password;
        this.acesso = ac;
    }

    public Login(String user, String password)
    {
        this(user, password, 1);
    }

    public Login()
    {
        this("","", 1);
    }

    public String getUser()
    {
        return this.user;
    }

    public int getAcesso()
    {
        return this.acesso;
    }

    public String getPassword()
    {
        return this.password;
    }
}