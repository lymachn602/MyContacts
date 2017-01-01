package com.example.linyuming.mycontacts;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wolf on 2016/11/10.
 */
public class FindDialog extends Dialog{
    private Context l_context;
    public FindDialog(Context context){
        super(context);
        l_context=context;
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        setTitle("查询联系人");
        final Button find=(Button) findViewById(R.id.find);
        Button cannel=(Button)findViewById(R.id.cancel);
        find.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText value= (EditText) findViewById(R.id.value);
                ContactsTable ct=new ContactsTable(l_context);
                //模糊查询联系人
                User[] users=ct.findUserByKey(value.getText().toString());
                for (int i=0;i<users.length;i++){
                    System.out.println("姓名:"+users[i].getName()+",电话"+users[i].getMobile());
                }
                //主界面的数据更新
                ((MainActivity)l_context).setUsers(users);
                //刷新联系人列表显示
                ((MainActivity)l_context).getListViewAdapter().notifyDataSetChanged();
                //设置被选中的项目
                ((MainActivity)l_context).setSelectItem(0);
                dismiss();
            }
        });
        cannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
