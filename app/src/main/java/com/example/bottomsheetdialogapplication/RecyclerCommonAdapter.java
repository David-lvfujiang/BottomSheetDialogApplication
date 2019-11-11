package com.example.bottomsheetdialogapplication;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Map;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/30
 * @Describe:
 */
public class RecyclerCommonAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {


    public RecyclerCommonAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setImageResource(R.id.img,item);
    }
}
