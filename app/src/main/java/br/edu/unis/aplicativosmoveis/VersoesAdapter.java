package br.edu.unis.aplicativosmoveis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersoesAdapter extends RecyclerView.Adapter<VersoesAdapter.ViewHolder> {

    private List<Versao> versoes;

    public VersoesAdapter(List<Versao> versoes) {
        this.versoes = versoes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.versoes_itens, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Versao versao = this.versoes.get(position);
        holder.bind(versao);
    }

    @Override
    public int getItemCount() {
        return this.versoes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Versao versao) {
            TextView txtVersao = itemView.findViewById(R.id.txt_versoes_versao);
            TextView txtNome = itemView.findViewById(R.id.txt_versoes_nome);
            TextView txtAno = itemView.findViewById(R.id.txt_versoes_ano);
            LinearLayout linearLayout = itemView.findViewById(R.id.linear_versoes_itens);

            txtVersao.setText(versao.getVersao());
            txtNome.setText(versao.getNome());
            txtAno.setText(versao.getAno());
            linearLayout.setBackgroundResource(versao.getBackgroundColor());
        }
    }
}
