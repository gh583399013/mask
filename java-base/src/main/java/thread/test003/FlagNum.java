package thread.test003;

public class FlagNum {
	private boolean flag;
	private int count;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public FlagNum(boolean flag, int count) {
		super();
		this.flag = flag;
		this.count = count;
	}
	
}
