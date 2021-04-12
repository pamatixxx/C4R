import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_PATTERN = "[a-zA-Z]{1}+([a-zA-Z0-9\\-\\_\\.]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
    private static final String NAME_PATTERN = "[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?+[a-zA-Z]+(\\s)?";


    public String validationUsers(User user) { // validate User

        Pattern mail = Pattern.compile(EMAIL_PATTERN);
        Matcher matcherMail = mail.matcher(user.geteMail());

        Pattern name = Pattern.compile(NAME_PATTERN);
        Matcher matcherName = name.matcher(user.getName());

        if (!matcherMail.matches()) {
            return "e-mail не соответствует условию. \\n"; // incorrect email input
        }

        if (!matcherName.matches()) {
            return "name не соответствует условию. \\n"; // incorrect name input
        }

        return "check";

    }
}
