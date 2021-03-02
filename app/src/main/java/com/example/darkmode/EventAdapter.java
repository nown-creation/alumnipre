package com.example.darkmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {
    public ArrayList<Event> MainList;

    public ArrayList<Event> SubjectListTemp;

    public EventAdapter.SubjectDataFilter subjectDataFilter;

    public EventAdapter(Context context, int id, ArrayList<Event> subjectArrayList) {

        super(context, id, subjectArrayList);

        this.SubjectListTemp = new ArrayList<Event>();

        this.SubjectListTemp.addAll(subjectArrayList);

        this.MainList = new ArrayList<Event>();

        this.MainList.addAll(subjectArrayList);
    }

    @Override
    public Filter getFilter() {

        if (subjectDataFilter == null) {

            subjectDataFilter = new EventAdapter.SubjectDataFilter();
        }
        return subjectDataFilter;
    }


    public class ViewHolder {

        TextView Date;
        TextView Event;
        TextView Time;
        TextView Place;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;


        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.list_layout, null);

            holder = new ViewHolder();

            holder.Date = (TextView) convertView.findViewById(R.id.DateValue);
            holder.Event = (TextView) convertView.findViewById(R.id.EventValue);
            holder.Time = (TextView) convertView.findViewById(R.id.TimeValue);
            holder.Place = (TextView) convertView.findViewById(R.id.PlaceValue);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Event subject = SubjectListTemp.get(position);

        holder.Date.setText(subject.getDate());
        holder.Event.setText(subject.getEvent());
        holder.Time.setText(subject.getTime());
        holder.Place.setText(subject.getPlace());

        return convertView;

    }

    private class SubjectDataFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            charSequence = charSequence.toString().toLowerCase();

            FilterResults filterResults = new FilterResults();

            if (charSequence != null && charSequence.toString().length() > 0) {
                ArrayList<Event> arrayList1 = new ArrayList<Event>();

                for (int i = 0, l = MainList.size(); i < l; i++) {
                    Event subject = MainList.get(i);

                    if (subject.toString().toLowerCase().contains(charSequence))

                        arrayList1.add(subject);
                }
                filterResults.count = arrayList1.size();

                filterResults.values = arrayList1;
            } else {
                synchronized (this) {
                    filterResults.values = MainList;

                    filterResults.count = MainList.size();
                }
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            SubjectListTemp = (ArrayList<Event>) filterResults.values;

            notifyDataSetChanged();

            clear();

            for (int i = 0, l = SubjectListTemp.size(); i < l; i++)
                add(SubjectListTemp.get(i));

            notifyDataSetInvalidated();
        }
    }
}
