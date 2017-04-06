package example.minitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    int selectedPosition = 0;

    Context context;
    LayoutInflater mInflater;
    List<String> questions;

    public QuestionAdapter(Context context, List<String> questions) {
        this.context = context;
        this.questions = questions;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return questions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View root = convertView;
        if (root == null) {
            root = mInflater.inflate(R.layout.question_item_layout, parent, false);
        }

        final TextView question = (TextView) root.findViewById(R.id.question);
        final TextView questionPrefix = (TextView) root.findViewById(R.id.question_prefix);
        questionPrefix.setText(position + ")");
        question.setText(questions.get(position));
        return root;
    }


}
