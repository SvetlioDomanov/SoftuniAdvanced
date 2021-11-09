package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        String url = this.urls.get(0);
        Pattern pattern = Pattern.compile("^\\D+$");
        Matcher matcher = pattern.matcher(url);
        if(matcher.find()){
            this.urls.remove(0);
            return String.format("Browsing: %s!",url);
        }
        this.urls.remove(0);
        return "Invalid URL!";
    }

    @Override
    public String call() {
        String number = this.numbers.get(0);
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            this.numbers.remove(0);
            return String.format("Calling... %s",number);
        }
        this.numbers.remove(0);
        return "Invalid number!";
    }
}
