package com.example.greads;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragment_general extends Fragment {
    private RecyclerView rv;
    private News_Adapter newsAdapter;
    private List<News_Model> news_models;
    View view;

    public fragment_general(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.general, container, false);
        rv = (RecyclerView) rootview.findViewById(R.id.rv_general);
        News_Adapter newsAdapter = new News_Adapter(getContext(), news_models);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(newsAdapter);

        return rootview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        news_models = new ArrayList<>();
        news_models.add(new News_Model("Buruh Tantang Demokrat-PKS Turunkan Massa Tolak Omnibus Law", R.drawable.politik,
                "CNN Indonesia", " Rabu, 07/10/2020 14:17 WIB",
                " Medan, CNN Indonesia -- Akumulasi Kemarahan Buruh dan Rakyat (Akbar) Sumatera Utara (Sumut) menantang PKS dan Partai Demokrat untuk mengerahkan massa ke jalan memprotes RUU Omnibus Law Cipta Kerja."));
        news_models.add(new News_Model("Bos IMF Sebut Ekonomi Global Membaik, tapi...", R.drawable.ekonomi,
                "detikFinance", "Selasa, 06 Okt 2020 22:15 WIB",
                "Jakarta - International Monetary Fund (IMF) menilai kondisi perekonomian global saat ini sudah tidak seburuk pada bulan Juni 2020. Hal itu juga yang akan menjadi dasar Dana Moneter Internasional merevisi outlook perekonomian global tahun 2020. "));
        news_models.add(new News_Model(" Sandy Walsh Soal Gabung Mechelen", R.drawable.olahraga
                , "CNN Indonesia", "Rabu,07/10/2020 19:30 WIB",
                "Jakarta, CNN Indonesia -- Pemain keturunan Indonesia, Sandy Walsh, kini memperkuat klub KV Mechelen yang berkompetisi di level tertinggi kompetisi sepak bola Belgia."));
        news_models.add(new News_Model("Bos IMF Sebut Ekonomi Global Membaik, tapi...", R.drawable.ekonomi,
                "detikFinance", "Selasa, 06 Okt 2020 22:15 WIB",
                "Jakarta - International Monetary Fund (IMF) menilai kondisi perekonomian global saat ini sudah tidak seburuk pada bulan Juni 2020. Hal itu juga yang akan menjadi dasar Dana Moneter Internasional merevisi outlook perekonomian global tahun 2020. "));
        news_models.add(new News_Model("Kiat Mencegah Penyakit Jantung sejak Muda, Simak Saran Dokter", R.drawable.kesehatan,
                "tempo.co", "Jumat, 2 Oktober 2020 16:05 WIB",
                "TEMPO.CO, Jakarta - Kementerian Kesehatan pada 2013 mengestimasi sebanyak 39 persen penderita penyakit jantung di tanah air berusia kurang dari 44 tahun. Dari jumlah itu, sebanyak 22 persen di antaranya berusia 15–35 tahun, yang tergolong usia produktif."));
        news_models.add(new News_Model("Bikin One It Kangen, Ini Kabar Terbaru dari 11 Member X1 Setelah Bubar", R.drawable.entertainment,
                "IDN Times ", " 21 Feb 20 | 13:55",
                "Boy group asal Korea Selatan, X1 merupakan salah satu rookie yang sangat legendaris di dunia KPop. Mereka sudah mencetak berbagai prestasi sejak awal debut, bahkan beberapa di antaranya dapat disejajarkan dengan idol-idol senior. "));
        news_models.add(new News_Model("Kiat Mencegah Penyakit Jantung sejak Muda, Simak Saran Dokter", R.drawable.kesehatan,
                "tempo.co", "Jumat, 2 Oktober 2020 16:05 WIB",
                "TEMPO.CO, Jakarta - Kementerian Kesehatan pada 2013 mengestimasi sebanyak 39 persen penderita penyakit jantung di tanah air berusia kurang dari 44 tahun. Dari jumlah itu, sebanyak 22 persen di antaranya berusia 15–35 tahun, yang tergolong usia produktif."));
        news_models.add(new News_Model("Bos IMF Sebut Ekonomi Global Membaik, tapi...", R.drawable.ekonomi,
                "detikFinance", "Selasa, 06 Okt 2020 22:15 WIB",
                "Jakarta - International Monetary Fund (IMF) menilai kondisi perekonomian global saat ini sudah tidak seburuk pada bulan Juni 2020. Hal itu juga yang akan menjadi dasar Dana Moneter Internasional merevisi outlook perekonomian global tahun 2020. "));
        news_models.add(new News_Model("Kiat Mencegah Penyakit Jantung sejak Muda, Simak Saran Dokter", R.drawable.kesehatan,
                "tempo.co", "Jumat, 2 Oktober 2020 16:05 WIB",
                "TEMPO.CO, Jakarta - Kementerian Kesehatan pada 2013 mengestimasi sebanyak 39 persen penderita penyakit jantung di tanah air berusia kurang dari 44 tahun. Dari jumlah itu, sebanyak 22 persen di antaranya berusia 15–35 tahun, yang tergolong usia produktif."));

    }


}
