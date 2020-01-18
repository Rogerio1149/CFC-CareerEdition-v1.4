package ui;

/*
  Created by Achi Jones on 3/29/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import antdroid.cfbcoach.R;

public class LeagueHistoryList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final String userTeamAbbr;

    public LeagueHistoryList(Context context, String[] values, String userTeamAbbr) {
        super(context, R.layout.league_history_list_item, values);
        this.context = context;
        this.values = values;
        this.userTeamAbbr = userTeamAbbr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.league_history_list_item, parent, false);
        TextView textTop = rowView.findViewById(R.id.textViewLeagueHistoryTop);
        TextView textMiddle = rowView.findViewById(R.id.textViewLeagueHistoryMiddle);
        TextView textBottom = rowView.findViewById(R.id.textViewLeagueHistoryBottom);
        String[] record = values[position].split("\n");
        if (record.length == 3) {
            textTop.setText(record[0]);
            textMiddle.setText(record[1]);
            textBottom.setText(record[2]);
            if (record[1].split(" ")[1].equals(userTeamAbbr)) {
                // User team won NCG, make it special color
                textMiddle.setTextColor(Color.parseColor("#5994de"));
            }
            if (record[2].split(" ")[5].equals(userTeamAbbr)) {
                // User team won POTY, make it special color
                textBottom.setTextColor(Color.parseColor("#5994de"));
            }
        } else if (record.length == 4) {
            textTop.setText(record[0]);
            textMiddle.setText(record[1]);
            textBottom.setText(record[2] + "\n" + record[3]);
            if (record[1].split(" ")[1].equals(userTeamAbbr)) {
                // User team won NCG, make it special color
                textMiddle.setTextColor(Color.parseColor("#5994de"));
            }
            if (record[2].split(" ").length > 5 && record[2].split(" ")[5].equals(userTeamAbbr)) {
                // User team won POTY, make it special color
                textBottom.setTextColor(Color.parseColor("#5994de"));
            }
            if (record[3].split(" ").length > 5 && record[3].split(" ")[5].equals(userTeamAbbr)) {
                // User team won POTY, make it special color
                textBottom.setTextColor(Color.parseColor("#5994de"));
            }
        }

        return rowView;
    }
}
