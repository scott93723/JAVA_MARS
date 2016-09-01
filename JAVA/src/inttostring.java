public class inttostring {
    public static void main(String[] args) {
        String pattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        String str = "1996-08-06";

        if(str.matches(pattern)){
            //doSomething
        }
    }
}