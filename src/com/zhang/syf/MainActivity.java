package com.zhang.syf;

import com.itheima.syf.R;

import android.os.Bundle;
import android.renderscript.Script;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//������ʾ �������ͼƬ
		final ImageView iv = (ImageView) findViewById(R.id.iv);
		
		//[1]��ȡҪ����ͼƬ ԭͼ
		Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pre19);
		
		//[2]����һ������   �൱����һ����ԭͼ��С�İ�ֽ
		final Bitmap alterBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
		//��������
		Paint paint = new Paint();
		//��������   �Ѱ�ֽ�̵�������
		Canvas canvas = new Canvas(alterBitmap);
		//��ʼ���� 
		canvas.drawBitmap(srcBitmap, new Matrix(), paint);
		
		iv.setImageBitmap(alterBitmap);
		
		//[3]��vi����һ�������¼� 
		iv.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				//[4]�����ж�һ�´����¼� 
				switch (event.getAction()) {
				
				case MotionEvent.ACTION_MOVE://�ƶ��¼�
					
					for (int i = -7; i < 7; i++) { //����X������
						
						for (int j = -7; j < 7; j++) {
							                       //����Y������
							
							//Ϊ�����õ��û�����  ˺һ��Բ 
							if (Math.sqrt(i*i+j*j)<7) {
								
								try {
									alterBitmap.setPixel((int)event.getX()+i, (int)event.getY()+j, Color.TRANSPARENT);
								} catch (Exception e) {
								}
							}
							
						}
					}
					
					//����һ��iv
					iv.setImageBitmap(alterBitmap);
					break;

				}
				
				return true;
			}
		});
		
		
		
		
		
	}

	

}
