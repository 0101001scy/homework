public class Passenger {
    private String id;
    private String passengerFullName;
    private String departureDate;
    private String returnDate;
    private int childPassengers;
    private int adultPassengers;

    public Passenger() {
    }

    public Passenger(String id, String passengerFullName, String departureDate, String returnDate, int childPassengers, int adultPassengers ) {
        this.id = id;
        this.passengerFullName =passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpassengerFullName () {
        return passengerFullName;
    }

    public void setpassengerFullName(String passengerFullName) {
        this.passengerFullName = passengerFullName;
    }

    public String getdepartureDate() {
        return departureDate;
    }

    public void setdepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getchildPassengers() {
        return childPassengers;
    }

    public void setchildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }

    public int getadultPassengers() {
        return adultPassengers;
    }

    public void setadultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }
}
import java.util.ArrayList;
        import java.util.Scanner;

public class test {
    static ArrayList<Passenger> passengers = new ArrayList<>();                 //定义乘客集合
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            show1();
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {
                case 1 -> show();
                case 2 -> add();
                case 3 -> delete();
                case 4 -> modify();
                case 5 -> search();

                default -> System.out.println("请输入正确序号！");
            }
        }
    }


    static void show1() {
        System.out.println("********************************************************");
        System.out.println("**************        乘客信息管理系统       **************");
        System.out.println("**************        1.显示信息        **************");
        System.out.println("**************        2.增加信息        **************");
        System.out.println("**************        3.删除信息        **************");
        System.out.println("**************        4.修改信息        **************");
        System.out.println("**************        5.查找信息        **************");
        System.out.println("**************        0.退出系统           **************");
        System.out.println("********************************************************");
        System.out.print("请选择其功能:");
    }

    static void show() {                     //显示乘客信息
        for (int i = 0; i < passengers.size(); i++) {
            final Passenger passenger = passengers.get(i);
            System.out.println("Dear" + passenger.getpassengerFullName() + ". Thank you for booking your flight with FLIGHT_COMPANY.");
            System.out.println("Following are the details of your booking and the trip:");

            System.out.println("Ticket Number:" + getId());

            System.out.println("From TRIP_SOURCE to TRIP_DESTINATION");
            System.out.println("Date of departure:" + getdepartureDate());
            System.out.println("Date of return:" + passenger.getreturnDate());
            System.out.println("Total passengers:" + getchildPassengers() + getadultPassengers());
            System.out.println("Total ticket price in Euros:" + (getchildPassengers() + getadultPassengers()) * 1000);

        }

    }

    static void add() {                      //增加乘客信息
        System.out.print("请输入您要添加乘客的个数:");
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            System.out.print("请输入您要添加的票号:");
            String str = sc.next();
            int count = 0;
            for (final Passenger passenger : passengers) {
                if (passenger.getId().equals(str)) {
                    System.out.println("已有此人！");
                    break;
                }
                count++;
            }
            if (count == passengers.size()) {
                System.out.print("姓名:");
                String str1 = sc.next();
                System.out.print("出发日期(yyyy-mm-dd):");
                String str2 = sc.next();
                System.out.print("返回日期(yyyy-mm-dd):");
                String str3 = sc.next();
                System.out.print("儿童人数:");
                String str4 = sc.next();
                System.out.print("成人人数:");
                int str5 = sc.nextInt();
                Passenger passenger = new Passenger(str, str1, str2, str3, str4, str5);
                passengers.add(passenger);
                System.out.println("添加成功！");
            }
        }
    }

    static void delete() {                       //删除乘客信息
        System.out.print("请输入您要删除的票号:");
        String str = sc.next();
        int a = passengers.size();
        int count = 0;
        for (int i = 0; i < passengers.size(); i++) {
            final Passenger passenger = passengers.get(i);
            if (passenger.getId().equals(str)) {
                passengers.remove(i);
                System.out.println("删除成功！");
                break;
            }
            count++;
        }
        if (count == a) {
            System.out.println("查无此人！");
        }
    }

    static void modify() {                          //修改乘客信息
        System.out.print("请输入您要修改的票号:");
        String str = sc.next();
        int count = 0;
        for (final Passenger passenger : passengers) {
            if (passenger.getId().equals(str)) {
                while (true) {
                    System.out.println("**************************************");
                    System.out.println("**********      1.姓名       *********");
                    System.out.println("**********      2.出发日期       *********");
                    System.out.println("**********      3.返回日期    *********");
                    System.out.println("**********      4.儿童人数       *********");
                    System.out.println("**********      5.成人人数       *********");

                    System.out.println("**************************************");
                    System.out.print("请输入您要修改的选项:");
                    int a = sc.nextInt();
                    if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5) {
                        System.out.print("修改为:");
                        String str0 = sc.next();
                        switch (a) {
                            case 1 -> passenger.setpassengerFullName(str0);
                            case 2 -> passenger.setdepartureDate(str0);
                            case 3 -> passenger.setreturnDate(str0);
                            case 4 -> passenger.setchildPassengers(Integer.parseInt(str0));
                            case 5 -> passenger.setadultPassengers(Integer.parseInt(str0));
                        }
                        System.out.println("修改成功！");
                        break;
                    } else {
                        System.out.println("请输入正确的序号！");
                    }
                }
                break;
            }
            count++;
        }
        if (count == passengers.size()) {
            System.out.println("查无此人！");
        }
    }

    static void search() {                          //查找乘客信息
        System.out.print("请输入您要查找的票号:");
        String str = sc.next();
        int count = 0;
        for (final Passenger passenger : passengers) {
            if (passenger.getId().equals(str)) {
                for (int i = 0; i < passengers.size(); i++) {
                    final Passenger passenger = passengers.get(i);
                    System.out.println("Dear" + passenger.getpassengerFullName() + ". Thank you for booking your flight with FLIGHT_COMPANY.");
                    System.out.println("Following are the details of your booking and the trip:");

                    System.out.println("Ticket Number:" + getId());

                    System.out.println("From TRIP_SOURCE to TRIP_DESTINATION");
                    System.out.println("Date of departure:" + getdepartureDate());
                    System.out.println("Date of return:" + passenger.getreturnDate());
                    System.out.println("Total passengers:" + getchildPassengers() + getadultPassengers());
                    System.out.println("Total ticket price in Euros:" + (getchildPassengers() + getadultPassengers()) * 1000);

                }

                break;
            }
            count++;
        }
        if (count == passenger.size()) {
            System.out.println("查无此人！");
        }
    }
}