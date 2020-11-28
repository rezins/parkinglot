package positionlot.util;

import java.util.ArrayList;
import java.util.List;

public class Command {

    List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }



    public Command(){

        list.add("create_parking_lot");
        list.add("park");
        list.add("leave");
        list.add("status");
        list.add("registration_numbers_for_cars_with_colour");
        list.add("slot_numbers_for_cars_with_colour");
        list.add("slot_number_for_registration_number");
        list.add("exit");

    }

}
