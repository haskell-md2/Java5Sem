package package1;

public class CoolClass{
 
    public String publicField = "Public поле";
    protected String protectedField = "Protected поле";
    String defaultField = "Default поле";
    private String privateField = "Private поле";
    

    public void accessPublicMethod() {
        System.out.println("Public метод: доступен всем классам");
    }
    
    protected void accessProtectedMethod() {
        System.out.println("Protected метод: доступен в пакете и подклассам");
    }
    void accessDefaultMethod() {
        System.out.println("Default метод: доступен только в том же пакете");
    }
    private void accessPrivateMethod() {
        System.out.println("Private метод: доступен только внутри ParentClass");
    }
}