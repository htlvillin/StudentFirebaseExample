package at.htlvillach.studentfirebaseexample;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pupil on 3/25/19.
 */

public class StudentsAdapter extends ArrayAdapter<Student> {

        public StudentsAdapter(Context context, List<Student> object){
            super(context,0, object);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView =  ((Activity)getContext()).getLayoutInflater().inflate(R.layout.activity_view_studentrecord,parent,false);
            }

            TextView tvId =  convertView.findViewById(R.id.tvId);
            TextView tvFirstname =  convertView.findViewById(R.id.tvFirstName);
            TextView tvLastname =  convertView.findViewById(R.id.tvLastName);


            Student student = getItem(position);

            tvId.setText(student.getId());
            tvFirstname.setText(student.getFirstname());
            tvLastname.setText(student.getLastname());

            return convertView;
        }

    }


