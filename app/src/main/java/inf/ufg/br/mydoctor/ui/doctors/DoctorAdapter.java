package inf.ufg.br.mydoctor.ui.doctors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.R;
import models.User;

/**
 * Created by bruno.andrade on 24/11/2016.
 */
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.LocalViewHolder>{

    Context context;
    List<User> doctors;

    public DoctorAdapter(Context context) {
        this.context = context;
    }

    @Override
    public DoctorAdapter.LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_local, parent, false);
        return new LocalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctorAdapter.LocalViewHolder holder, int position) {
        User user = doctors.get(position);
        holder.localName.setText(user.getFirstName());
    }

    public void setUsers(List<User> doctors) {
        this.doctors= doctors;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return doctors == null ? 0 : doctors.size();
    }

    class LocalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.local_name) TextView localName;

        public LocalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
