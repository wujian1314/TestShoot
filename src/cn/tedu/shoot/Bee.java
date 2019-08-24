package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
/** 小蜜蜂: 是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	private int xSpeed; //x坐标移动速度
	private int ySpeed; //y坐标移动速度
	private int awardType; //奖励类型
	/** 构造方法 */
	public Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0到1之间的随机数
	}
	
	/** 重写step()移动 */
	public void step() {
		x+=xSpeed; //x+(向左或向右)
		y+=ySpeed; //y+(向下)
		if(x<=0 || x>=World.WIDTH-this.width) { //到两头了
			xSpeed*=-1; //则切换方向(正变负，负变正)
		}
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
	}
	
	/** 重写getAwardType()获取奖励类型 */
	public int getAwardType() {
		return awardType; //返回奖励类型
	}
	
}



















