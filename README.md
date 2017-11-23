#####还是可以优化的   对于一些大图说明会有空格  之后优化<br>
#1.使用
    /**
     * initGuide
     */
    private void initGuide() {
        showtips = new ShowTipsBuilder(MainActivity.this)
                .setTarget(findViewById(R.id.tv_main1))
                .setBitmapRes(R.drawable.guidance_img_dier)//?????????????
                .setDescriptionBitmapRes(R.drawable.guidance_img_dieri_shuoming)//???y????????
                .setDelay(800)
                .build();
        showtips.setId(R.id.guide1);
        showtips.show(MainActivity.this);
        showtipsType = showtips;
        showtips.setOnClickListener(this);
    }
#2.代码
    @SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		/*
		 * Draw circle and transparency background
		 */

		Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas temp = new Canvas(bitmap);
		Paint paint = new Paint();
		if (background_color != 0)
			paint.setColor(background_color);
		else
			paint.setColor(Color.parseColor("#000000"));
		paint.setAlpha(204);
		temp.drawRect(0, 0, temp.getWidth(), temp.getHeight(), paint);
		
		 
		Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), getBitmapRes()).copy(Bitmap.Config.ARGB_8888, true);


		Paint transparentPaint = new Paint();
		transparentPaint.setColor(getResources().getColor(android.R.color.transparent));
		transparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

		int x = showhintPoints.x;
		int y = showhintPoints.y;
		temp.drawBitmap(bitmap2, x-bitmap2.getWidth()/2, y-bitmap2.getHeight()/2, transparentPaint);
		temp.drawBitmap(bitmap2, x-bitmap2.getWidth()/2, y-bitmap2.getHeight()/2, new Paint());

		canvas.drawBitmap(bitmap, 0, 0, new Paint());

	}
#3.效果
 ![image](https://github.com/zcc2/GuidePage/raw/master/p1.jpg)
  ![image](https://github.com/zcc2/GuidePage/raw/master/p2.jpg)