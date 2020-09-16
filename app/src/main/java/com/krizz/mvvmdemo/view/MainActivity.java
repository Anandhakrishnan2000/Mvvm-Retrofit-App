package com.krizz.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.krizz.mvvmdemo.R;
import com.krizz.mvvmdemo.adapter.DataAdapter;
import com.krizz.mvvmdemo.model.DataModel;
import com.krizz.mvvmdemo.model.SampleApiModel;
import com.krizz.mvvmdemo.viewmodel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    MainActivity context;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DataAdapter adapter;
    private ArrayList<DataModel> dataArray = new ArrayList<>();
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);

        dataViewModel.getDataResponseLiveData().observe(this, dataUpdateObserver);


    }

    Observer<SampleApiModel> dataUpdateObserver = new Observer<SampleApiModel>() {
        @Override
        public void onChanged(SampleApiModel sampleApiModel) {

            progressBar.setVisibility(View.GONE);
            List<DataModel> datas = sampleApiModel.getData();

            dataArray.addAll(datas);

            layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            adapter = new DataAdapter(context,dataArray);
            recyclerView.setAdapter(adapter);


        }
    };

}

