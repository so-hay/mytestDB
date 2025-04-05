package  data;

public  class  Customer {
  private  String no;
  private  String name;
  private  int money;

  public  Customer(){
  }
  public  Customer(String no, String name, int  money){
    this.no = no;
    this.name =name;
    this.money = money;
  }

  public  String getNo(){
    return  no;
  }
  public  void  setNo(String no){
    this.no = no;
  }
   public  String getName(){
    return name;
  }
  public  void  setName(String name){
    this.name = name;
  }
   public  int  getMoney(){
    return money;
  }
  public  void  setMoney(int money){
    this.money = money;
  }
}