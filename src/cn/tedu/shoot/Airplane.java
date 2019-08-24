package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 小敌机: 是飞行物，也能得分 */
public class Airplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	
	private int speed; //移动速度
	/** 构造方法 */
	public Airplane(){
		super(49,36);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed; //y+(向下)
	}
	
	int index = 1; //死了的下标
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() { //每10毫秒走一次
		if(isLife()) { //若活着的，返回images[0]
			return images[0];
		}else if(isDead()) { //若死了的
			BufferedImage img = images[index++]; //获取爆破图
			if(index==images.length) { //若到最后一张了
				state = REMOVE; //将当前状态修改为REMOVE
			}
			return img;
		}
		return null; //删除的，返回null
		/*
		 *                   index=1
		 * 10M img=images[1] index=2                返回images[1]
		 * 20M img=images[2] index=3                返回images[2]
		 * 30M img=images[3] index=4                返回images[3]
		 * 40M img=images[4] index=5(REMOVE) 返回images[4]
		 * 50M 返回null
		 */
	}
	
	/** 重写getScore()得分 */
	public int getScore() {
		return 1; //打掉小敌机，得1分
	}
	
}















