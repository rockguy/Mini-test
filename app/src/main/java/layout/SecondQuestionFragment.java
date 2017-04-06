package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.minitest.MainActivity;
import example.minitest.QuestionAdapter;
import example.minitest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondQuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondQuestionFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    ListView SecondQuestionList;
    List<String> Questions;
    final String TrueAnswer = "6";

    public SecondQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment SecondQuestionFragment.
     */

    public static SecondQuestionFragment newInstance() {
        SecondQuestionFragment fragment = new SecondQuestionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {



        Questions = new ArrayList<>();
        Questions.add("1");
        Questions.add("2");
        Questions.add("3");
        Questions.add("4");
        Questions.add("5");
        Questions.add("6");
        Questions.add("7");
        Questions.add("8");
        Questions.add("9");
        Questions.add("10");

        TextView firstQuestion = (TextView) getActivity().findViewById(R.id.second_question);
        firstQuestion.setText("3 + 3");

        SecondQuestionList = (ListView) getActivity().findViewById(R.id.second_question_list);
        SecondQuestionList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        SecondQuestionList.setAdapter(new QuestionAdapter(getContext() ,Questions));
        SecondQuestionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT);
                TextView t = (TextView) view.findViewById(R.id.question);

                if(t.getText().equals(TrueAnswer)){
                    MainActivity.Counter[MainActivity.currentQuestion] = 1;
                }
                MainActivity.Navigate(MainActivity.ListOfPages.Result);
            }
        });

        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_question, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
