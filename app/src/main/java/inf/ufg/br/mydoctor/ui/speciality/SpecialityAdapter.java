package inf.ufg.br.mydoctor.ui.speciality;

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
import models.Speciality;

/**
 * Created by bruno.andrade on 24/11/2016.
 */
class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.SpecialityHolder>{

    Context context;
    List<Speciality> specialityList;

    SpecialityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SpecialityAdapter.SpecialityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_speciality, parent);
        return new SpecialityHolder(view);
    }

    @Override
    public void onBindViewHolder(SpecialityAdapter.SpecialityHolder holder, int position) {
        Speciality speciality = specialityList.get(position);
        holder.specialityName.setText(speciality.getName());
    }

    void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return specialityList.size();
    }

    class SpecialityHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.speciality_name) TextView specialityName;

        SpecialityHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
