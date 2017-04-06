package example.minitest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import layout.FirstQuestionFragment;
import layout.ResultFragment;
import layout.SecondQuestionFragment;
import layout.StartFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener,
        FirstQuestionFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener,
        SecondQuestionFragment.OnFragmentInteractionListener{

    private static FragmentManager manager;
    private static FragmentTransaction transaction;
    public static int[] Counter  = new int[2];
    public static int currentQuestion = -1;
    public static int totalScore(){
        int sum = 0;
        for(int i = 0; i < Counter.length; i++){
            sum += Counter[i];
        }
        return sum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.contentContainer, StartFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public enum ListOfPages{Start, FirstQuestion, SecondQuestion, ThirdQuestion, Result}

    public static void Navigate(ListOfPages dest){
        transaction = manager.beginTransaction();
        switch(dest){
            case Start:
                transaction.replace(R.id.contentContainer, StartFragment.newInstance());
                Counter = new int[2];
                currentQuestion = -1;
                break;
            case FirstQuestion:
                transaction.replace(R.id.contentContainer, FirstQuestionFragment.newInstance());
                MainActivity.currentQuestion += 1;
                break;
            case SecondQuestion:
                transaction.replace(R.id.contentContainer, SecondQuestionFragment.newInstance());
                MainActivity.currentQuestion += 1;
                break;
            case Result:
                transaction.replace(R.id.contentContainer, ResultFragment.newInstance());
                MainActivity.currentQuestion += 1;
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public static void BackNavigate() {
        MainActivity.currentQuestion -= 1;
        Counter[currentQuestion] = 0;
        manager.popBackStack();
    }

    @Override
    public void onBackPressed() {
        MainActivity.currentQuestion -= 1;
        Counter[currentQuestion] = 0;
        super.onBackPressed();

    }
}
