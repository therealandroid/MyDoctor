package inf.ufg.br.mydoctor.ui.locals;

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
import models.Local;

/**
 * Created by bruno.andrade on 24/11/2016.
 */
public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.LocalViewHolder>{

    Context context;
    List<Local> locals;

    public LocalAdapter(Context context) {
        this.context = context;
    }

    @Override
    public LocalAdapter.LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_local, parent, false);
        return new LocalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocalAdapter.LocalViewHolder holder, int position) {
        Local local = locals.get(position);
        holder.localName.setText(local.getName());
    }

    public void setLocals(List<Local> locals) {
        this.locals = locals;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return locals.size();
    }

    class LocalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.local_name) TextView localName;

        public LocalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
