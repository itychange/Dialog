package com.pokemon.pc.dialog;

/**
 * Created by PC on 8/2/2016.
 */
        private void showDialogMls() {
        if( transactionDialog != null && transactionDialog.isShowing() ) return;

       transactionDialog = com.lmi_wao.dev.view.dialog.AlertDialog.create(this);
        transactionDialog
                .setTitleText(R.string.title_scan_not_success)
                .setType(R.string.label_title_dialog)
                .setRightButton(R.string.title_confirm_detail_qr_yes, new com.lmi_wao.dev.view.dialog.AlertDialog.ClickListener() {
                    @Override
                    public void onClick() {
                        transactionDialog.dismiss();
                        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
                        cTimer.start();

                    }
                })
                .setLeftButton(R.string.title_confirm_detail_qr_no, new com.lmi_wao.dev.view.dialog.AlertDialog.ClickListener() {
                    @Override
                    public void onClick() {
                        transactionDialog.dismiss();
                        finish();
                    }
                });
        if( transactionDialog != null && transactionDialog.isShowing() ) {
            transactionDialog.dismiss();
        }else{
            transactionDialog.show();
        }
    }

