package inf.ufg.br.mydoctor.ui.speciality;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.ui.locals.LocalsActivity;
import models.Specialties;

/**
 * Created by bruno.andrade on 24/11/2016.
 */
class SpecialityAdapter extends RecyclerView.Adapter{

    Context context;
    List<Specialties> specialtiesList;

    SpecialityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SpecialityAdapter.SpecialityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SpecialityHolder(LayoutInflater.from(context).inflate(R.layout.item_speciality, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SpecialityHolder specialityHolder = (SpecialityHolder ) holder;
        Specialties specialties = specialtiesList.get(position);
        specialityHolder.specialityName.setText(specialties.getName());
    }

    void setSpecialtiesList(List<Specialties> specialtiesList) {
        this.specialtiesList = specialtiesList;
    }

    @Override
    public int getItemCount() {
        return specialtiesList.size();
    }

    public class SpecialityHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.speciality_name) TextView specialityName;

        public SpecialityHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), LocalsActivity.class));
                }
            });
        }


    }
}
