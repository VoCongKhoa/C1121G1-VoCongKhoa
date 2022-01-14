package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls;

import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models.ElectricProduct;

import java.util.Comparator;

public class SortByName implements Comparator<ElectricProduct> {
    @Override
    public int compare(ElectricProduct o1, ElectricProduct o2) {
        return o1.getName().compareTo(o2.getName());
//        if (o1.getName().equals(o2.getName())) {
//            return 0;
//        } else if (o1.getPrice() < o2.getPrice()) {
//            return -1;
//        } else {
//            return 1;
//        }
    }
}
