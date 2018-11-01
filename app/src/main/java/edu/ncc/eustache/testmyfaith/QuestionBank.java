package edu.ncc.eustache.testmyfaith;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import edu.ncc.eustache.testmyfaith.Question;

public class QuestionBank {

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    edu.ncc.eustache.testmyfaith.MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }


    public void initQuestions(Context context) {
        myDataBaseHelper = new edu.ncc.eustache.testmyfaith.MyDataBaseHelper(context);
        //list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("Finish this phrase from 'This is The Way': No higher way to peace, no finer way to...",
                    new String[]{"Joy", "Love", "Happiness", "Truth"}, "Love"));
            myDataBaseHelper.addInitialQuestion(new Question("'Our faith we must defend. His love is from our assurance' is from...",
                    new String[]{"Give us more faith", "Ever loyal", "Enduring to the end", "We will keep enduring"}, "We will keep enduring"));

            myDataBaseHelper.addInitialQuestion(new Question("Our song book is called",
                    new String[]{"Sing out with joy", "Sing out joyfully", "Sing to Jehovah", "Chant to God"}, "Sing out joyfully"));

            myDataBaseHelper.addInitialQuestion(new Question("Finish this phrase from 'This is The Way': No higher way to peace, no finer way to...",
                    new String[]{"Joy", "Love", "Happiness", "Truth"}, "Love"));
            myDataBaseHelper.addInitialQuestion(new Question("'Our faith we must defend. His love is from our assurance' is from...",
                    new String[]{"Give us more faith", "Ever loyal", "Enduring to the end", "We will keep enduring"}, "We will keep enduring"));

            myDataBaseHelper.addInitialQuestion(new Question("Our song book is called",
                    new String[]{"Sing out with joy", "Sing out joyfully", "Sing to Jehovah", "Chant to God"}, "Sing out joyfully"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}