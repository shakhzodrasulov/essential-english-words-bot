package uz.rasulov.essentialenglishwordsbotv2.processes;

/**
 * Created by SHR on 14.01.2022
 */
public enum Processes {

    LEARN_NEW_WORDS("learn_new_words"),
    TEST_YOURSELF("test_yourself");

    private final String value;

    Processes(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
