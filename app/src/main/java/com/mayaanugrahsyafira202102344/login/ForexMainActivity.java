package com.mayaanugrahsyafira202102344.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {


    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView usdTextView, idrTextView, jpyTextView, krwTextView, myrTextView, sarTextView, sgdTextView, thbTextView, tryTextView, sekTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);
        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        usdTextView = (TextView) findViewById(R.id.usdTextView);
        idrTextView = (TextView) findViewById(R.id.idrTextView);
        jpyTextView = (TextView) findViewById(R.id.jpyTextView);
        krwTextView = (TextView) findViewById(R.id.krwTextView);
        myrTextView = (TextView) findViewById(R.id.myrTextView);
        sarTextView = (TextView) findViewById(R.id.sarTextView);
        sgdTextView = (TextView) findViewById(R.id.sgdTextView);
        thbTextView = (TextView) findViewById(R.id.thbTextView);
        tryTextView = (TextView) findViewById(R.id.tryTextView);
        sekTextView = (TextView) findViewById(R.id.sekTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout(){
        swipeRefreshLayout1.setOnRefreshListener( () -> {
            initForex();

            swipeRefreshLayout1.setRefreshing(false);
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url ="https://openexchangerates.org/api/latest.json?app_id=94772d8ad68e4e73bb1e4d6ba656b2e7";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody), ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getRatesModel();

                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double jpy = ratesModel.getIDR() / ratesModel.getJPY();
                double krw = ratesModel.getIDR() / ratesModel.getKRW();
                double myr = ratesModel.getIDR() / ratesModel.getMYR();
                double sar = ratesModel.getIDR() / ratesModel.getSAR();
                double sgd = ratesModel.getIDR() / ratesModel.getSGD();
                double thb = ratesModel.getIDR() / ratesModel.getTHB();
                double TRY = ratesModel.getIDR() / ratesModel.getTRY();
                double sek = ratesModel.getIDR() / ratesModel.getSEK();
                double idr = ratesModel.getIDR();

                usdTextView.setText(formatNumber(usd, "###,##0.##"));
                jpyTextView.setText(formatNumber(jpy, "###,##0.##"));
                krwTextView.setText(formatNumber(krw, "###,##0.##"));
                myrTextView.setText(formatNumber(myr, "###,##0.##"));
                sarTextView.setText(formatNumber(sar, "###,##0.##"));
                sgdTextView.setText(formatNumber(sgd, "###,##0.##"));
                thbTextView.setText(formatNumber(thb, "###,##0.##"));
                tryTextView.setText(formatNumber(TRY, "###,##0.##"));
                sekTextView.setText(formatNumber(sek, "###,##0.##"));
                idrTextView.setText(formatNumber(idr, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }

}