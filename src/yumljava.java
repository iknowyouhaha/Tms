import java.util.Scanner;
/**
  ��ʦ��Ϣ����ϵͳ
  ÿ����ʦ��Ϣ���浽������
  ��ʦ���󱣴浽������
*/
public class Tmt {
	private Teacher[] stus;//���ڴ洢��ʦ����Ϣ
	private int index;	//���ڼ�¼�������ܹ��м�����ʦ

	//���캯�����ڳ�ʼ�������зǾ�̬����
	public Tmt(){
		stus = new Teacher[3];
		index = 0;
	}

	/**
	  ����
	  @param  ��ʦ����
	*/
	public void save(Teacher stu){
		//����ĳ��Ȳ����Ա����ʦ�ˣ��������չ
		if(index >= stus.length){
			Teacher[] demo = new Teacher[stus.length + 3];
			//���鿽����stus -> demo
			System.arraycopy(stus,0,demo,0,index);
			stus = demo;
		}
		stus[index++] = stu;
	}

	/**
	  ��ѯ���еĽ�ʦ
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
		ͨ����ʦ��id���ҽ�ʦ����Ϣ
		 {{1001,terry,32},{1002,terry,32},null}
		 1002
	*/
	public Teacher queryById(long id){
		//��ȡ��id���������е�����
		int num = getIndexById(id);
		return num == -1?null:stus[num];
	}

	/**
		ͨ��id��ȡ���Ϊ��id�Ľ�ʦ�������е�λ��
		 {{1001,terry,32},{1002,terry,32},null}
		id = 1002
		 1
	*/
	private int getIndexById(long id){
		int num = -1;//�ý�ʦ�Ҳ���
		for(int i=0;i<index;i++){
			if(stus[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}
	
	public void menu(){
		System.out.println("********��ʦ����ϵͳ********");
		System.out.println("*1. ��ѯ���н�ʦ��Ϣ");
		System.out.println("*2. ¼���ʦ��Ϣ");
		System.out.println("*3. ɾ����ʦ��Ϣ");
		System.out.println("*4. ��ѯ������ʦ��Ϣ");
		System.out.println("*5. �޸Ľ�ʦ��Ϣ");
		System.out.println("*exit. �˳�");
		System.out.println("*help. ����");
		System.out.println("****************************");
	}
	/**
		������
	*/
	public static void main(String[] args){
		Tmt tmt = new Tmt();
		tmt.menu();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("�����빦�ܺţ�");
			String option = sc.nextLine();
			//System.out.println("�����ˣ�"+option);
			switch(option){
				case "1":
					System.out.println("�����ǽ�ʦ����Ϣ��");
					Teacher[] arr = tmt.queryAll();
					for(int i=0;i<arr.length;i++){
						System.out.println(arr[i]);
					}
					System.out.println("�ܼ� "+tmt.index+" ��");
					break;
				case "2":
					while(true){
						System.out.println("�������ʦ��Ϣ��id#name#age���������롾break��������һ��Ŀ¼");
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
						System.out.println("����ɹ���");
					}
					
					break;
				case "3":
					break;
				case "4":
					while(true){
						System.out.println("������ѧ�Ż������롾break��������һ��Ŀ¼");
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
					System.out.println("bye bye,��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				case "help":
					tst.menu();
					break;
				default:
					System.out.println("���Ϸ����룡");

			}
		}
	}
}