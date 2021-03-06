import java.util.Scanner;
/**
  教师信息管理系统
  每个教师信息保存到对象中
  教师对象保存到数组中
*/
public class Tmt {
	private Teacher[] stus;//用于存储教师的信息
	private int index;	//用于记录数组中总共有几个教师

	//构造函数用于初始化对象中非静态属性
	public Tmt(){
		stus = new Teacher[3];
		index = 0;
	}

	/**
	  保存
	  @param  教师对象
	*/
	public void save(Teacher stu){
		//数组的长度不足以保存教师了，数组的扩展
		if(index >= stus.length){
			Teacher[] demo = new Teacher[stus.length + 3];
			//数组拷贝，stus -> demo
			System.arraycopy(stus,0,demo,0,index);
			stus = demo;
		}
		stus[index++] = stu;
	}

	/**
	  查询所有的教师
	  stus= new Teacher[3];
	  {{1001,terry,32},{1002,terry,32},null}
	  {{1001,terry,32},{1002,terry,32}}
	  index = 1
	*/
	public Teacher[] queryAll(){
	        Teacher[] demo = new Teacher[index];
		System.arraycopy(stus,0,demo,0,index);
		return demo;
	}

	/**
		通过教师的id查找教师的信息
		 {{1001,terry,32},{1002,terry,32},null}
		 1002
	*/
	public Teacher queryById(long id){
		//获取该id所在数组中的索引
		int num = getIndexById(id);
		return num == -1?null:stus[num];
	}

	/**
		通过id获取编号为该id的教师在数组中的位置
		 {{1001,terry,32},{1002,terry,32},null}
		id = 1002
		 1
	*/
	private int getIndexById(long id){
		int num = -1;//该教师找不到
		for(int i=0;i<index;i++){
			if(stus[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}
	
	public void menu(){
		System.out.println("********教师管理系统********");
		System.out.println("*1. 查询所有教师信息");
		System.out.println("*2. 录入教师信息");
		System.out.println("*3. 删除教师信息");
		System.out.println("*4. 查询单个教师信息");
		System.out.println("*5. 修改教师信息");
		System.out.println("*exit. 退出");
		System.out.println("*help. 帮助");
		System.out.println("****************************");
	}
	/**
		主方法
	*/
	public static void main(String[] args){
		Tmt tmt = new Tmt();
		tmt.menu();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("请输入功能号：");
			String option = sc.nextLine();
			//System.out.println("接收了："+option);
			switch(option){
				case "1":
					System.out.println("以下是教师的信息：");
					Teacher[] arr = tmt.queryAll();
					for(int i=0;i<arr.length;i++){
						System.out.println(arr[i]);
					}
					System.out.println("总计 "+tmt.index+" 个");
					break;
				case "2":
					while(true){
						System.out.println("请输入教师信息【id#name#age】或者输入【break】返回上一级目录");
						String stuStr = sc.nextLine();
						if(stuStr.equals("break")){
							break;
						}
						//1001#terry#32
						String[] stuArr = stuStr.split("#");
						long id = Long.parseLong(stuArr[0]);
						String name = stuArr[1];
						int age = Integer.parseInt(stuArr[2]);
						Teacher stu = new Teacher(id,name,age);
						tmt.save(stu);
						System.out.println("保存成功！");
					}
					
					break;
				case "3":
					break;
				case "4":
					while(true){
						System.out.println("请输入学号或者输入【break】返回上一级目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//1001#terry#32
						long id = Long.parseLong(idStr);
						Teacher stu = tst.queryById(id);
						System.out.println(stu==null?"sorry,not found!":stu);
					}
					break;
				case "5":
					break;
				case "exit":
					System.out.println("bye bye,欢迎再次使用！");
					System.exit(0);
				case "help":
					tst.menu();
					break;
				default:
					System.out.println("不合法输入！");

			}
		}
	}
}