package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** ���: �Ƿ����� */
public class Sky extends FlyingObject{
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	
	private int speed; //�ƶ��ٶ�
	private int y1; //��2��ͼ��y����
	/** ���췽�� */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y+=speed;  //y+(����)
		y1+=speed; //y1+(����)
		if(y>=World.HEIGHT) { //��y>=���ڵĸ�
			y=-World.HEIGHT;  //���޸�y��ֵΪ���Ĵ��ڵĸ�(�Ƶ�������)
		}
		if(y1>=World.HEIGHT) { //��y1>=���ڵĸ�
			y1=-World.HEIGHT;  //���޸�y1��ֵΪ���Ĵ��ڵĸ�(�Ƶ�������)
		}
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() {
		return image; //ֱ�ӷ���image����
	}
	
	/** ��дpaintObject()������ */
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
		g.drawImage(this.getImage(),this.x,this.y1,null);
	}
	
}


















