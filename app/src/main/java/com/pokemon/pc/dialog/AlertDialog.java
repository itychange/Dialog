package com.pokemon.pc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nguyenbon on 6/30/16.
 */
public class AlertDialog extends Dialog {
    private Button mLeftButton, mRightButton;
    private TextView alert_type;
    private TextView tvTitle;
    private int resAlertImage;
    private String title, message, leftButtonText, rightButtonText,txttype;
    private SpannableStringBuilder spannableStringBuilderTitle;
    private ClickListener leftButtonClickListener, rightButtonClickListener;

    public AlertDialog(Context context) {
        super(context);
    }

    public static AlertDialog create(Context context) {
        return new AlertDialog(context);
    }
    public static AlertDialog create(Context context, String title) {
        return new AlertDialog(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable());
        setCancelable(true);
        setContentView(R.layout.dialog_alert_message);
        initViews();
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        mLeftButton = (Button) findViewById(R.id.button_left);
        mRightButton = (Button) findViewById(R.id.button_right);
        alert_type= (TextView) findViewById(R.id.alert_type);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }


    public AlertDialog setTitleText(@StringRes int title) {
        this.setTitleText(getContext().getString(title));
        return this;
    }

    public AlertDialog setTitleText(String title) {
        this.title = title;
        return this;
    }



    public AlertDialog setType(@StringRes int title) {
        this.setType(getContext().getString(title));
        return this;
    }

    public AlertDialog setType(String type) {
        this.txttype = type;
        return this;
    }



    public AlertDialog setTitleText(SpannableStringBuilder spannableStringBuilder) {
        this.spannableStringBuilderTitle = spannableStringBuilder;
        return this;
    }

    public AlertDialog setMessage(@StringRes int message) {
        this.setMessage(getContext().getString(message));
        return this;
    }

    public AlertDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public AlertDialog setLeftButton(@StringRes int label, ClickListener clickListener) {
        return setLeftButton(getContext().getString(label), clickListener);
    }

    public AlertDialog setLeftButton(String label, ClickListener clickListener) {
        this.leftButtonText = label;
        this.leftButtonClickListener = clickListener;
        return this;
    }

    public AlertDialog setRightButton(@StringRes int label, ClickListener clickListener) {
        return setRightButton(getContext().getString(label), clickListener);
    }

    public AlertDialog setRightButton(String label, ClickListener clickListener) {
        this.rightButtonText = label;
        this.rightButtonClickListener = clickListener;
        return this;
    }

    public AlertDialog setAlertImage(@DrawableRes int res) {
        this.resAlertImage = res;
        return this;
    }

    @Override
    public void show() {
        super.show();
        setupDialog();
    }

    private void setupDialog() {
        if (title == null || title.isEmpty()) {
            if (spannableStringBuilderTitle == null || spannableStringBuilderTitle.toString().isEmpty()) {
                tvTitle.setVisibility(View.GONE);
            } else {
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(spannableStringBuilderTitle);
            }
        } else {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }

        if (txttype == null || txttype.isEmpty()) {
            if (spannableStringBuilderTitle == null || spannableStringBuilderTitle.toString().isEmpty()) {
                alert_type.setVisibility(View.GONE);
            } else {
                alert_type.setVisibility(View.VISIBLE);
                alert_type.setText(spannableStringBuilderTitle);
            }
        } else {
            alert_type.setVisibility(View.VISIBLE);
            alert_type.setText(txttype);
        }


        if (leftButtonText != null) {
            mLeftButton.setText(leftButtonText);
            mLeftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();

                    if (leftButtonClickListener != null) {
                        leftButtonClickListener.onClick();
                    }
                }
            });
        } else {
            mLeftButton.setVisibility(View.GONE);
        }

        if (rightButtonText != null) {
            mRightButton.setText(rightButtonText);
            mRightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();

                    if (rightButtonClickListener != null) {
                        rightButtonClickListener.onClick();
                    }
                }
            });
        } else {
            mRightButton.setVisibility(View.GONE);
        }
    }

    public interface ClickListener {
        void onClick();
    }
}
