package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
/** С�۷�: �Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	private int xSpeed; //x�����ƶ��ٶ�
	private int ySpeed; //y�����ƶ��ٶ�
	private int awardType; //��������
	/** ���췽�� */
	public Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0��1֮��������
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		x+=xSpeed; //x+(���������)
		y+=ySpeed; //y+(����)
		if(x<=0 || x>=World.WIDTH-this.width) { //����ͷ��
			xSpeed*=-1; //���л�����(���为��������)
		}
	}
	
	int index = 1; //���˵��±�
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() { //ÿ10������һ��
		if(isLife()) { //�����ŵģ�����images[0]
			return images[0];
		}else if(isDead()) { //�����˵�
			BufferedImage img = images[index++]; //��ȡ����ͼ
			if(index==images.length) { //�������һ����
				state = REMOVE; //����ǰ״̬�޸�ΪREMOVE
			}
			return img;
		}
		return null; //ɾ���ģ�����null
	}
	
	/** ��дgetAwardType()��ȡ�������� */
	public int getAwardType() {
		return awardType; //���ؽ�������
	}
	
}



















