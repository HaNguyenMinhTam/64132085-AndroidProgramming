package til.edu.todolistapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter {
    List<TASKS> dataSource;
    public TaskRVadapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }

    //
    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTenVCL;
        TextView tvDeadline;

        public int position;
        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL = itemView.findViewById(R.id.textViewTenVCL);
            tvDeadline = itemView.findViewById(R.id.textViewThoiGian);
        }

        @Override
        public void onClick(View v) {
            // Lấy vị trí
            int vtClicked = getAdapterPosition();

            // Lục ở nguồn dữ liệu
            TASKS taskClicked = dataSource.get(vtClicked);

            // Xử lí, Toast lên
            Toast.makeText(v.getContext(), "Bạn vừa chọn việc " + taskClicked.getTen(), Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TaskItemViewHolder viewHolder = (TaskItemViewHolder) holder;
        viewHolder.position = position;
        TASKS task = dataSource.get(position);
        ((TaskItemViewHolder) holder).tvTenVCL.setText(task.getTen());
        ((TaskItemViewHolder) holder).tvDeadline.setText(task.getDeadline());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
