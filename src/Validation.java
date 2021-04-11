import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_PATTERN = "[a-zA-Z]{1}+([a-zA-Z0-9\\-\\_\\.]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
    private static final String NAME_PATTERN = "[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?";


    public String validationUsers(Users users) {
        String massage = "";

        Pattern mail = Pattern.compile(EMAIL_PATTERN);
        Matcher m = mail.matcher(users.geteMail());

        Pattern name = Pattern.compile(NAME_PATTERN);
        Matcher mm = name.matcher(users.getName());


        if (m.matches()!=true){
            massage+="e-mail не соответствует условию. \\n";
        }
        else if (mm.matches()!=true){
            massage+="name не соответствует условию. \\n";
        }
        else massage += "check";


        return massage;
    }
}
