package kr.ac.sookmyung.snowi;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private Button positiveButton;
    private Button negativeButton;
    private EditText editdevname;//??
    private EditText editsort;//??불확실
    private Context context;

    private CustomDialogListener customDialogListener;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }


    //인터페이스 설정
    interface CustomDialogListener{
        void onPositiveClicked(String devname, String sort);
        void onNegativeClicked();
    }

    //호출할 리스너 초기화
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;//nonstatic으로 바꿨음
    }




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_custom);

        //init
        positiveButton = (Button)findViewById(R.id.positiveButton);
        negativeButton = (Button)findViewById(R.id.negativeButton);
        editdevname = (EditText)findViewById(R.id.editdevname);
        editsort = (EditText)findViewById(R.id.editsort);


        //버튼 클릭 리스너 등록
        positiveButton.setOnClickListener(this);
        negativeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.positiveButton: //확인 버튼을 눌렀을 때
                //각각의 변수에 EidtText에서 가져온 값을 저장
                String devname = editdevname.getText().toString();
                String sort = editsort.getText().toString();

                //인터페이스의 함수를 호출하여 변수에 저장된 값들을 Activity로 전달
                //ustomDialogListener.onPositiveClicked(); ??onpositive~에 지정한 변수가 name, address, X(3개 지정 변수)
                dismiss();
                break;
            case R.id.negativeButton: //취소 버튼을 눌렀을 때
                cancel();
                break;
        }
    }
}