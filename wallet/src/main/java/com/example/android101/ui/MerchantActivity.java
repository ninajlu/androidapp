package com.example.android101.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android101.R;
import com.example.android101.WalletActivity;
import com.example.android101.data.MockData;
import com.example.android101.data.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by square on 1/8/14.
 */
public class MerchantActivity extends WalletActivity {
    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isFinishing()) return;
        User user = MockData.findUserByToken(this.getIntent().getStringExtra("user_token"));
        setContentView(R.layout.merchant_activity);
        layout=(RelativeLayout) findViewById(R.id.relative_layout);
        TextView name=(TextView)findViewById(R.id.merchant_name);
        name.setText(user.name);
        TextView email=(TextView)findViewById(R.id.merchant_email);
        email.setText(user.email);
        ImageView image=(ImageView)findViewById(R.id.merchant_image);
        Picasso.with(this)
                .load(user.getCuratedUri())
                .resize(layout.getWidth(),layout.getHeight() )
                .centerCrop()
                .placeholder(R.drawable.app_icon)
                .into(image);
    }
}
